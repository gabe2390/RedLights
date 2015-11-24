angular.module('redlightApp.services',[])
.factory('redlightService', ['$http',function($http){
	var camera={};

	var sendCamera= function(id){
		$http({
	   		method:'GET',
	    	url: 'http://127.0.0.1:8080/camera?ID='+id
	 	}).then(function successCallback(response){
	    	camera = response.data;
	  		console.log(camera);
		});
		return camera;
	}
	var getNewCamera = function(){
		console.log(camera);
		return camera;
	}
	return{
		sendCamera : sendCamera,
		getNewCamera : getNewCamera
	}
}])