(function(){
	var app = angular.module("BMSapp");
	app.controller("StatementsController", ['$scope','$http', 'appstore',function($scope, $http, appstore) {
		
		jQuery('.datepicker').datepicker().on('changeDate',function(e){
			$scope.customer[e.currentTarget.getAttribute('ng-model')] = e.format('mm/dd/yy');
		});
		jQuery(document).off('.datepicker.data-api');
		var userdata = appstore.getData('userDetails');
		$scope.customer ={};
		$scope.details = [];
		
		$scope.viewStatments =function(){
	      /*$http.post('/BMSApp/viewStatements', $scope.customer).then(function(response){
	    	  if(response.data.success)
	    	  	$scope.details = response.data.data;
	      }); */
		  $scope.details = [{
			  transactionDate: '12/12/2017',
			  description: 'Abc xyz kjh',
			  debitCredit: 'Debit',
			  balance:'12000'
		  }];
	    };
	    $scope.downloadStatments = function(){
	    	
	    };
	}]);
})();