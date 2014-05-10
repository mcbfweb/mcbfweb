<script>
	// find current position and on success initialize map and calculate the route
	$(document).on("pagecontainershow", function() {
		goma();
		//if (navigator.geolocation) {

		//	navigator.geolocation.getCurrentPosition(locSuccess, locError);

		//} else {
		//	alert("goma");
			//goma();
		//}
	});
</script>
<div id="map_canvas" style="width: 300px; height: 300px;">
	<div
		style="width: 350px; text-align: center; margin: 0px auto 0px auto; margin-top: 10px;">

	</div>
</div>