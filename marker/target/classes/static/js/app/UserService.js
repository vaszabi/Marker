'use strict';

angular.module('markerApp').factory('MarkerService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllmarker: loadAllmarker,
                getAllMarkers: getAllMarkers,
                loadmarkerByid: loadmarkerByid,
                register: register,
                updatemarker: updatemarker,
                deletemarkerByid: deletemarkerByid
            };

            return factory;

            function loadAllmarker() {
                console.log('Fetching all markers');
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all markers');
                            $localStorage.markers = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading markers');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllMarkers(){
                return $localStorage.markers;
            }

            function loadmarkerByid(id) {
                console.log('Fetching marker with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully marker with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading marker with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function register(marker) {
                console.log('Creating marker');
                var deferred = $q.defer();
                $http.post(urls.USER_SERVICE_API, marker)
                    .then(
                        function (response) {
                            loadAllmarker();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating marker : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updatemarker(marker, id) {
                console.log('Updating marker with id '+id);
                var deferred = $q.defer();
                $http.put(urls.USER_SERVICE_API + id, marker)
                    .then(
                        function (response) {
                            loadAllmarker();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating marker with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function deletemarkerByid(id) {
                console.log('Removing marker with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllmarker();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing marker with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);