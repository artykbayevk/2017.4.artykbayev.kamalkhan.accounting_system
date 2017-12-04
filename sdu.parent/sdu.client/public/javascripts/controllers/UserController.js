angular.module('MyApp')
    .controller('InitCtrl', ['$sessionStorage','$window','$http','$scope','$state','$rootScope',function($sessionStorage,$window,$http,$scope,$state,$rootScope) {
        console.log("InitialControler");
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);

        $scope.login = function(){
            var data = {
                "email":$scope.email,
                "password":$scope.password
            };
            console.log(data);

            $http.post("http://localhost:8080/sdu/api/user/check",data, {
                headers: {
                    'Content-Type': "x-www-form-urlencoded"
                }
            }).then(function(response){
                console.log("======DATA FROM RESPONSE======");
                if(response.data.token =="not accepted"){
                    alert("Your user are not accepted from admin");
                    console.log(response.data.token);
                    console.log(response.data.personId);
                }else if(response.data.token == "not found"){
                    alert("Your user are not registered or your data incorrect");
                    console.log(response.data.token);
                    console.log(response.data.personId);
                }else{
                    $sessionStorage.userToken = response.data.token;
                    $sessionStorage.personId = response.data.personId;
                    console.log($sessionStorage.userToken);
                    console.log($sessionStorage.personId);

                    var req = {
                        method: "GET",
                        url:'http://localhost:8080/sdu/api/user/getInfo?id='+$sessionStorage.personId
                    }

                    $http(req).then(function success(res){
                        var obj = res.data;
                        if(obj.isAdmin == true){
                            $state.go("adminUsersList");
                        }else if(obj.isManager == true){
                            $state.go("managerNotActiveLeads");
                        }else{
                            $state.go("clientAllLeads");
                        }
                    }, function error(err){
                        console.log("Error call back");
                        console.log(err);
                        });
                    }
                $scope.email = "";
                $scope.password = "";
            });
        }
    }])
    .controller('RegViewCtrl', ['$sessionStorage','$window','$http','$scope','$state','$rootScope',function($sessionStorage,$window,$http,$scope,$state,$rootScope) {
        console.log("RegViewController");
        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);

        $scope.clientTypeList = ('Manager Client').split(' ').map(function (state) { return { abbrev: state }; });
        $scope.save_user = function(){
            var isManager = ($scope.clientType =='Manager' ? "1" : "0");

            var isAccepted = "0";
            var data = {
                id : "",
                name : $scope.name,
                surname: $scope.surname,
                age: $scope.age,
                email:$scope.email,
                telephone: $scope.telephone,
                companyId: $scope.compID,
                isManager:isManager,
                password:$scope.password,
                isAccepted:isAccepted
            };
            console.log("This is data:");
            console.log(data);


            $http.post("http://localhost:8080/sdu/api/user/save",data, {
                headers: {
                    'Content-Type': "x-www-form-urlencoded"
                }
            }).then(function(response){
                console.log("======DATA FROM RESPONSE======");
                console.log((response.data))
                res = response.data.split('\"')[1];
                if(res === "email"){
                    alert("This email registered");
                }else if(res === "company"){
                    alert("Your company not accepted or not registered");
                }else if(res === "added"){
                    alert("You are registered successfully.");
                    $state.go("any")
                }else{
                    console.log("nothing");
                }
            });
        }
    }])
    .controller('OwnPageCtrl', ['$sessionStorage','$http','$scope','$state','$rootScope',function($sessionStorage,$http,$scope,$state,$rootScope) {
        console.log("OwnPageCtrl");


        console.log("Check token");
        console.log($sessionStorage.userToken);
        console.log($sessionStorage.personId);
        $scope.id = $sessionStorage.personId;

        if($sessionStorage.userToken === undefined){
            $state.go("any")
        }else{
            var req = {
                method: "GET",
                url:'http://localhost:8080/sdu/api/user/getInfo?id='+$sessionStorage.personId
            }

            $http(req).then(function success(res){
                var obj = res.data;
                if(obj.isManager == true){
                    $scope.Manager = true;
                }else{
                    $scope.Manager = false;
                }
                console.log("Manager: "+$scope.Manager);
            }, function error(err){
                console.log("Error call back");
                console.log(err);
            });
        }



        var request = {
            method: "GET",
            url:'http://localhost:8080/sdu/api/user/getInfo?id='+$scope.id
        }
        $http(request).then(function successCallback(response) {
            console.log("Http request run");
            console.log(response.data);
            var obj = response.data;
            $scope.id = obj.id;
            $scope.name = obj.name;
            $scope.surname = obj.surname;
            $scope.age = obj.age;
            $scope.email = obj.email;
            $scope.telephone = obj.tel_number;
            $scope.companyId = obj.companyId;
            $scope.isManager = (obj.isManager==true ? "1" : "0");
            $scope.password = obj.password;
            $scope.isAdmin = "0";
        }, function errorCallback(response) {
            console.log("Error call back");
            console.log(response);
        });


        $scope.update_user = function(){
            var data = {
                id : $scope.id,
                name : $scope.name,
                surname: $scope.surname,
                age: $scope.age,
                email:$scope.email,
                telephone: $scope.telephone,
                companyId: $scope.companyId,
                isManager:$scope.isManager,
                password:$scope.password,
                isAccepted:"1"
            };

            console.log(data);

            $http.post("http://localhost:8080/sdu/api/user/save",data, {
                headers: {
                    'Content-Type': "x-www-form-urlencoded"
                }
            }).then(function(response){
                console.log((response.data))
                res = response.data.split('\"')[1];
                if(res === "email"){
                    alert("This email registered");
                }else if(res === "company"){
                    alert("Your company not accepted or not registered");
                }else if(res === "added"){
                    alert("You are registered successfully.");
                    $state.go("any")
                }else{
                    alert("Your information successfully updated");
                    if($scope.Manager == true){
                        $state.go("managerNotActiveLeads");
                    }else{
                        $state.go("clientAllLeads");
                    }
                    console.log("nothing");
                }
            });
        }
}]);
