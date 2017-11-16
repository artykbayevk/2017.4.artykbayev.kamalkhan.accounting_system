const gulp = require('gulp');
const concat = require('gulp-concat');
const browserSync = require('browser-sync').create();

var devMode = false;

gulp.task('css', function() {
    gulp.src("./public/stylesheets/main.css")
        .pipe(concat('main.css'))
        .pipe(gulp.dest('dist/css'))
        .pipe(browserSync.reload({
            stream: true
        }));
});

gulp.task('material', function () {
    return gulp.src("./node_modules/angular-material/**/*")
        .pipe(gulp.dest('./dist/css/angular-material/'));
})

gulp.task('angular', function() {
    gulp.src([
        "./public/javascripts/vendors/angular.js",
        "./public/javascripts/vendors/angular-ui-router.js",
        "./public/javascripts/vendors/angular-animate.js",
        "./public/javascripts/vendors/angular-aria.js",
        "./public/javascripts/vendors/angular-material.js",
        "./node_modules/angular-messages/angular-messages.js",
        "./node_modules/angular-sanitize/angular-sanitize.js",
    ])
        .pipe(concat('angular.js'))
        .pipe(gulp.dest('./dist/js'))
        .pipe(browserSync.reload({
            stream: true
        }));
});

gulp.task('app', function() {
    gulp.src("./public/javascripts/app.js")
        .pipe(concat('app.js'))
        .pipe(gulp.dest('./dist/js'))
        .pipe(browserSync.reload({
            stream: true
        }));
});

gulp.task('controllers', function() {
    gulp.src("./public/javascripts/controllers/*.js")
        .pipe(concat('controllers.js'))
        .pipe(gulp.dest('./dist/js'))
        .pipe(browserSync.reload({
            stream: true
        }));
});

gulp.task('html', function() {
    return gulp.src('./public/templates/**/*.html')
        .pipe(gulp.dest('./dist/'))
        .pipe(browserSync.reload({
            stream: true
        }));
});

gulp.task('fonts',function(){
    return gulp.src(['./public/fonts/**/*'])
        .pipe(gulp.dest('./dist/fonts/'));
})

gulp.task('css-lib',function(){
    return gulp.src(['./public/stylesheets/lib/**/*'])
        .pipe(gulp.dest('./dist/css/lib/'));
})

gulp.task('build', function() {
    gulp.start(['angular','controllers','app','css','material','css-lib','html','fonts'])
});

gulp.task('browser-sync', function() {
    browserSync.init(null, {
        open: false,
        server: {
            baseDir: 'dist',
        }
    });
});

gulp.task('start', function() {
    devMode = true;
    gulp.start(['build', 'browser-sync']);
    gulp.watch(['./public/stylesheets/main.css'], ['css']);
    gulp.watch(['./public/javascripts/controllers/*.js'], ['controllers']);
    gulp.watch(['./public/javascripts/*.js'], ['app']);
    gulp.watch(['./public/templates/views/*.html'], ['html']);
    gulp.watch(['./public/templates/*.html'], ['html']);
});