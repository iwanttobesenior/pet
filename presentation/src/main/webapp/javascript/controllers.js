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

app.controller('SseCtrl', ['$scope', function ($scope) {
    $scope.currentTime = '';

    if (typeof (EventSource) !== 'undefined') {
        var source = new EventSource("/rest/time");

        source.onmessage = function (evt) {
            $scope.currentTime = evt.data;
            $scope.$apply();
        }
    } else {
        console.log('sse not supported');
    }

}]);