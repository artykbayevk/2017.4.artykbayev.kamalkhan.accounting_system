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
          })
          .state('leadAdd', {
              url:"/leadAddUrl",
              templateUrl:"views/leadAddView.html",
              controller:"LeadAddCtrl"
          })


          .state('adminUsersList',{
              url:'/adminUsersList',
              templateUrl:'views/adminUsersListView.html',
              controller:'AdminUserListCtrl'
          })
          .state('adminLeadsList',{
              url:'/adminLeadsList',
              templateUrl:'views/adminLeadListView.html',
              controller:'AdminLeadListCtrl'
          })
          .state('adminCompanyList',{
              url:'/adminCompanyList',
              templateUrl:'views/adminCompanyListView.html',
              controller:'AdminCompanyListCtrl'
          })
          .state('adminLeadHistoryList',{
              url:'/adminLeadHistoryList',
              templateUrl:'views/adminLeadsHistoryView.html',
              controller:'AdminLeadHistoryCtrl'
          });;
  }]);