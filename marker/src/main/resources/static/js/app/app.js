var app = angular.module('markerApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/Application',
    USER_SERVICE_API : 'http://localhost:8080/Application/api/marker/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'MarkerApi',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, MarkerService) {
                        console.log('Load all markers');
                        var deferred = $q.defer();
                        MarkerService.loadAllmarker().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

