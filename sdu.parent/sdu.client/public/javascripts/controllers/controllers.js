// angular.module('MyApp')
//   .controller('LoginCtrl', ['$http','$scope','$state','Auth',function($http,$scope,$state,Auth) {
//     $scope.login = function() {
//       Auth.login({
//         email: $scope.email,
//         password: $scope.password
//       });
//     };
//     $scope.check=false;
//     $scope.checkis = function(){
//       $http.post('api/checkis',{email:$scope.email})
//       .success(function(data){
//         $scope.check=data;
//         console.log($scope.check);
//       })
//     }
//   }])
//   .controller('RegisCtrl', ['$http','$scope','$state','Auth',function($http,$scope,$state,Auth) {
//     $scope.signup = function() {
//       Auth.signup({
//         name:$scope.name,
//         surname:$scope.surname,
//         email: $scope.email,
//         password: $scope.password
//       });
//     };
//     $scope.check=false;
//     $scope.checkunique = function(){
//       $http.post('api/checkunique',{email:$scope.email})
//       .success(function(data){
//         $scope.check=data;
//         console.log($scope.check);
//       })
//     }
//
//   }])
//
//   .controller('ManagerAddCtrl', ['$scope','$state','$cookieStore','Auth','$rootScope',function($scope,$state,$cookieStore,Auth,$rootScope) {
//     $scope.addLead = function(){
//       var fullname = $rootScope.currentUser.name + ' ' +$rootScope.currentUser.surname;
//       Auth.addLead({
//         description:$scope.description,
//         cost:$scope.cost,
//         category:$scope.category,
//         manager:fullname,
//         email:$rootScope.currentUser.email
//       });
//     }
//   }])
//   .controller('NavCtrl', ['$scope','$state','Auth','$rootScope',function($scope,$state,Auth,$rootScope) {
//     $scope.isUser=false;
//     $scope.isAdmin=false;
//     $scope.isJust=false;
//     $rootScope.$watch('currentUser',function(){
//       if($rootScope.currentUser){
//         $scope.isUser=true;
//         if($rootScope.currentUser.role){
//           $scope.isAdmin=true;
//         }else{
//           $scope.isJust=true;
//         }
//       }else{
//         $scope.isUser=false;
//       }
//       $scope.logout=function(){
//         Auth.logout();
//         $scope.isAdmin=false;
//         $scope.isJust=false;
//       }
//     })
//   }])
//   .controller('AdminAllLeadsCtrl', ['$http','$scope','$state','Auth','$rootScope',function($http,$scope,$state,Auth,$rootScope) {
//       console.log('AdminLeadsHistoryCtrl');
//       $http.post('http://localhost:3000/api/get-leads-history')
//       .success(function(leads){
//         $scope.leads = leads;
//         console.log(leads);
//       })
//       .error(function(data,status){
//         console.log(data);
//         console.log(status);
//       });
//       $scope.forDate=true;
//       $scope.forManager=true;
//       $scope.forCategory=true;
//       $scope.forCost=true;
//       $scope.varForFilter='-date';
//       $scope.checkFunctionDownDate = function(){
//         $scope.forDate=false;
//         $scope.forManager=true;
//         $scope.forCategory=true;
//         $scope.forCost=true;
//         $scope.varForFilter='date';
//       }
//       $scope.checkFunctionUpDate = function(){
//         $scope.forDate=true;
//         $scope.forManager=true;
//         $scope.forCategory=true;
//         $scope.forCost=true;
//         $scope.varForFilter = '-date';
//       }
//       $scope.checkFunctionDownManager = function(){
//         $scope.forManager=false;
//         $scope.forDate=true;
//         $scope.forCategory=true;
//         $scope.forCost=true;
//         $scope.varForFilter='manager';
//       }
//       $scope.checkFunctionUpManager = function(){
//         $scope.forManager=true;
//         $scope.forDate=true;
//         $scope.forCategory=true;
//         $scope.forCost=true;
//         $scope.varForFilter='-date';
//       }
//       $scope.checkFunctionDownCategory =function(){
//         $scope.forCategory=false;
//         $scope.forDate=true;
//         $scope.forManager=true;
//         $scope.forCost=true;
//         $scope.varForFilter='category';
//       }
//       $scope.checkFunctionUpCategory =function(){
//         $scope.forCategory=true;
//         $scope.forDate=true;
//         $scope.forManager=true;
//         $scope.forCost=true;
//         $scope.varForFilter='-date';
//       }
//       $scope.checkFunctionDownCost = function(){
//         $scope.forCost=false;
//         $scope.forCategory=true;
//         $scope.forDate=true;
//         $scope.forManager=true;
//         $scope.varForFilter='-cost';
//       }
//       $scope.checkFunctionUpCost = function(){
//         $scope.forCost=true;
//         $scope.forCategory=true;
//         $scope.forDate=true;
//         $scope.forManager=true; 
//         $scope.varForFilter='-date';
//       }
//
//   }])
//   .controller('AdminLeadsCtrl', ['$http','$scope','$state','Auth','$rootScope','MySocket',function($http,$scope,$state,Auth,$rootScope,MySocket) {
//       console.log('AdminLeadsCtrl');
//      
//
//       $http.get('http://localhost:3000/api/get-leads')
//       .success(function(leads){
//         $scope.leads = leads;
//       })
//       .error(function(data,status){
//         console.log(data);
//         console.log(status);
//       });
//    
//       MySocket.forward('adminsec',$scope);
//         $scope.$on('socket:adminsec',function(ev,data){
//         console.log(data.msg);
//         $scope.leads.splice(0,0,data.msg);
//       });
//     $scope.btnAcceptLead = function(lead){
//
//       var data = {
//         ID: lead._id,
//         Email:lead.email
//       }
//
//       $http.post('http://localhost:3000/api/accept-lead',data)
//         .success(function(response){
//             $scope.leads.splice($scope.leads.indexOf(lead),1);
//         })
//         .error(function(response,status){
//             alert("Cant Accept");
//             console.log(status);
//         });
//     };
//
//
//     $scope.btnDeclineLead = function(lead){
//       var data = {
//         ID:lead._id,
//         Email:lead.email
//       }
//
//       $http.post('http://localhost:3000/api/decline-lead',data)
//         .success(function(response){
//             $scope.leads.splice($scope.leads.indexOf(lead),1);
//         })
//         .error(function(response,status){
//             alert("Cant Decline");
//         });
//
//     };
//
//     $scope.forDate=true;
//       $scope.forManager=true;
//       $scope.forCategory=true;
//       $scope.forCost=true;
//       $scope.varForFilter='-date';
//       $scope.checkFunctionDownDate = function(){
//         $scope.forDate=false;
//         $scope.forManager=true;
//         $scope.forCategory=true;
//         $scope.forCost=true;
//         $scope.varForFilter='date';
//       }
//       $scope.checkFunctionUpDate = function(){
//         $scope.forDate=true;
//         $scope.forManager=true;
//         $scope.forCategory=true;
//         $scope.forCost=true;
//         $scope.varForFilter = '-date';
//       }
//       $scope.checkFunctionDownManager = function(){
//         $scope.forManager=false;
//         $scope.forDate=true;
//         $scope.forCategory=true;
//         $scope.forCost=true;
//         $scope.varForFilter='manager';
//       }
//       $scope.checkFunctionUpManager = function(){
//         $scope.forManager=true;
//         $scope.forDate=true;
//         $scope.forCategory=true;
//         $scope.forCost=true;
//         $scope.varForFilter='-date';
//       }
//       $scope.checkFunctionDownCategory =function(){
//         $scope.forCategory=false;
//         $scope.forDate=true;
//         $scope.forManager=true;
//         $scope.forCost=true;
//         $scope.varForFilter='category';
//       }
//       $scope.checkFunctionUpCategory =function(){
//         $scope.forCategory=true;
//         $scope.forDate=true;
//         $scope.forManager=true;
//         $scope.forCost=true;
//         $scope.varForFilter='-date';
//       }
//       $scope.checkFunctionDownCost = function(){
//         $scope.forCost=false;
//         $scope.forCategory=true;
//         $scope.forDate=true;
//         $scope.forManager=true;
//         $scope.varForFilter='-cost';
//       }
//       $scope.checkFunctionUpCost = function(){
//         $scope.forCost=true;
//         $scope.forCategory=true;
//         $scope.forDate=true;
//         $scope.forManager=true; 
//         $scope.varForFilter='-date';
//       }
//
//   }])
//   .controller('UsersLeadsCtrl', ['$http','$scope','$state','Auth','$rootScope','MySocket',function($http,$scope,$state,Auth,$rootScope,MySocket) {
//       console.log('UsersLeadsCtrl');
//       var data = {
//         Email:$rootScope.currentUser.email
//       }
//       MySocket.forward('acceptlead',$scope);
//         $scope.$on('socket:acceptlead',function(ev,data){
//         console.log(data.msg);
//         $scope.leads.splice(0,0,data.msg);
//       });
//       $http.post('http://localhost:3000/api/get-users-leads',data)
//       .success(function(leads){
//         $scope.leads = leads;
//         console.log(leads);
//       })
//       .error(function(data,status){
//         console.log(data);
//         console.log(status);
//       });
//
//       $scope.forDate=true;
//       $scope.forCost=true;
//       $scope.varForFilter='-date';
//       $scope.checkFunctionDownDate = function(){
//         $scope.forDate=false;
//         $scope.forCost=true;
//         $scope.varForFilter='date';
//       }
//       $scope.checkFunctionUpDate = function(){
//         $scope.forDate=true;
//         $scope.forCost=true;
//         $scope.varForFilter = '-date';
//       }
//       $scope.checkFunctionDownCost = function(){
//         $scope.forCost=false;
//         $scope.forDate=true;
//         $scope.varForFilter='-cost';
//       }
//       $scope.checkFunctionUpCost = function(){
//         $scope.forCost=true;
//         $scope.forDate=true;
//         $scope.varForFilter='-date';
//       }
//
//
//   }])
//   .controller('UsersListCtrl', ['$http','$scope','$state','Auth','$rootScope','MySocket',function($http,$scope,$state,Auth,$rootScope,MySocket) {
//     $http.get('http://localhost:3000/api/get-users')
//       .success(function(users){
//         $scope.users = users;
//       })
//       .error(function(data,status){
//         console.log(data);
//         console.log(status);
//       });
//         MySocket.forward('admin',$scope);
//         $scope.$on('socket:admin',function(ev,data){
//         console.log(data.msg);
//         $scope.users.splice(0,0,data.msg);
//       });
//
//     $scope.btnAcceptUser = function(user){
//      
//       var data = {
//         ID: user._id,
//         Email:user.email
//       }
//
//       $http.post('http://localhost:3000/api/accept-user',data)
//         .success(function(response){
//             $scope.users.splice($scope.users.indexOf(user),1);
//         })
//         .error(function(response,status){
//             alert("Cant Accept");
//         });
//     };
//
//
//     $scope.btnDeclineUser = function(user){
//       var data = {
//         ID:user._id,
//         Email:user.email
//       }
//
//       $http.post('http://localhost:3000/api/decline-user',data)
//         .success(function(response){
//             $scope.users.splice($scope.users.indexOf(user),1);
//         })
//         .error(function(response,status){
//             alert("Cant Decline");
//         });
//
//     }
//   }]);
//
//
//  