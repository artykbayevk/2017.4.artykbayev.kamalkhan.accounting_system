'use strict';

const gulp = require('gulp');
const ser = gulp.series;
const par = gulp.parallel;
const task = gulp.task;
const del = require('del');
const less = require('gulp-less');
const path = require('path');
const pug = require('gulp-pug');
const browserSync = require('browser-sync').create();
const webpack = require('webpack');
const gulpLog = require('gulplog');
const notifier = require('node-notifier');

let isWatch = false;

function outDir() {
    return path.resolve(__dirname, 'build', 'public');
}

task('clean', function () {
    return del(['build']);
});

task('copy', function () {
    return gulp.src([
        "node_modules/zone.js/dist/zone.min.js",
        "node_modules/core-js/client/shim.min.js"
    ]).pipe(gulp.dest(outDir()));
});

task('less', function () {
    return gulp.src("front/less/*.less").pipe(less()).pipe(gulp.dest(outDir()));
});

task('pug', function () {
    return gulp.src("front/pug/index.pug").pipe(pug({pretty: true})).on("error", console.log)
        .pipe(gulp.dest(outDir()));
});

task('assets', ser('less', 'pug'));

task('webpack', function (callback) {

    let options = {
        entry: [path.resolve('.', 'front', 'ts', 'main.ts')],
        output: {
            path: outDir(),
            publicPath: '/',
            filename: '[name].js',
            sourceMapFilename: '[name].js.map',
        },
        watch: true,
        devtool: 'cheap-module-inline-source-map',
        module: {
            loaders: [{
                test: /\.ts$/,
                include: path.resolve(__dirname, 'front', 'ts'),
                loader: ['ts-loader'],
            }],
        },
        resolve: {
            extensions: [".ts", ".js"]
        },
        plugins: [
            new webpack.NoEmitOnErrorsPlugin() // otherwise error still gives a file
        ]
    };

    webpack(options, function (err, stats) {
        if (!err) { // no hard error
            // try to get a soft error from stats
            err = stats.toJson().errors[0];
        }

        if (err) {
            notifier.notify({
                title: 'Webpack',
                message: err
            });

            gulpLog.error(err);
        } else {
            gulpLog.info(stats.toString({
                colors: true
            }));
        }

        // task never errs in watch mode, it waits and recompile
        if (!options.watch && err) {
            callback(err);
        } else {
            callback();
        }

    });
});

task('server', function (back) {
    browserSync.init({server: path.resolve('build', 'public')});

    browserSync.watch('build/public/**/*.*').on('change', browserSync.reload);

    back();
});

task('start', ser(
    'clean', 'assets', 'copy', 'webpack', 'server',
    function () {
        gulp.watch('front/pug/**/*.pug', ser('pug'));
        gulp.watch('front/less/**/*.less', ser('less'));
    }
));


