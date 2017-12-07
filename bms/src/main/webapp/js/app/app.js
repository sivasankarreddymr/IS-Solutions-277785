(function(){
	var app = angular.module("BMSapp", ['ngRoute', 'ui.router']);
	app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
		
		  $urlRouterProvider.otherwise('/login');		  
		  $stateProvider.state({
		    name: 'login',
		    url: '/login',
		    controller: 'LoginController',
		    templateUrl: 'templates/login.html'
		  }).state({
		    name: 'registration',
		    url: '/registration',
		    controller: 'RegistrationController',
		    templateUrl: 'templates/registration.html'
		  }).state({
		    name: 'transaction',
		    url: '/transaction',
		    controller: 'TransactionController',
		    templateUrl: 'templates/transaction.html'
		  }).state({
		    name: 'statements',
		    url: '/statements',
		    controller: 'StatementsController',
		    templateUrl: 'templates/statements.html'
		  });
	}]).run(['appstore','$state', function(appstore, $state){
		/*if(!appstore.getData('userDetails')){
			$state.go('login');
		}*/
	}]);

})();



/*app.controller("HelloController", function($scope) {
  $scope.message = "Hello, AngularJS";	
  $scope.page ='';
});*/