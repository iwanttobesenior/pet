/**
 * @author Kul'baka Alex
 */
describe('Testing City Controller', function () {

    beforeEach(module("app"));

    var scope = {}, httpBackend;
    beforeEach(inject(function ($controller, $httpBackend) {
        $controller('CityCtrl', {$scope: scope});
        httpBackend = $httpBackend;
    }));

    afterEach(function () {

    });

    /**
     * Test controller
     */
    it('Rows per page should have initial value', function () {
        expect(scope.rowsPerPage).toBeDefined();
        expect(scope.rowsPerPage).toBe(10);
    });

    /**
     * Test controller method isRegionCenter() return false if city is't region center
     */
    it('should return false for non-region center', function () {
        var city = {
            'name': 'Borisov',
            'region': 'Minsk',
            'district': 'Minsk'
        };
        var center = scope.isRegionCenter(city);
        expect(center).toBeFalsy();
    });

    /**
     * Test controller method isRegionCenter() return true if city is region center
     */
    it('should return true for region center', function () {
        var city = {
            'name': 'Minsk',
            'region': '',
            'district': 'Minsk'
        };
        var center = scope.isRegionCenter(city);
        expect(center).toBeTruthy();
    });

    /**
     * Intercept http GET method,return test data
     */
    it('Should query cities', function () {
        httpBackend.expectGET("l10n/locale-en.json").respond(
            [
                {}
            ]);
        httpBackend.expectGET("/rest/cities").respond(
            [
                {
                    'name': 'Odessa',
                    'district': '',
                    'region': 'Odessa'
                }
            ]);
        httpBackend.flush();
        expect(scope.cities[0].name).toBe('Odessa');
        expect(scope.cities[0].district).toBe('');
        expect(scope.cities[0].region).toBe('Odessa');

    });
});