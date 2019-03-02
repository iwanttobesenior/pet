/*Karma configuration*/
module.exports = function (config) {
    config.set({
        basePath: '',
        /*Test framework*/
        frameworks: ['jasmine'],

        files: ["../bower_components/angular/angular.js",
            "../bower_components/angular-mocks/angular-mocks.js",
            "../bower_components/angular-resource/angular-resource.js",
            "../bower_components/angular-translate/angular-translate.js",
            "../bower_components/angular-translate-loader-static-files/angular-translate-loader-static-files.js",
            "../javascript/*.js",
            "unit/*.js"
        ],
        exclude: [],
        preprocessors: {
            '../javascript/*.js': 'coverage'
        },
        reporters: ['progress', 'coverage'],
        coverageReporter: {
            type: 'html',
            dir: 'coverage/'
        },
        port: 9876,
        colors: true,
        logLevel: config.LOG_INFO,
        autoWatch: true,
        browsers: ['Chrome'],
        singleRun: false,

        concurrency: Infinity
    })
};
