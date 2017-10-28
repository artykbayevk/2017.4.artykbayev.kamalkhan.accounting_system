// angular.module('MyApp', ['ui.router','ngCookies','btford.socket-io', 'ngMessages','mgcrea.ngStrap'])
angular.module('MyApp', ['ui.router'])
  .config(['$locationProvider','$urlRouterProvider', '$stateProvider' ,function($locationProvider,$urlRouterProvider,$stateProvider) {
      $locationProvider.html5Mode(true);
      $urlRouterProvider.otherwise('/');
      $stateProvider
          .state('any', {
              url: '/',
              templateUrl: '../views/clientList.html',
              controller: 'ClientListCtrl'
          })
          .state('log',{
              url:'/log',
              templateUrl:'../views/loginPage.html',
              controller:'LoginPageCtrl'
          })
          .state('reg',{
              url:'/reg',
              templateUrl:'../views/regPage.html',
              controller:'RegPageCtrl'
          })
          .state('userPage',{
              url:'/userPage',
              templateUrl:'../views/userPage.html',
              controller:'UserPageCtrl'
      });
  }]);



// .state('log', {
//   url: '/log',
//   templateUrl: '../templates/views/log.html',
//   controller: 'LoginCtrl'
// })
//
// .state('reg',{
//   url:'/reg',
//   templateUrl:'../templates/views/reg.html',
//   controller:'RegisCtrl'
// })
// .state('manager-add',{
//   url:'/manager-add',
//   templateUrl:'../templates/views/manager-add.html',
//   controller:'ManagerAddCtrl'
// })
// .state('users-leads',{
//   url:'/users-leads',
//   templateUrl:'../templates/views/users-leads.html',
//   controller:'UsersLeadsCtrl'
// })
// .state('leads-history',{
//   url:'/leads-history',
//   templateUrl:'../templates/views/leads-history.html',
//   controller:'AdminAllLeadsCtrl'
// })
// .state('admin-leads',{
//   url:'/admin-leads',
//   templateUrl:'../templates/views/admin-leads.html',
//   controller:'AdminLeadsCtrl'
// })
//
// .state('users-list',{
//   url:'/users-list',
//   templateUrl:'../templates/views/users-list.html',
//   controller:'UsersListCtrl'
// });