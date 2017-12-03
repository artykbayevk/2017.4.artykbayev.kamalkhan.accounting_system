angular.module('MyApp')
    .controller('InitCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("InitialControler");
    }])
    .controller('RegViewCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("RegViewController");


    }]);
