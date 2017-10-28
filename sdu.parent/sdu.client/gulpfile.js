const gulp = require('gulp');
const concat = require('gulp-concat');
const browserSync = require('browser-sync').create();


// Some pointless comments for our project.

var devMode = false;

gulp.task('css-lib', function() {
    gulp.src("./public/stylesheets/**/*.css")
        .pipe(concat('lib.css'))
        .pipe(gulp.dest('dist/css'))
        .pipe(browserSync.reload({
            stream: true
        }));
});

gulp.task('css', function() {
    gulp.src("./public/stylesheets/main.css")
        .pipe(concat('main.css'))
        .pipe(gulp.dest('dist/css'))
        .pipe(browserSync.reload({
            stream: true
        }));
});


gulp.task('angular', function() {
    gulp.src(["./public/javascripts/vendors/angular.js","./public/javascripts/vendors/angular-ui-router.min.js"])
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

//
gulp.task('html', function() {
    return gulp.src('./public/templates/**/*.html')
        .pipe(gulp.dest('./dist/'))
        .pipe(browserSync.reload({
            stream: true
        }));
});
//
gulp.task('build', function() {
    gulp.start(['angular','controllers','app','css','html'])
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
    // gulp.watch(['./public/templates/views/*.html'], ['html']);
    // gulp.watch(['./public/templates/*.html'], ['html']);
});
