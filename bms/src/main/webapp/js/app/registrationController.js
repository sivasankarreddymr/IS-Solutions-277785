(function(){
	var app = angular.module("BMSapp");
	app.controller("RegistrationController", ['$scope','$http','$state','$window',function($scope,$http,$state) {
		
		jQuery('.datepicker').datepicker().on('changeDate',function(e){
			$scope.customer[e.currentTarget.getAttribute('ng-model')] = e.format('mm/dd/yyyy');
		});
		jQuery(document).off('.datepicker.data-api');
		
		$scope.customer ={};
		
		$scope.errorsList = [];
		$scope.successmsg = "";
		$scope.resetForm = function(){
			$scope.customer ={};
			$scope.dateOfBirth = '';
			$scope.registrationDate = '';
		};
		
		$scope.registration =function(){
		  $scope.errorsList = [];
	      $http.post('/BMSApp/register', $scope.customer).then(function(response){
	    	  if(response.data.success){
	    		  $scope.successmsg = response.data.data;
	    		  $scope.resetForm();
	    	  }else{
	    		  $scope.errorsList = response.data.data;
	    	  }
	      }); 
	   };
	   $scope.cancel =function(){
		   $state.go('login');
	   };
	}]);
})();

