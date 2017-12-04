angular.module('MyApp')
    .controller('ManagerNotActiveLeadCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("ManagerNotActiveLeadCtrl");
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);


        $scope.id = "891652226169095";

        var request = {
            method: "GET",
            url:'http://localhost:8080/sdu/api/lead/getAllMyNotAcceptedLeads?managerid='+$scope.id
        }
        $http(request).then(function successCallback(response) {
            $scope.my_not_accepted_leads_list = response.data;
            console.log("======DATA FROM RESPONSE======");
            console.log($scope.my_not_accepted_leads_list)
        }, function errorCallback(response) {
            console.log("Error call back");
            console.log(response);
        });
        // my_not_accepted_leads_list

    }])
    .controller('ManagerActiveLeadCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("ManagerActiveLeadCtrl");
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);


        $scope.id = "891652226169095";

        var request = {
            method: "GET",
            url:'http://localhost:8080/sdu/api/lead/getAllMyAcceptedLeads?managerid='+$scope.id
        }
        $http(request).then(function successCallback(response) {
            $scope.my_accepted_leads_list = response.data;
            console.log("======DATA FROM RESPONSE======");
            console.log($scope.my_accepted_leads_list)
        }, function errorCallback(response) {
            console.log("Error call back");
            console.log(response);
        });
        // my_accepted_leads_list
    }]);
