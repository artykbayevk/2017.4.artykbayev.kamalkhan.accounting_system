angular.module('MyApp')
    .controller('AdminUserListCtrl', ['$window','$sessionStorage','$http','$scope','$state','$rootScope',function($window,$sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("Admin Users List Controller");
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);

        $sessionStorage.showLogOut = true;
        $scope.showLogOut = $sessionStorage.showLogOut;

        if($sessionStorage.userToken === undefined){
            $state.go("any");
        }else{
            $rootScope.changeShowLogOut();
            var req = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/user/getInfo?id='+$sessionStorage.personId
            }

            $http(req).then(function success(res){
                var obj = res.data;
                if(obj.isAdmin != true){
                    $state.go("any");
                }
            }, function error(err){
                console.log("Error call back");
                console.log(err);
            });
        }


        function updateData() {
            var request = {
                method: "GET",
                url: 'http://localhost:8080/sdu/api/user/getNotAccepted'
            }

            $http(request).then(function successCallback(response) {
                $scope.users_list = response.data;
                console.log("======DATA FROM RESPONSE======");
                console.log($scope.users_list);
            }, function errorCallback(response) {
                console.log("Error call back");
                console.log(response);
            });
        }

        updateData();
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
                updateData();
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
                console.log(res);
                updateData();
            })
        }
    }])
    .controller('AdminLeadListCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("Admin Leads List Controller");
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);

        $sessionStorage.showLogOut = true;
        $scope.showLogOut = $sessionStorage.showLogOut;


        if($sessionStorage.userToken === undefined){
            $state.go("any");
        }else{
            var req = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/user/getInfo?id='+$sessionStorage.personId
            }

            $http(req).then(function success(res){
                var obj = res.data;
                if(obj.isAdmin != true){
                    $state.go("any");
                }
            }, function error(err){
                console.log("Error call back");
                console.log(err);
            });
        }

        function load_data(){
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
        }

        load_data();


        $scope.accept_lead = function(leadid){
            console.log("Accept lead "+ leadid);
            var request = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/lead/acceptLead?leadid='+leadid
            }
            $http(request).then(function successCallback(response) {
                console.log("======DATA FROM RESPONSE======");
                console.log(response.data);
                load_data()
            }, function errorCallback(response) {
                console.log("Error call back");
                console.log(response);
            });
        }

        $scope.decline_lead = function(leadid){
            console.log("Decline lead "+ leadid);
            var request = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/lead/declineLead?leadid='+leadid
            }
            $http(request).then(function successCallback(response) {
                console.log("======DATA FROM RESPONSE======");
                console.log(response.data);
                load_data()
            }, function errorCallback(response) {
                console.log("Error call back");
                console.log(response);
            });
        }
    }])
    .controller('AdminCompanyListCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("Admin Company List Controller");
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);

        $sessionStorage.showLogOut = true;
        $scope.showLogOut = $sessionStorage.showLogOut;


        $sessionStorage.showLogOut = true;
        $scope.showLogOut = $sessionStorage.showLogOut;


        if($sessionStorage.userToken === undefined){
            $state.go("any");
        }else{
            var req = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/user/getInfo?id='+$sessionStorage.personId
            }

            $http(req).then(function success(res){
                var obj = res.data;
                if(obj.isAdmin != true){
                    $state.go("any");
                }
            }, function error(err){
                console.log("Error call back");
                console.log(err);
            });
        }


        function load_company(){
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
        }

        load_company();

        $scope.accept_company = function(companyid){
            console.log("Company ID: "+companyid);

            var request = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/company/acceptCompany?companyid='+companyid
            }
            $http(request).then(function successCallback(response) {
                console.log("======DATA FROM RESPONSE======");
                console.log(response.data);
                load_company();
            }, function errorCallback(response) {
                console.log("Error call back");
                console.log(response);
            });
        }

        $scope.decline_company = function(companyid){
            console.log("Company ID: "+companyid);

            var request = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/company/declineCompany?companyid='+companyid
            }
            $http(request).then(function successCallback(response) {
                console.log("======DATA FROM RESPONSE======");
                console.log(response.data);
                load_company();
            }, function errorCallback(response) {
                console.log("Error call back");
                console.log(response);
            });
        }
    }])
    .controller('AdminLeadHistoryCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("Admin Leads History Controller");
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);


        $sessionStorage.showLogOut = true;
        $scope.showLogOut = $sessionStorage.showLogOut;


        if($sessionStorage.userToken === undefined){
            $state.go("any");
        }else{
            var req = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/user/getInfo?id='+$sessionStorage.personId
            }

            $http(req).then(function success(res){
                var obj = res.data;
                if(obj.isAdmin != true){
                    $state.go("any");
                }
            }, function error(err){
                console.log("Error call back");
                console.log(err);
            });
        }

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