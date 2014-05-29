var whsMapper = angular.module('whsMapper', ['ngResource']);

whsMapper.controller('MapCtrl', ['$scope', '$resource',  

	function ($scope, $resource) {
		$scope.testData = 'Budapest';

		var dataService = $resource('/whs/all')
		$scope.sites = dataService.query();				 

		$scope.latitude;
		$scope.longitude;

		$scope.addMarkerManually = function() {
			var myLatlng = new google.maps.LatLng($scope.latitude, $scope.longitude);
  			var marker = new google.maps.Marker({
        	
        	position: myLatlng,
        	map: map,
        	title:"Hello World!"});
		}
			
		}

	]);