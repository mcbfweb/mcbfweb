<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<html>
<head>
<meta charset="utf-8">
<script src="http://maps.google.com/maps/api/js?sensor=true"
	type="text/javascript"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<sjm:head compressed='false' jqueryui="true" jquerytheme="ui-lightness" />
<script src="../js/jquery.ui.map.full.min.js" type="text/javascript"></script>
<script>
	var map, ren, ser;
	var data = {};
	function goma() {
		map = new google.maps.Map(document.getElementById('mappy'), {
			'zoom' : 12,
			'mapTypeId' : google.maps.MapTypeId.ROADMAP,
			'center' : new google.maps.LatLng(26.05678288577881, -80.30236816615798)
		})

		ren = new google.maps.DirectionsRenderer({
			'draggable' : true
		});
		ren.setMap(map);
		ser = new google.maps.DirectionsService();

		ser.route({
			'origin' : new google.maps.LatLng(26.104887637199948, -80.39231872768141),
			'destination' : new google.maps.LatLng(25.941991877144947, -80.16160583705641),
			'travelMode' : google.maps.DirectionsTravelMode.DRIVING
		}, function(res, sts) {
			if (sts == 'OK')
				ren.setDirections(res);
		});
	}

	function save_waypoints() {
		var w = [];
		var rleg = ren.directions.routes[0].legs[0];
		 
		data.start = {
			'lat' : rleg.start_location.lat(),
			'lng' : rleg.start_location.lng()
		};
		data.end = {
			'lat' : rleg.end_location.lat(),
			'lng' : rleg.end_location.lng()
		};
		var wp = rleg.via_waypoints
		for ( var i = 0; i < wp.length; i++)
			w[i] = [ wp[i].lat(), wp[i].lng() ]
		data.waypoints = w;

		var str = JSON.stringify(data)
        alert(str); 
		var jax = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject(
				'Microsoft.XMLHTTP');
		jax.open('POST', 'process.php');
		jax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		jax.send('command=save&mapdata=' + str)
		jax.onreadystatechange = function() {
			if (jax.readyState == 4) {
				if (jax.responseText.indexOf('bien') + 1)
					alert('Updated');
				else
					alert(jax.responseText)
			}
		}
	}
</script>

</head>
<body onLoad="goma()">
	<div id="mappy" style="width: 900px; height: 550px;"></div>
	<div
		style="width: 900px; text-align: center; margin: 0px auto 0px auto; margin-top: 10px;">
		<input type="button" value="Save Waypoints" onClick="save_waypoints()">
	</div>
</body>
</html>