angular.module('MyApp')
    .controller('ClientAllLeadsCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("ClientAllLeadsCtrl");
        $scope.clientid = $sessionStorage.personId;
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);

        if($sessionStorage.personId === undefined){
            $state.go("any");
        }else{
            var req = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/user/getInfo?id='+$sessionStorage.personId
            }

            $http(req).then(function success(res){
                var obj = res.data;
                if(obj.isManager == true){
                    $state.go("any");
                }
            }, function error(err){
                console.log("Error call back");
                console.log(err);
            });
        }



        function load_all_leads(){
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
        }


        load_all_leads();



        $scope.start_lead = function(leadid){
            console.log(leadid)
            var myrequest = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/lead/startLead?clid='+$scope.clientid+'&lid='+leadid
            }


            $http(myrequest).then(function successCallback(response) {
                console.log("======DATA FROM RESPONSE======");
                console.log(response.data);
                load_all_leads();

            }, function errorCallback(response) {
                console.log("Error call back");
                console.log(response);
            });
        }

    }])
    .controller('ClientActiveLeadsCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("ClientActiveLeadsCtrl");
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);

        if($sessionStorage.personId === undefined){
            $state.go("any");
        }else{
            var req = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/user/getInfo?id='+$sessionStorage.personId
            }

            $http(req).then(function success(res){
                var obj = res.data;
                if(obj.isManager == true){
                    $state.go("any");
                }
            }, function error(err){
                console.log("Error call back");
                console.log(err);
            });
        }


        function load_activated_leads(){
            var request = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/lead/getAllMyActiveLeads?clientid='+$sessionStorage.personId
            }
            $http(request).then(function successCallback(response) {
                $scope.my_active_leads = response.data;
                console.log("======DATA FROM RESPONSE======")
                console.log($scope.my_active_leads)
            }, function errorCallback(response) {
                console.log("Error call back");
                console.log(response);
            });
        }

        load_activated_leads();


        $scope.stop_lead = function(leadid){
            console.log("This is for stopping leadid:"+leadid);

            var myrequest = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/lead/stopLead?lid='+leadid
            }


            $http(myrequest).then(function successCallback(response) {
                console.log("======DATA FROM RESPONSE======");
                console.log(response.data);
                load_activated_leads();

            }, function errorCallback(response) {
                console.log("Error call back");
                console.log(response);
            });
        }


    }])
    .controller('ClientFinishedLeadsCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("ClientFinishedLeadsCtrl");
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);

        if($sessionStorage.personId === undefined){
            $state.go("any");
        }else{
            var req = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/user/getInfo?id='+$sessionStorage.personId
            }

            $http(req).then(function success(res){
                var obj = res.data;
                if(obj.isManager == true){
                    $state.go("any");
                }
            }, function error(err){
                console.log("Error call back");
                console.log(err);
            });
        }


        var request = {
            method: "GET",
            url:'http://localhost:8080/sdu/api/lead/getAllMyFinishedLeads?clientid='+$sessionStorage.personId
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
