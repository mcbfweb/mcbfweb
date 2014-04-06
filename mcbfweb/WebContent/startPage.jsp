<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />
<script>
	jQuery(window).ready(function() {
		jQuery("#btnInit").click(initiate_geolocation);
	});

	function initiate_geolocation() {
		navigator.geolocation.getCurrentPosition(handle_geolocation_query,
				handle_errors);

	}

	function handle_errors(error) {
		switch (error.code) {
		case error.PERMISSION_DENIED:
			alert("user did not share geolocation data");
			break;

		case error.POSITION_UNAVAILABLE:
			alert("could not detect current position");
			break;

		case error.TIMEOUT:
			alert("retrieving position timed out");
			break;

		default:
			alert("unknown error");
			break;
		}
	}

	function handle_geolocation_query(position) {
		
		document.forms['startPage'].action = './Main/SearchBiz.action?latitude='+position.coords.latitude+'&longtitude='+position.coords.longitude;
		document.forms['startPage'].submit;
		
		//document.forms[0].action = './Main/SearchBiz.action?latitude='+position.coords.latitude+'&longtitude='+position.coords.longitude;
		//document.forms[0].submit;
		
	}
</script>

<%
	session.setAttribute("application", request.getParameter("user_search"));
	session.setAttribute("partner", request.getParameter("public"));
%>
<sjm:div role="page" id="searchBizpage" jquerytheme="redmond"
	data-theme="b" theme="simple">

	<sjm:div role="header">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Search</h1>
		<sjm:a href="#indexControl" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content">


		<sjm:div>
			<s:form id="startPage" method="post">
				<input type="hidden" id="latitude" name="latitude" />
				<input type="hidden" id="longtitude" name="longtitude" />
				
				<button id="btnInit">Start Search</button>
			</s:form>
		</sjm:div>



	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>

</body>
</html>