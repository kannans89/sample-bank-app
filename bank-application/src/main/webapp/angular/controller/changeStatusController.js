angular.module('mainApp')
.controller('changeStatusCtrlr', function($scope,$rootScope, $http) {
	$http.post("changeStatusCtrl?userId="+$rootScope.userId).then(function(response) {
	});
});