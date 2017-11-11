angular.module('MyApp')
    .controller('InitialController', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("InitialControler");
    }])
