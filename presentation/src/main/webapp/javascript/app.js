'use strict';
var app = angular.module("app", ['ngResource', 'pascalprecht.translate']);

var docker = 'http://192.168.99.100:8050/client/rest/cities';

app.factory('cityService', ['$resource', function ($resource) {
        return $resource(docker)
    }]
);

app.config(function ($translateProvider) {
    $translateProvider.useStaticFilesLoader({
        prefix: 'l10n/locale-',
        suffix: '.json'
    });
    $translateProvider.preferredLanguage('en');
    $translateProvider.useSanitizeValueStrategy('escape');
});