(function(){
	var app = angular.module("BMSapp");
	app.controller("TransactionController", ['$scope','$http','appstore',function($scope,$http, appstore) {
		
		jQuery('.datepicker').datepicker().on('changeDate',function(e){
			$scope.customer[e.currentTarget.getAttribute('ng-model')] = e.format('mm/dd/yy');
		});
		jQuery(document).off('.datepicker.data-api');
		var userdata = appstore.getData('userDetails');
		$scope.customer ={};
	  
		$scope.saveTransaction =function(){
	      $http.post('/BMSApp/saveTransaction', $scope.customer).then(function(response){
	    	  //console.log(response);
	    	  if(response.data.success){
	    		  
	    	  }else{
	    		  $scope.errormsg = response.data.data;
	    	  }
	      }); 
	    };
	}]);
})();
