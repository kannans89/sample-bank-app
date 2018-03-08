 angular.module("adminModule", ["ngRoute"]).config(['$routeProvider', f1]);

 function f1($routeProvider) {
     $routeProvider.when("/", {
         templateUrl: "template/home.html"
         , controller: "homeController"
     }).when("/statics", {
         templateUrl: "template/statics.html"
         , controller: "staticsController"
     }).when("/notification", {
         templateUrl: "template/notification.html"
         , controller: "notificationController"
     }).when("/sortBy", {
         templateUrl: "template/sortBy.html"
         , controller: "sortByController"
     }).when("/view", {
         templateUrl: "template/view.html"
             , controller: "viewController"
     });
 }