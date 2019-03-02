'use strict';
var app = angular.module("app", ['ngResource', 'pascalprecht.translate']);

app.factory('cityService', ['$resource', function ($resource) {
        return $resource('/rest/cities')
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
app.controller('CityCtrl', ['$scope', 'cityService', function ($scope, cityService) {

    $scope.rowsPerPage = 10;
    $scope.cities = cityService.query();
    /*check if city is region center*/
    $scope.isRegionCenter = function (city) {
        return !city.region;

    };
}]);

app.controller('TranslateCtrl', ['$translate', '$scope', function ($translate, $scope) {
    $scope.changeLanguage = function (lang) {
        $translate.use(lang);
    }
}]);