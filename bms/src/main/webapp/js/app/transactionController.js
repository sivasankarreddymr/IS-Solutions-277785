(function(){
	var app = angular.module("BMSapp");
	app.controller("TransactionController", ['$scope','$http','$state','appstore',function($scope,$http,$state, appstore) {
		
		jQuery('.datepicker').datepicker().on('changeDate',function(e){
			$scope.customer[e.currentTarget.getAttribute('ng-model')] = e.format('mm/dd/yyyy');
		});
		jQuery(document).off('.datepicker.data-api');
		var userdata = appstore.getData('userDetails');
		$scope.customer ={};
		$scope.customer.accountNumber = userdata.accountNumber;

		
		
		$scope.saveTransaction =function(){
		  $scope.customer.accountNumber = userdata.accountNumber;
	      $http.post('/BMSApp/saveTransaction', $scope.customer).then(function(response){
	    	  if(response.data.success){
	    		$scope.showModal = true;
	  			$scope.poptitle = "Success";
	  			$scope.popmessage = response.data.data;
	  			$scope.resetForm();
	    	  }else{
	    		  $scope.errormsg = response.data.data;
	    	  }
	      }); 
	    };
	    
	    $scope.cancel =function(){
			   $state.go('statements');
		};
		
		$scope.resetForm = function(){
			$scope.customer ={};
			$scope.customer.accountNumber = userdata.accountNumber;
		};
	    
	}]);
})();
