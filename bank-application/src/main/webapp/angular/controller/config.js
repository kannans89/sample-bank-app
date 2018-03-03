angular.module('mainApp', [ 'ngRoute' ])
.config(function($routeProvider) 
{
	$routeProvider
	.when("/", {
		templateUrl : "angular/template/home.htm",
			controller:"homeCtrl"
	})
	.when("/statics", {
		templateUrl : "angular/template/statics.htm",
		controller:"staticsCtrlr"
	})
	.when("/adminPassbookV", {
		templateUrl : "angular/template/adminPassbookView.htm",
		controller:"passbookCtrlr"
	})
	.when("/changeStatusV", {
		templateUrl : "angular/view/changeStatus.html",
		controller:"changeStatusCtrlr"
	})
	.when("/notifyPromotionV", {
		templateUrl : "angular/view/notifyPromotion.html",
		controller:"notifyPromotionCtrlr"
	})
});
