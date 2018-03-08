angular.module("adminModule").controller("staticsController", ['$scope','getStaticsService', function ($scope,getStaticsService) {
    $scope.msg = "Statics Controller here...!!!";
    $scope.items = ['Last Week','Last Month','Last Year'];
    $scope.sortBy="deafult";
    
    //get default statics 
    getStaticsService.getStatics($scope.sortBy).then(function(response){
        	$scope.statics = response.data;
        	console.log("statics success"+$scope.statics);
   });
   
   //to get accounts statics of selected item
    $scope.selectedOption=function(selectedItem) {
    	$scope.sortBy=selectedItem;
    	getStaticsService.getStatics($scope.sortBy).then(function(response){
        	$scope.statics = response.data;
        	console.log("statics success"+$scope.statics);
   });
    }
}]);

//get statics service
angular.module("adminModule").service('getStaticsService', ['$http', function ($http) {
    this.getStatics = function (sortBy) {
        return $http.get("getAccountsStaticsAction?sortBy="+sortBy);
    };
}]);