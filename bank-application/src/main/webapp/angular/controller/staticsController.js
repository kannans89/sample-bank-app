angular.module('mainApp')
.controller('staticsCtrlr',function($scope, $rootScope, $http) 
	{
		console.log("staticController");
	    var year=new Date().getFullYear();
	    var month=((new Date().getMonth())+1);
	    if(month<10){
	    	month="0"+month;
	    }	
		var days=new Date(year, month, 0).getDate();
		var fDate = new Date(year+"-"+month+"-01");
		var tDate = new Date(year+"-"+month+"-"+days);

		$scope.fromDate=fDate;
		$scope.toDate=tDate;
		console.log($scope.toDate);
		
		
		
    $scope.getDates=function()
     {
		$scope.list=[];
		$scope.list.push($scope.fromDate);
		$scope.list.push($scope.toDate);
		
		console.log($scope.list);	
	    var stringJson = JSON.stringify($scope.list);  
        var data = $.param({
         dates:stringJson
        });
     
        var config = {
             headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'}
         }
     
	    $http.post("adminStatics",data,config).then(function(response) {
	    	$scope.staticsDetails=response.data;
		    console.log("staticController-success");
		    console.log($scope.staticsDetails);	 
	     });
     }
    $scope.getDates();
			
});