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