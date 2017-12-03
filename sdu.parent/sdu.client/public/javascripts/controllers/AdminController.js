angular.module('MyApp')
    .controller('AdminUserListCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("Admin Users List Controller");
    }])
    .controller('AdminLeadListCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("Admin Leads List Controller");
    }])
    .controller('AdminCompanyListCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("Admin Company List Controller");
    }])
    .controller('AdminLeadHistoryCtrl', ['$http','$scope','$state','$rootScope',function($http,$scope,$state,$rootScope) {
        console.log("Admin Leads History Controller");
    }]);


