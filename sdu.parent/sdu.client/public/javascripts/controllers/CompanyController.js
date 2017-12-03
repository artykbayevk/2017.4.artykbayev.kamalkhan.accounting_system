angular.module('MyApp')
    .controller('RegCompanyCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("Registration Company Controller");
        $scope.reg_company = function(){
            var data = {
                companyid:"",
                name:$scope.name,
                telephone:$scope.telephone,
                email:$scope.email
            }

            $http.post("http://localhost:8080/sdu/api/company/save",data, {
                headers: {
                    'Content-Type': "x-www-form-urlencoded"
                }
            }).then(function(response){
                console.log(response.data);
                res = response.data.split("\"")[1];
                alert("Your company id : " + res+". Please dont forget this id. For safety - we send to your email");
                state.go("any");
            });
        }
    }]);
