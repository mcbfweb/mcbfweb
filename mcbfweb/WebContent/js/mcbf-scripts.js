var xmlHttp;

function filterByType(str, str2) {

	// alert(str + "_" + str2);

	if (typeof XMLHttpRequest != "undefined") {

		xmlHttp = new XMLHttpRequest();

	} else if (window.ActiveXObject) {

		alert("Microsoft");

		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");

	}

	if (xmlHttp == null) {

		alert("Browser does not support XMLHTTP Request")

		return;

	}

	if (str2 == "bizType") {

		url = "../sortByType.jsp";

		url += "?bizType=" + str;

		// alert(url);

		xmlHttp.onreadystatechange = filterTypeChange;

	}

	xmlHttp.open("GET", url, true);

	xmlHttp.send(null);

}

function filterTypeChange() {

	// alert("ready State = "+ xmlHttp.readyState);

	if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {

		var obj = document.getElementById("filterList");

		var inner = xmlHttp.responseText;

		$("#filterList").empty().append(inner);
		$("#filterList").listview().listview('refresh');
		$("#filterList").on("filterablebeforefilter", function(e, data) {
			e.preventDefault();

		});
	}

}

function showChange(str, str2) {

	// alert(str + "_" + str2);

	var url = "";

	var e;

	if (typeof XMLHttpRequest != "undefined") {

		xmlHttp = new XMLHttpRequest();

	} else if (window.ActiveXObject) {

		alert("Microsoft");

		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");

	}

	if (xmlHttp == null) {

		alert("Browser does not support XMLHTTP Request")

		return;

	}

	if (str2 == "bizGroup") {

		url = "../bizType.jsp";

		e = document.getElementById("bizGroup");

		bizGroup = e.options[e.selectedIndex].value;

		url += "?bizGroup=" + str;

		xmlHttp.onreadystatechange = bizGroupChange;

	}

	if (str2 == "bizType") {

		url = "../indGrp.jsp";

		e = document.getElementById("bizType");

		bizGroup = e.options[e.selectedIndex].value;

		url += "?bizType=" + str;

		xmlHttp.onreadystatechange = bizTypeChange;

	}

	if (str2 == "indGrp") {

		url = "../industry.jsp";

		e = document.getElementById("indGrp");

		bizGroup = e.options[e.selectedIndex].value;

		url += "?indGrp=" + str;

		xmlHttp.onreadystatechange = indGrpChange;

	}

	xmlHttp.open("GET", url, true);

	xmlHttp.send(null);

}

function bizGroupChange() {

	if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {

		// document.getElementById("district0_en").innerHTML=xmlHttp.responseText;

		var obj = document.getElementById("bizType");

		var inner = xmlHttp.responseText;

		select_innerHTML(obj, inner);

	}

}

function bizTypeChange() {

	if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {

		// document.getElementById("district0_en").innerHTML=xmlHttp.responseText;

		var obj = document.getElementById("indGrp");

		var inner = xmlHttp.responseText;

		select_innerHTML(obj, inner);

	}

}

function indGrpChange() {

	if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {

		// document.getElementById("district0_en").innerHTML=xmlHttp.responseText;

		var obj = document.getElementById("industry");

		var inner = xmlHttp.responseText;

		select_innerHTML(obj, inner);

	}

}

// /this whole method as needed as cannot add options to select in IE

/*******************************************************************************
 * 
 * select_innerHTML - corrige o bug do InnerHTML em selects no IE Veja o
 * 
 * problema em: http://support.microsoft.com/default.aspx?scid=kb;en-us;276228
 * 
 * Versão: 2.1 - 04/09/2007 Autor: Micox - Náiron José C. Guimarães -
 * 
 * micoxjcg@yahoo.com.br
 * 
 * 
 * 
 * @objeto(tipo HTMLobject): o select a ser alterado
 * 
 * @innerHTML(tipo string): o novo valor do innerHTML
 * 
 ******************************************************************************/

function select_innerHTML(objeto, innerHTML) {

	objeto.innerHTML = ""

	var selTemp = document.createElement("myselect")

	var opt;

	selTemp.id = "myselect1"

	document.body.appendChild(selTemp)

	selTemp = document.getElementById("myselect1")

	selTemp.style.display = "none"

	if (innerHTML.indexOf("<option") < 0) {

		innerHTML = "<option>" + innerHTML + "</option>"

	}

	innerHTML = innerHTML.replace(/<option/g, "<span").replace(/<\/option/g,

	"</span")

	selTemp.innerHTML = innerHTML

	for (var i = 0; i < selTemp.childNodes.length; i++) {

		var spantemp = selTemp.childNodes[i];

		if (spantemp.tagName) {

			opt = document.createElement("OPTION")

			if (document.all) { // IE

				objeto.add(opt)

			} else {

				objeto.appendChild(opt)

			}

			// getting attributes

			for (var j = 0; j < spantemp.attributes.length; j++) {

				var attrName = spantemp.attributes[j].nodeName;

				var attrVal = spantemp.attributes[j].nodeValue;

				if (attrVal) {

					try {

						opt.setAttribute(attrName, attrVal);

						opt.setAttributeNode(spantemp.attributes[j]

						.cloneNode(true));

					} catch (e) {

					}

				}

			}

			// getting styles

			if (spantemp.style) {

				for ( var y in spantemp.style) {

					try {

						opt.style[y] = spantemp.style[y];

					} catch (e) {

					}

				}

			}

			// value and text

			opt.value = spantemp.getAttribute("value")

			opt.text = spantemp.innerHTML

			// IE

			opt.selected = spantemp.getAttribute('selected');

			opt.className = spantemp.className;

		}

	}

	document.body.removeChild(selTemp)

	selTemp = null

}

