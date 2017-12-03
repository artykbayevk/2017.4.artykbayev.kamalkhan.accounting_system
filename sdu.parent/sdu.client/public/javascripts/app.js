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
          .state('ownPage',{
              url:'/ownPage',
              templateUrl:'views/ownPageView.html',
              controller:'OwnPageCtrl'
          })



          .state('managerLeadAdd', {
              url:"/managerLeadAddUrl",
              templateUrl:"views/managerLeadAddView.html",
              controller:"ManagerLeadAddCtrl"
          })
          .state('managerNotActiveLeads', {
              url:"/managerNotActiveLeads",
              templateUrl:"views/managerNotActiveLeadsListView.html",
              controller:"ManagerNotActiveLeadCtrl"
          })
          .state('managerActiveLeads', {
              url:"/managerActiveLeads",
              templateUrl:"views/managerActiveLeadsView.html",
              controller:"ManagerActiveLeadCtrl"
          })

          .state('clientAllLeads', {
              url:"/clientAllLeads",
              templateUrl:"views/clientAllLeadsView.html",
              controller:"ClientAllLeadsCtrl"
          })
          .state('clientActiveLeads', {
              url:"/clientActiveLeads",
              templateUrl:"views/clientActiveLeadsView.html",
              controller:"ClientActiveLeadsCtrl"
          })
          .state('clientFinishedLeads', {
              url:"/clientFinishedLeads",
              templateUrl:"views/clientFinishedLeadsView.html",
              controller:"ClientFinishedLeadsCtrl"
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