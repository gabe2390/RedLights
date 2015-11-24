angular.module('redlightApp.directives',[])
.directive('lightForm', function(){
      return {
        restrict : 'AE',
        templateUrl: '/resources/directives/lightForm.html',
        scope: false,
        controller : 'redlightCtrl'
  	 }
});