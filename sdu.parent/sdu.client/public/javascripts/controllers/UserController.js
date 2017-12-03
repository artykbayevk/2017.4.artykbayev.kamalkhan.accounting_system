angular.module('MyApp')
    .controller('InitCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("InitialControler");
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
                if(response.data.token =="not accepted"){
                    alert("Your user are not accepted from admin");
                    console.log(response.data.token);
                    console.log(response.data.personId);
                }else if(response.data.token == "not found"){
                    alert("Your user are not registered");
                    console.log(response.data.token);
                    console.log(response.data.personId);
                }else{
                    $rootScope.token = response.data.token;
                    $rootScope.personId = response.data.personId;
                    console.log($rootScope.personId);
                    console.log($rootScope.token);
                }

                $scope.email = "";
                $scope.password = "";
            });
        }
    }])
    .controller('RegViewCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("RegViewController");
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
    .controller('OwnPageCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
    console.log("RegViewController");
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
}]);
