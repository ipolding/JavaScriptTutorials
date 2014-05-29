var whsMapper = angular.module('whsMapper', ['ngResource']);

window.alert("Sites isn't an array so we can't iterate through it!");	


whsMapper.controller('MapCtrl', ['$scope', '$resource',  

	function ($scope, $resource) {
		$scope.testData = 'Budapest';

		var dataService = $resource('/whs/site?id=2')
		$scope.sites = dataService.get();
		 

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