var whsMapper = angular.module('whsMapper', ['ngResource']);



whsMapper.controller('MapCtrl', ['$scope', '$resource',  

	function ($scope, $resource) {
		$scope.testData = 'Budapest';

		var dataService = $resource('/whs/site?id=2')
		$scope.apiCall = dataService.get();
		 

		$scope.latitude;
		$scope.longitude;

		$scope.addMarker = function() {
			var myLatlng = new google.maps.LatLng($scope.latitude, $scope.longitude);
  			var marker = new google.maps.Marker({
        	
        	position: myLatlng,
        	map: map,
        	title:"Hello World!"});
		}
			
		}

	]);