angular.module('MyApp', ['ui.router','ngMaterial','ngMessages',"ngSanitize", 'ui.mask'])
  .config(['$urlRouterProvider', '$stateProvider' ,function($urlRouterProvider,$stateProvider) {
      // $locationProvider.html5Mode(true);
      $urlRouterProvider.otherwise('/');

      $stateProvider
          .state('regView',{
              url:'/reg',
              templateUrl:'views/registrationView.html',
              controller:'RegViewCtrl'
          })
          .state('any', {
              url: '/',
              templateUrl: 'views/initView.html',
              controller: 'InitCtrl'
          })
          .state('regCompany',{
              url:'/regComp',
              templateUrl:'views/regCompanyView.html',
              controller:'RegCompanyCtrl'
          }).state('adminUsersList',{
              url:'/adminUsersList',
              templateUrl:'views/adminUsersListView.html',
              controller:'AdminUserListCtrl'
      })
  }]);