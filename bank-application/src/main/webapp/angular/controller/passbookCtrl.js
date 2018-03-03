angular.module('mainApp')
.controller('passbookCtrlr', function($scope,$rootScope, $http) {

	$http.get("adminPassbook?userId="+$rootScope.userId).then(function(response) {
		$scope.transactions = response.data;
	});
});