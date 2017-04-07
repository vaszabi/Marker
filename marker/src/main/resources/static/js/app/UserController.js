'use strict';

angular.module('markerApp').controller('MarkerApi',
    ['MarkerService', '$scope',  function( MarkerService, $scope) {

        var self = this;
        self.marker = {};
        self.markers=[];

        self.submit = submit;
        self.loadAllmarker = loadAllmarker;
        self.register = register;
        self.updatemarker = updatemarker;
        self.deletemarkerById = deletemarkerById;
        self.editUser = editUser;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            if (self.marker.id === undefined || self.marker.id === null) {
                console.log('Saving New User', self.marker);
                register(self.marker);
            } else {
                updatemarker(self.marker, self.marker.id);
                console.log('User updated with id ', self.marker.id);
            }
        }

        function register(user) {
            console.log('About to create user');
            MarkerService.register(user)
                .then(
                    function (response) {
                        console.log('User created successfully');
                        self.successMessage = 'User created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.marker={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating User');
                        self.errorMessage = 'Error while creating User: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updatemarker(user, id){
            console.log('About to update user');
            MarkerService.updatemarker(user, id)
                .then(
                    function (response){
                        console.log('User updated successfully');
                        self.successMessage='User updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating User');
                        self.errorMessage='Error while updating User '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function deletemarkerById(id){
            console.log('About to remove User with id '+id);
            MarkerService.deletemarkerById(id)
                .then(
                    function(){
                        console.log('User '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing user '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function loadAllmarker(){
            return MarkerService.loadAllmarker();
        }

        function editUser(id) {
            self.successMessage='';
            self.errorMessage='';
            MarkerService.getUser(id).then(
                function (user) {
                    self.marker = user;
                },
                function (errResponse) {
                    console.error('Error while removing user ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.marker={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);