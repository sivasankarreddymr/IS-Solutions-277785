(function(){
	var app = angular.module("BMSapp");
	app.controller("LoginController", ['$scope','$http','appstore', '$state', '$rootScope',
	  function($scope, $http, appstore, $state, $rootScope) {
		$scope.user ={
			  username:'',
			  password:''
		};
		$rootScope.username = '';
		$scope.login =function(){
	      $http.post('/BMSApp/login', $scope.user).then(function(response){
	    	  if(response.data.success){
	    		  appstore.storeData('userDetails', response.data.data);
	    		  $rootScope.username = response.data.data.name;
	    		  $state.go('statements');
	    	  }else{
	    		  $scope.errormsg = response.data.data;
	    	  }
	      }); 
	  };
	}]);
})();
