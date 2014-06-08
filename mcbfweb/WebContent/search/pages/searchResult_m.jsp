<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />
<s:url id="remoteurl" action="../Main/populateBizTypeArry.action" />



<sjm:div role="page" id="searchResultPage" jquerytheme="cupertino"
	data-theme="d" theme="simple">
	<sjm:div role="header" data-theme="d">
		<sjm:a href="./Main/SearchBiz" button="true" buttonIcon="arrow-l"
			data-rel="back">Back</sjm:a>
		<h1>Search Result</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content" data-theme="d">
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>
		<s:hidden name="clientId" />
		<s:hidden id="lat" name="entity.locLat" value="%{entity.locLat}" />
		<s:hidden id="lon" name="entity.locLon" value="%{entity.locLon}" />
		<fieldset>
			<legend>

				<b>Search Info</b>

			</legend>

			<div class="ui-grid-d" data-theme="a">
				<div class="ui-block-a">Name :</div>
				<div class="ui-block-b">
					<s:property value="entity.names[0].bizName" />
				</div>
				<div class="ui-block-a">Address :</div>
				<div class="ui-block-b">
					<s:property value="%{entity.addresses[0].adrStrtNo}" />
					<s:property value="%{entity.addresses[0].adrStrtNm}" />
					<s:property value="%{entity.addresses[0].adrLine1}" />
				</div>
				<div class="ui-block-b">
					<s:property value="%{entity.addresses[0].adrLine2}" />
				</div>
				<div class="ui-block-a">Contact :</div>
				<div class="ui-block-b">
					(
					<s:property value="%{entity.contacts[0].cntAreaCde}" />
					)
					<s:property value="%{entity.contacts[0].cntPhnNo}" />
				</div>
			</div>
			<div data-role="main" class="ui-content" data-content-theme="d">

				<a href="#appointment" data-rel="popup" data-position-to="window"
					data-transition="fade"
					class="ui-btn ui-corner-all ui-shadow ui-btn-inline">Contact Us</a>

				<a href="#popupMap" data-rel="popup" data-position-to="window"
					data-transition="fade"
					class="ui-btn ui-corner-all ui-shadow ui-btn-inline">Map</a> <a
					href="#popupVideo" data-rel="popup" data-position-to="window"
					data-transition="fade"
					class="ui-btn ui-corner-all ui-shadow ui-btn-inline">Video</a>


				<!-- SMS/Email -->
				<div data-role="popup" id="appointment" data-dismissible="false"
					data-overlay-theme='d' data-theme='d' data-corners='false'
					data-tolerance='15,15' style="width: 300px;">
					<div data-role="header">
						<h1>Appointment</h1>
					</div>
					<div data-role="main" class="ui-content">
						<a href=mailto:anil@creditbureau.com.sg>Email</a><br /> <br /> <a
							href=tel:83143414>Phone</a><br /> <br /> <a href=sms:83143414>SMS</a><br />

					</div>
					<br /> <a href='#' data-rel='back' data-role='button'
						data-theme='b' data-icon='delete' data-iconpos='notext'
						class='ui-btn-right'>Close</a>
					<div data-role="footer" data-theme="d">
						<h1>SMS / Email</h1>
					</div>
				</div>

				<!-- Map -->
				<div data-role='popup' id='popupMap' data-dismissible="false"
					data-overlay-theme='d' data-theme='d' data-corners='false'
					data-tolerance='15,15' style="width: 300px;">
					<div data-role="header">
						<h1>Map</h1>
					</div>
					<s:include value='map.jsp'></s:include>
					<br /> <a href='#' data-rel='back' data-role='button'
						data-theme='d' data-icon='delete' data-iconpos='notext'
						class='ui-btn-right'>Close</a>
					<div data-role="footer" data-position="fixed">
						<h1>Map</h1>
					</div>
				</div>

				<!--calendar -->
				<div data-role='popup' id='popupCalendar' data-dismissible="false"
					data-overlay-theme='d' data-theme='d' data-corners='false'
					data-tolerance='15,15' style="width: 300px;">
					<div data-role="header">
						<h1>Map</h1>
					</div>
					<s:include value='calendar.jsp'></s:include>
					<br /> <a href='#' data-rel='back' data-role='button'
						data-theme='d' data-icon='delete' data-iconpos='notext'
						class='ui-btn-right'>Close</a>
					<div data-role="footer" data-position="fixed">
						<h1>Schedule</h1>
					</div>
				</div>

				<!-- Video -->
				<div data-role="popup" id="popupVideo" data-dismissible="false"
					data-overlay-theme='d' data-theme='d' data-corners='false'
					data-tolerance='15,15'>

					<iframe src="http://player.vimeo.com/video/41135183" width="497"
						height="298" seamless></iframe>

					<br /> <a href='#' data-rel='back' data-role='button'
						data-theme='b' data-icon='delete' data-iconpos='notext'
						class='ui-btn-right'>Close</a>
				</div>




			</div>




		</fieldset>
	</sjm:div>


	<jsp:include page="/inc.footer.jsp" />
</sjm:div>


</body>
</html>
