angular.module("adminModule").controller("homeController", ['$rootScope','$scope','$http','getAccountsService',function($rootScope,$scope,$http,getAccountsService) {
    $scope.items = ['accountStatus','balance','userId']
    $scope.accountStatus = ['Active','Deactive']
    $scope.notifyList= [];
    $scope.enabledNotify=true;
    $scope.adminName=null;
    //get accounts list
    getAccountsService.getAccounts().then(function(response){
                $rootScope.accounts = response.data;
    });
    
    //change current status
    $scope.changeStatus = function(accountStatus,userId) {
        console.log("status "+accountStatus+" user Id: "+userId);
        $http.get("changeAccountStatusAction?userId="+userId+"&&accountStatus="+accountStatus).then(function (response) {
        	console.log("Success");
        	$rootScope.accounts = response.data;
        	window.alert("Status Changed successfully...");
        });
    };
    
  //notify to all user
    $scope.notifyAll = function(id) {
        console.log("Is Notify All: "+id);
        console.log("Is Notify All: "+$scope.notifyList);
        $scope.sendToAll=id;
        if(id) {
        	 $scope.notifyList=[];
             for(x in $rootScope.accounts)
             	$scope.notifyList.push($rootScope.accounts[x].userId);
             console.log($scope.notifyList);
        }
        else {
        	$scope.notifyList=[];
        	console.log($scope.notifyList);
        }
    };
    
  //notify to some user
    $scope.notify = function(userId,checkedStatus) {
    	if(checkedStatus) {
    		$scope.notifyList.push(userId);
    		console.log($scope.notifyList);
    		$scope.enabledNotify=false;
    	}
    	else {
    		for(i in $scope.notifyList) {
    			if($scope.notifyList[i]==userId) {
    				$scope.notifyList.splice(i,1);
    				$scope.sendToAll=false;
    			}
    		}
    		console.log($scope.notifyList);
    		$scope.enabledNotify=true;
    	}
        console.log("Notify to this user :"+userId +checkedStatus);
    };
    
    //send notification
    $scope.sendNotification=function() {
    	if($scope.sendToAll) {
    		console.log("notification sent successfully to all users");
    		$http.get("notificationAction?notifyTo=allUser").then(function (response) {
    	        	console.log("Success");
    	        	window.alert("All users Notified successfully...");
    	    });
    	}
    	else {
    		for(var i=0;i<$scope.notifyList.length;i++) {
    			console.log("i "+$scope.notifyList[i]);
    			$http.get("notificationAction?notifyTo=specificUser&&userId="+$scope.notifyList[i]).then(function (response) {
    	        	console.log("Success");
    			});
    		}
    		window.alert("Notified successfully...");
    	}
    }
    
}]);

angular.module("adminModule").service('getAccountsService', ['$http', function ($http) {
        this.getAccounts = function () {
            return $http.get("getAccountsAction");
        };
}]);