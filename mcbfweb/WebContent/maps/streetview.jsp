<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />


<script type="text/javascript">
	$(function() {
		/* $('#map_canvas').gmap({
			'center' : '42.345573,-71.098326'
		}).bind('init', function(evt, map) {
			$('#map_canvas').gmap('displayStreetView', 'panel', {
				'position' : map.getCenter(),
				'pov' : {
					'heading' : 34,
					'pitch' : 10,
					'zoom' : 1
				}
			});
		}); */

		/* $('#map_canvas').gmap({
			'callback' : function() {
				this.displayStreetView('panel', {
					'position' : map.getCenter(),
					'pov' : {
						'heading' : 34,
						'pitch' : 10,
						'zoom' : 1
					}
				});
			}
		}); */

		 $('#map_canvas').gmap('displayStreetView', 'panel', {
			'position' : google.maps.LatLng(42.345573, -71.098326),
			'pov' : {
				'heading' : 34,
				'pitch' : 10,
				'zoom' : 1
			}
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
		<sjm:div id="map_canvas" style="width: 350px; height: 550px"></sjm:div>
		<jsp:include page="/inc.footer.jsp" />
	</sjm:div>
</sjm:div>
</body>
</html>