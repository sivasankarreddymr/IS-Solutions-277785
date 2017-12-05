var app = angular.module('app', []);
alert("test");
app.controller('postcontroller', function($scope, $http, $location) {
	$scope.submitForm = function(){
		var url = "http://localhost:8080/bank-management-service/userRegistration/";
		 $window.alert(url);    
		var config = {
                headers : {
                    'Accept': 'text/plain'
                }
        }
		var data = {
            username: $scope.username,
            password: $scope.password
        };
		
		$http.post(url, data, config).then(function (response) {
			$scope.postResultMessage = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
		
		$scope.username = "";
		$scope.password = "";
	}
});