var map, ren, ser;

var data = {};

function goma() {

	var lat = document.getElementById('lat').value;

	var lon = document.getElementById('lon').value;

	// alert(destinationLatitude + ' '+ destinationLongitude+ ' '+lat + '
	// '+lon);

	var mapOptions = {
		zoom : 12,
		center : new google.maps.LatLng(lat, lon),
		disableDefaultUI : true
	};

	var map = new google.maps.Map(document.getElementById('map_canvas'),

	mapOptions);

	var marker = new google.maps.Marker({
		position : map.getCenter(),
		map : map,
		title : 'Click to zoom'
	});

	// google.maps.event.addDomListener(window, 'load', initialize);

	/*
	 * google.maps.event.addListener(map, 'center_changed', function() { // // 3
	 * seconds after the center of the map has changed, pan back to the
	 * 
	 * marker.window.setTimeout(function() { map.panTo(marker.getPosition()); },
	 * 
	 * 3000); });
	 */
	/*
	 * google.maps.event.addListener(marker, 'click', function() {
	 * 
	 * map.setZoom(8); map.setCenter(marker.getPosition()); });
	 * 
	 * google.maps.event.trigger(map, 'resize');
	 */

}

var map, currentPosition, directionsDisplay, directionsService;

var destinationLatitude;
var destinationLongitude;
var directionId;
var mapPageId;

function initializeMapAndCalculateRoute(lat, lon) {
	directionsDisplay = new google.maps.DirectionsRenderer();
	directionsService = new google.maps.DirectionsService();

	destinationLatitude = document.getElementById('lat').value;
	destinationLongitude = document.getElementById('lon').value;

	//alert(destinationLatitude + ' ' + destinationLongitude + ' ' + lat + ' '
	//		+ lon);

	currentPosition = new google.maps.LatLng(lat, lon);

	map = new google.maps.Map(document.getElementById('map_canvas'), {
		zoom : 15,
		center : currentPosition,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	});

	directionsDisplay.setMap(map);

	var currentPositionMarker = new google.maps.Marker({
		position : currentPosition,
		map : map,
		title : "Current position"
	});

	// calculate Route
	calculateRoute(destinationLatitude, destinationLongitude);
}

function locError(error) {
	// the current position could not be located
}

function locSuccess(position) {
	// initialize map with current position and calculate the route
	initializeMapAndCalculateRoute(position.coords.latitude,
			position.coords.longitude);
	var crd = position.coords;
	console.log('Your current position is:');
	console.log('Latitude : ' + crd.latitude);
	console.log('Longitude: ' + crd.longitude);
	console.log('More or less ' + crd.accuracy + ' meters.');
}

function calculateRoute(desLat, desLon) {
	//alert(lat + ' ' + lon + ' ' + desLat + ' ' + desLon);

	var targetDestination = new google.maps.LatLng(desLat, desLon);

	//alert(targetDestination + ' ' + currentPosition);

	if (currentPosition != '' && targetDestination != '') {

		var request = {
			origin : currentPosition,
			destination : targetDestination,
			travelMode : google.maps.DirectionsTravelMode["DRIVING"]
		};

		directionsService.route(request, function(response, status) {
			if (status == google.maps.DirectionsStatus.OK) {
				directionsDisplay.setPanel(document
						.getElementById("directions"));
				directionsDisplay.setDirections(response);
				//alert(status);
				// alert('map_page' + mapPageId);
				/*
				 * var myRoute = response.routes[0].legs[0]; for (var i = 0; i <
				 * myRoute.steps.length; i++) {
				 * alert(myRoute.steps[i].instructions); }
				 */
				$("#results").show();
			} else {
				// alert('map_page' + mapPageId);
				$("#results").hide();
			}
		});
	} else {
		// alert('map_page' + document.getElementById("map_page"));
		$("#results").hide();
	}
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

	for (var i = 0; i < wp.length; i++)

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

$.widget("ui.tabs", $.ui.tabs, {

	_createWidget : function(options, element) {
		var page, delayedCreate, that = this;

		if ($.mobile.page) {
			page = $(element).parents(":jqmData(role='page'),:mobile-page")
					.first();

			if (page.length > 0 && !page.hasClass("ui-page-active")) {
				delayedCreate = this._super;
				page.one("pagebeforeshow", function() {
					delayedCreate.call(that, options, element);
				});
			}
		} else {
			return this._super();
		}
	}
});

/*
 * 
 * center_map
 * 
 * 
 * 
 * This function will center the map, showing all markers attached to this map
 * 
 * 
 * 
 * @type function @date 8/11/2013
 * 
 * 
 * 
 * @since 4.3.0
 * 
 * 
 * 
 * @param map (Google Map object) @return n/a
 * 
 */

function center_map(map) {

	google.maps.event.trigger(map, 'resize');

	// map.setCenter(map.marker.getPosition());

	// vars

	// var bounds = new google.maps.LatLngBounds();

	// alert(bounds);

	// map.setCenter(bounds.getCenter());

	// map.setZoom(14);

	// map.fitBounds(bounds);

}

function getRealContentHeight() {
	var header = $.mobile.activePage.find("div[data-role='header']:visible");
	var footer = $.mobile.activePage.find("div[data-role='footer']:visible");
	var content = $.mobile.activePage
			.find("div[data-role='content']:visible:visible");
	var viewport_height = $(window).height();

	var content_height = viewport_height - header.outerHeight()
			- footer.outerHeight();
	if ((content.outerHeight() - header.outerHeight() - footer.outerHeight()) <= viewport_height) {
		content_height -= (content.outerHeight() - content.height());
	}
	return content_height;
}