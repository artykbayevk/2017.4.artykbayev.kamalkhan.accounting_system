angular.module('MyApp')
    .controller('AdminUserListCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("Admin Users List Controller");
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);


        var request = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/user/getNotAccepted'
            }

            $http(request).then(function successCallback(response) {
                $scope.users_list = response.data;
                console.log("======DATA FROM RESPONSE======");
                console.log($scope.users_list);
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
                console.log("======DATA FROM RESPONSE======");
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
                console.log("======DATA FROM RESPONSE======");
                console.log(res)
            })
        }
    }])
    .controller('AdminLeadListCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("Admin Leads List Controller");
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);

        var request = {
            method: "GET",
            url:'http://localhost:8080/sdu/api/lead/getNotAcceptedLeads'
        }
        $http(request).then(function successCallback(response) {
            $scope.not_accepted_leads_list = response.data;
            console.log("======DATA FROM RESPONSE======");
            console.log($scope.not_accepted_leads_list)
        }, function errorCallback(response) {
            console.log("Error call back");
            console.log(response);
        });
    }])
    .controller('AdminCompanyListCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("Admin Company List Controller");
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);


        var request = {
            method: "GET",
            url:'http://localhost:8080/sdu/api/company/notAcceptedCompanies'
        }
        $http(request).then(function successCallback(response) {
            $scope.not_accepted_companies = response.data;
            console.log("======DATA FROM RESPONSE======");
            console.log($scope.not_accepted_companies)
        }, function errorCallback(response) {
            console.log("Error call back");
            console.log(response);
        });
    }])
    .controller('AdminLeadHistoryCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("Admin Leads History Controller");
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);

        var request = {
            method: "GET",
            url:'http://localhost:8080/sdu/api/lead/getAllLeads'
        }
        $http(request).then(function successCallback(response) {
            $scope.leads_list = response.data;
            console.log("======DATA FROM RESPONSE======");
            console.log($scope.leads_list)
        }, function errorCallback(response) {
            console.log("Error call back");
            console.log(response);
        });
    }]);