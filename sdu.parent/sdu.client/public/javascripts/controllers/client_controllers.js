angular.module('MyApp')
    .controller('ClientListCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        $scope.def = function(){

            $scope.id = "";
            $scope.name = "";
            $scope.surname = "";
            $scope.age = "";
            $scope.compID = "";
            $scope.number = "";
            $scope.email = "";

            $scope.showSelected = true;

            var request = {
                method: "GET",
                url:'http://localhost:1313/sdu/api/client/getClients'
            }

            $http(request).then(function successCallback(response) {
                console.log("Http request run");
                $scope.data = response.data;
            }, function errorCallback(response) {
                console.log("Error call back");
                console.log(response);
            });
        }


        $scope.selectFunc = function(id){
            $scope.def();
            $scope.showSelected = false;
            for (var prop in $scope.data) {
                if($scope.data[prop].id == id){
                    $scope.id = $scope.data[prop].id;
                    $scope.name = $scope.data[prop].name;
                    $scope.surname = $scope.data[prop].surname;
                    $scope.age= $scope.data[prop].age;
                    $scope.compID= $scope.data[prop].companyId;
                    $scope.number= $scope.data[prop].tel_number;
                    $scope.email = $scope.data[prop].email;
                }
            }

        }


        $scope.addNewFunc = function(){

            $scope.id = "";
            $scope.name = "";
            $scope.surname = "";
            $scope.age = "";
            $scope.compID = "";
            $scope.number = "";
            $scope.email = "";

            $scope.showSelected = false;
            console.log($scope.id);

        }


        $scope.save = function(){

            var data = {
                id : $scope.id,
                name : $scope.name,
                surname: $scope.surname,
                age: $scope.age,
                companyId: $scope.compID,
                tel_number: $scope.number,
                email:$scope.email,
                isManager:"1"
            }


            console.log("Data: ");
            console.log(data);

            $http.post("http://localhost:1313/sdu/api/client/saveClient",data, {
                    headers: {
                            'Content-Type': "x-www-form-urlencoded"
                    }
                }).then(function(response){
                    console.log(response.data);
                    $scope.def();
            });
        }


        $scope.delete = function () {
            if($scope.id.length == 0){
                console.log("select item");
            }else{
                var data = {
                    id : $scope.id
                }
                $http.post("http://localhost:1313/sdu/api/client/deleteClient",data,{
                    headers: {
                        'Content-Type': "x-www-form-urlencoded"
                    }
                }).then(function(response){
                    console.log(response.data);
                    $scope.def();
                });
            }
        }


        $scope.def();

        $scope.goToLog = function(){
            $state.go("log");
        }

        $scope.goToReg = function(){
            $state.go("reg");
        }
    }])
    .controller('LoginPageCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("You are in login page");
        $scope.check = function(){
            var data = {
                email : $scope.email,
                password : $scope.password
            }

            console.log(data);

            $http.post("http://localhost:1313/sdu/api/user/check",data, {
                headers: {
                    'Content-Type': "x-www-form-urlencoded"
                }
            }).then(function(response){
                console.log(response.data);
                var res = response.data.split("\"");
                var tmp = res[1];
                var out = tmp.split(",");
                console.log(out);

                if(out[0] == 'found'){
                    $rootScope.type_id= out[1];
                    $state.go("userPage");
                }else if(out[0] == 'not activated'){

                    alert('Your account not activated');
                }else{
                    alert('Not found');
                }
            });

        }
    }])
    .controller('RegPageCtrl', ['$http','$scope','$state',function($http,$scope,$state) {
        console.log("You are in reg page");
        $scope.clientType = "";
        $scope.clientTypeList = ('Manager Customer').split(' ').map(function (state) { return { abbrev: state }; });

        $scope.backToMain = function(){
            $state.go('any');
        }

        $scope.save = function(){

            var isManager = ($scope.clientType =='Manager' ? "1" : "2");
            var data = {
                id : "",
                name : $scope.name,
                surname: $scope.surname,
                age: $scope.age,
                password:$scope.password,
                companyId: $scope.compID,
                tel_number: $scope.number,
                email:$scope.email,
                isManager:isManager
            }

            console.log("Data: ");
            console.log(data);

            $http.post("http://localhost:1313/sdu/api/user/register",data, {
                headers: {
                    'Content-Type': "x-www-form-urlencoded"
                }
            }).then(function(response){
                console.log(response.data);
            });
        }


    }])
    .controller('UserPageCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("We are in user page");
        console.log($rootScope.type_id);
        $scope.role = $rootScope.type_id == '1'?'Manager':'Client';
    }]);
