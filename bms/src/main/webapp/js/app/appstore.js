(function(){
	var app = angular.module("BMSapp");
	app.factory('appstore',[function(){
		var app = {};
		return{
			storeData: function(param, data){
				app[param] = data;
			},
			getData: function(param){
				return app[param];
			}
		};
	}]);
})();