<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />


<script type="text/javascript">
	$(function() {
		// Also works with: var yourStartLatLng = '59.3426606750, 18.0736160278';
		var yourStartLatLng = new google.maps.LatLng(59.3426606750, 18.0736160278);
		$('#map_canvas').gmap({
			'center' : yourStartLatLng
		});
	});
</script>

<sjm:div role="page" id="mappage" jquerytheme="redmond" data-theme="b"
	theme="simple">
	<sjm:div role="header" jquerytheme="redmond" data-theme="b">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Map Location</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content">
		<sjm:div id="map_canvas" style="width: 250px; height: 250px"></sjm:div>
		<jsp:include page="/inc.footer.jsp" />
	</sjm:div>
</sjm:div>
</body>
</html>