angular.module("adminModule").controller("viewController", ['$scope','$location', function ($scope,$location) {
    $scope.msg = "notification Controller here...!!!";
    var object = $location.search();
    $scope.userId=object.userId;
    console.log($scope.userId);
}]);