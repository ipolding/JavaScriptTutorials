var whsMapper = angular.module('whsMapper', []);

whsMapper.controller('MapCtrl', ['$scope', 

	function ($scope) {
		$scope.site = 'Budapest';

		$scope.addMarker = function() {
			var myLatlng = new google.maps.LatLng(lat, longitude);
  			var marker = new google.maps.Marker({
        	
        	position: myLatlng,
        	map: map,
        	title:"Hello World!"});
		}
			
		}

	]);