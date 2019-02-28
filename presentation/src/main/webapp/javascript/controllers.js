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