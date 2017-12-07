(function(){
	var app = angular.module("BMSapp");
	app.directive('modal', function(){
		return {
	      template: '<div class="modal fade">' + 
	          '<div class="modal-dialog">' + 
	            '<div class="modal-content">' + 
	              '<div class="modal-header">' + 
	                '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' + 
	                '<h4 class="modal-title">{{poptitle}}</h4>' + 
	              '</div>' + 
	              '<div class="modal-body" ng-transclude>{{popmessage}}</div>' + 
	            '</div>' + 
	          '</div>' + 
	        '</div>',
	      restrict: 'E',
	      transclude: true,
	      replace:true,
	      scope:true,
	      link: function postLink(scope, element, attrs) {
	        scope.$watch(attrs.visible, function(value){
	          if(value == true)
	            $(element).modal('show');
	          else
	            $(element).modal('hide');
	        });

	        $(element).on('shown.bs.modal', function(){
	          setTimeout(scope.$apply(function(){
	            scope.$parent[attrs.visible] = true;
	          }),10);
	        });

	        $(element).on('hidden.bs.modal', function(){
	          setTimeout(scope.$apply(function(){
	            scope.$parent[attrs.visible] = false;
	          }),10);
	        });
	      }
	    };
	});
})();