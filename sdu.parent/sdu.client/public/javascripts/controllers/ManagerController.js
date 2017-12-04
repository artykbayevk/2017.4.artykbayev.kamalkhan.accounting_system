angular.module('MyApp')
    .controller('ManagerNotActiveLeadCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("ManagerNotActiveLeadCtrl");

        $scope.id = "891652226169095";

        var request = {
            method: "GET",
            url:'http://localhost:8080/sdu/api/lead/getAllMyNotAcceptedLeads?managerid='+$scope.id
        }
        $http(request).then(function successCallback(response) {
            console.log("Http request run");
            console.log(response.data);
            $scope.my_not_accepted_leads_list = response.data;
            console.log($scope.my_not_accepted_leads_list)
        }, function errorCallback(response) {
            console.log("Error call back");
            console.log(response);
        });
        // my_not_accepted_leads_list

    }])
    .controller('ManagerActiveLeadCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("ManagerActiveLeadCtrl");

        $scope.id = "891652226169095";

        var request = {
            method: "GET",
            url:'http://localhost:8080/sdu/api/lead/getAllMyAcceptedLeads?managerid='+$scope.id
        }
        $http(request).then(function successCallback(response) {
            console.log("Http request run");
            console.log(response.data);
            $scope.my_accepted_leads_list = response.data;
            console.log($scope.my_accepted_leads_list)
        }, function errorCallback(response) {
            console.log("Error call back");
            console.log(response);
        });
        // my_accepted_leads_list
    }]);
