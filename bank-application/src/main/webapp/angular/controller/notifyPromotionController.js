angular.module('mainApp')
.controller('notifyPromotionCtrlr', function($scope,$rootScope, $http) {
     console.log("notifyPromotionCtrlr");
     
     var data1 = JSON.stringify($rootScope.checkedList);
     
     var data = $.param({
         checkedList:data1
     });
     
     var config = {
             headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'}
         }
//     $scope.error="please select user for promotion";
     console.log($rootScope.checkedList.length);
     if($rootScope.checkedList.length==0){
    	 $scope.error="please select valid users for promotion";
     }else{
	   $http.post("notifyPromotion",data,config).then(function(response) {
		 console.log("notifyPromotionCtrlr-success");
		 $scope.success="Promotional Email has been sent.....";
	});
}
});