(function(){
	var app = angular.module("BMSapp");
	app.controller("RegistrationController", ['$scope','$http','$window',function($scope,$http) {
		
		jQuery('.datepicker').datepicker().on('changeDate',function(e){
			$scope.customer[e.currentTarget.getAttribute('ng-model')] = e.format('mm/dd/yy');
		});
		jQuery(document).off('.datepicker.data-api');
		
		$scope.customer ={};
		$scope.showModal = true;
		$scope.poptitle = "Success";
		$scope.popmessage = "Success";
	  
		$scope.registration =function(){
	      $http.post('/BMSApp/register', $scope.customer).then(function(response){
	    	  if(response.data.success){
	    		  
	    	  }else{
	    		  $scope.errormsg = response.data.data;
	    		  window.alert(response.data.data);
	    	  }
	      }); 
	   };
	}]);
})();


/*
var app = angular.module("app", []);

app.directive('regTemplateView', function() {
  return {
    restrict: 'E', 
    scope: {
      data: '=',
    },
    templateUrl: 'templates/registration.html',
  };
});
app.controller("RegistrationController", [$http,function($http) {
	
  this.userdata = {
		  name:'',
		  username:'',
		  password:'',
		  confirmPassword:'',
		  dateOfBirth:'',
		  gender:'',
		  contactNumber:'',
		  emailId:'',
		  citigenship:'',
		  accountType:'',
		  registrationDate:'',
		  citizenStatus:'',
		  branchName:'',
		  depositAmount:'',
		  panNumber:'',
		  addressLine1:'',
		  addressLine2:'',
		  city:'',
		  state:'',
		  country:'',
		  PinNumber:''
  };
			  
  	
  this.login =function(){
	  this.jsonObj = angular.toJson(this.user, false); 
      var response = $http.put('/BMSApp/login', this.jsonObj); 
      response.success(function(data) { 
    	   if(data.success == 'true'){
    		   	// launch home page
    	   }else {
    		   // show error as invalid credentials
    	   }
       }); 
      response.error(function(data, status, headers, config) { 
            alert("AJAX failed to get data, status=" + status); 
       }); 
  };
}]);*/