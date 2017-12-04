angular.module('MyApp')
    .controller('ClientAllLeadsCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("ClientAllLeadsCtrl");
        $scope.clientid = '891652226169000';
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);


        var request = {
            method: "GET",
            url:'http://localhost:8080/sdu/api/lead/getAllNotMyAcceptedLeads?clientid='+$scope.clientid
        }
        $http(request).then(function successCallback(response) {
            $scope.not_my_accepted_leads = response.data;
            console.log("======DATA FROM RESPONSE======")
            console.log($scope.not_my_accepted_leads)
        }, function errorCallback(response) {
            console.log("Error call back");
            console.log(response);
        });

    }])
    .controller('ClientActiveLeadsCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("ClientActiveLeadsCtrl");
        $scope.clientid = '891652226169000';
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);


        var request = {
            method: "GET",
            url:'http://localhost:8080/sdu/api/lead/getAllMyActiveLeads?clientid='+$scope.clientid
        }
        $http(request).then(function successCallback(response) {
            $scope.my_active_leads = response.data;
            console.log("======DATA FROM RESPONSE======")
            console.log($scope.my_active_leads)
        }, function errorCallback(response) {
            console.log("Error call back");
            console.log(response);
        });
    }])
    .controller('ClientFinishedLeadsCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("ClientFinishedLeadsCtrl");
        $scope.clientid = '891652226169000';
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);


        var request = {
            method: "GET",
            url:'http://localhost:8080/sdu/api/lead/getAllMyFinishedLeads?clientid='+$scope.clientid
        }
        $http(request).then(function successCallback(response) {
            $scope.my_finished_leads = response.data;
            console.log("======DATA FROM RESPONSE======")
            console.log($scope.my_finished_leads)
        }, function errorCallback(response) {
            console.log("Error call back");
            console.log(response);
        });
    }]);
