
angular.module('redlightApp.controllers',[]) 
  .controller('redlightCtrl', function ($scope, redlightService) {
  	$scope.camera = {};

    $scope.getCamera= function(){
    	var id= $scope.cameraID;
    	redlightService.sendCamera(id);
    	$scope.display();
    }

    $scope.display = function(){
    $scope.$watch(function(){return redlightService.getNewCamera();}, function(newVal, oldVal) {
     if (typeof newVal !== 'undefined') {
        $scope.camera = newVal;
        console.log(newVal);
        }
      });
	}	
  });
