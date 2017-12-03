angular.module('MyApp')
    .controller('AdminUserListCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("Admin Users List Controller");
        var request = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/user/getNotAccepted'
            }

            $http(request).then(function successCallback(response) {
                console.log("Http request run");
                console.log(response.data);
                $scope.users_list = response.data;
            }, function errorCallback(response) {
                console.log("Error call back");
                console.log(response);
            });

        // acceptUserFromAdmin url for sending accept

        $scope.accept_user_func = function (id) {
            var req = {
                method:"GET",
                url:"http://localhost:8080/sdu/api/user/acceptUserFromAdmin?userid="+id
            }
            console.log(id);
            $http(req).then(function success(res) {
                console.log(res)
            })
        }

        $scope.decline_user_func = function (id) {
            var req = {
                method:"GET",
                url:"http://localhost:8080/sdu/api/user/declineUserFromAdmin?userid="+id
            }
            console.log(id);
            $http(req).then(function success(res) {
                console.log(res)
            })
        }
    }])
    .controller('AdminLeadListCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("Admin Leads List Controller");
        var request = {
            method: "GET",
            url:'http://localhost:8080/sdu/api/lead/getNotAcceptedLeads'
        }
        $http(request).then(function successCallback(response) {
            console.log("Http request run");
            console.log(response.data);
            $scope.not_accepted_leads_list = response.data;
            console.log($scope.not_accepted_leads_list)
        }, function errorCallback(response) {
            console.log("Error call back");
            console.log(response);
        });
    }])
    .controller('AdminCompanyListCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("Admin Company List Controller");
        var request = {
            method: "GET",
            url:'http://localhost:8080/sdu/api/company/notAcceptedCompanies'
        }
        $http(request).then(function successCallback(response) {
            console.log("Http request run");
            console.log(response.data);
            $scope.not_accepted_companies = response.data;
            console.log($scope.not_accepted_companies)
        }, function errorCallback(response) {
            console.log("Error call back");
            console.log(response);
        });
    }])
    .controller('AdminLeadHistoryCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("Admin Leads History Controller");
        var request = {
            method: "GET",
            url:'http://localhost:8080/sdu/api/lead/getAllLeads'
        }
        $http(request).then(function successCallback(response) {
            console.log("Http request run");
            console.log(response.data);
            $scope.leads_list = response.data;
            console.log($scope.leads_list)
        }, function errorCallback(response) {
            console.log("Error call back");
            console.log(response);
        });
    }]);