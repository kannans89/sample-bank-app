angular.module("adminModule").controller("adminIndexController", ['$scope','$http','getAdminService',function($scope,$http,getAdminService) {
    $scope.adminName=null;
    //get admin 
    getAdminService.getAdmin().then(function(response){
    	$scope.adminName = response.data;
    	console.log($scope.adminName);
    });
}]);

angular.module("adminModule").service('getAdminService', ['$http', function ($http) {
        this.getAdmin = function () {
            return $http.get("getAdminAction");
        };
}]);