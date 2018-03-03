angular.module('mainApp')

.controller('homeCtrl',function($scope, $http, $rootScope) {
	
			$http.get("adminHome").then(function(response) {
				$scope.items = response.data;
			});

			$scope.sort="userId";
			
			$scope.idFunc = function(x) {
				$rootScope.userId = x;
			};

			$scope.status = "";

			$scope.changeStatus = function(x) {
				console.log("homectrl-changestatus")
				$rootScope.userId = x;
				$http.post("changeStatusCtrl?userId=" + $rootScope.userId)
						.then(function(response) {
						});
			};

			$rootScope.checkedList = [];

			$scope.toggleSelection = function(num, userId, event) {
				
				if (num != "all") 
				{
					if (event.target.checked) {
						$rootScope.checkedList.push(userId);
					} else {
						for (var i = 0; i < $rootScope.checkedList.length; i++) {
							if ($rootScope.checkedList[i] == userId) {
								$rootScope.checkedList.splice(i, 1);
								console.log(i);
							}
						}
					}
				} 
				else 
				{
					$rootScope.checkedList = [];
					if (event.target.checked) {
						for (var i = 0; i < $scope.items.length; i++) {
							$rootScope.checkedList.push($scope.items[i].userId);
						}
					} 
				}
				console.log(num + " userId-" + userId + " " + event.target.checked);
				console.log($rootScope.checkedList);
			};
			
			
			
			$scope.changeSort=function(event){
				console.log("changeSort");
				console.log($scope.sort);
//				$scope.sort=event.selected.value;
				console.log($scope.sort);
			}
			

		});