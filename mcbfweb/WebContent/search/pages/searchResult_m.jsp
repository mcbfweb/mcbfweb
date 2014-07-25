
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<script>
	$(document).ready(function() {
		$('a.back').click(function() {
			parent.history.back();
			return false;
		});
	});
</script>

<jsp:include page="/inc.header.jsp" />

<s:url id="remoteurl" action="../Main/populateBizTypeArry.action" />



<sjm:div role="page" id="searchResultPage" jquerytheme="cupertino"
	data-theme="d" theme="simple">

	<sjm:div role="header" data-theme="d">

		<sjm:a href="#" button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>

		<h1>Search Result</h1>

		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>

	</sjm:div>

	<sjm:div role="content" data-theme="d">

		<s:if test="hasActionErrors()">

			<div class="errors">

				<s:actionerror />

			</div>

		</s:if>
		<s:form method="post">
			<s:hidden name="clientId" />

			<s:hidden id="lat" name="entity.locLat" value="%{entity.locLat}" />

			<s:hidden id="lon" name="entity.locLon" value="%{entity.locLon}" />



			<fieldset>

				<legend>



					<b>Search Info</b>



				</legend>



				<div class="ui-grid-d" data-theme="a">

					<div class="ui-block-a" style="width: 35%">

						<div class="ui-bar ui-bar-d">Name :</div>

					</div>

					<div class="ui-block-b" style="width: 65%">

						<div class="ui-bar ui-bar-d">

							<s:property value="entity.names[0].bizName" />

						</div>

					</div>

					<div class="ui-block-a" style="width: 35%">

						<div class="ui-bar ui-bar-d">Address :</div>

					</div>
					<s:iterator value="%{entity.addresses}" var="address" id="adr"
						status="idx">



						<div class="ui-block-b" style="width: 65%">
							<div class="ui-bar ui-bar-d">

								<s:property value="adrStrtNo" />

								<s:property value="adrstrNm" />
								,
								<s:property value="%{adrLine1}" />
								,

								<s:property value="%{adrCity}" />
								,
								<s:property value="%{adrState}" />
								<s:property value="%{adrPstCde}" />

							</div>
						</div>

					</s:iterator>



					<s:iterator value="%{entity.contacts}" var="contact" id="cnt"
						status="idx">

						<s:if test="#idx.first == true">

							<div class="ui-block-a" style="width: 35%">

								<div class="ui-bar ui-bar-d">Contact :</div>

							</div>
						</s:if>
						<s:if test="#idx.first == false">
							<div class="ui-block-a" style="width: 35%">

								<div class="ui-bar ui-bar-d">&nbsp;</div>

							</div>
						</s:if>

						<div class="ui-block-b" style="width: 65%">

							<div class="ui-bar ui-bar-d">

								(

								<s:property value="cntAreaCde" />

								)

								<s:property value="cntPhnNo" />

							</div>

						</div>
					</s:iterator>




					<div class="ui-block-a" style="width: 35%">

						<div class="ui-bar ui-bar-d">Services :</div>

					</div>

					<div class="ui-block-b" style="width: 65%">
						<div class="ui-bar ui-bar-d">

							<s:iterator value="%{entity.srvNames}" var="service" id="ser"
								status="idx">

								<s:property value="srvName" />

								<s:if test="#idx.last == false">
							,
							</s:if>
							</s:iterator>

						</div>
					</div>


					<div class="ui-block-a" style="width: 35%">

						<div class="ui-bar ui-bar-d">Products :</div>

					</div>

					<div class="ui-block-b" style="width: 65%">
						<div class="ui-bar ui-bar-d">

							<s:iterator value="%{entity.products}" var="product" id="prd"
								status="idx">

								<s:property value="prdDesc" />

								<s:if test="#idx.last == false">
							,
							</s:if>
							</s:iterator>

						</div>
					</div>


				</div>


				<div data-role="main" class="ui-content" data-content-theme="d">

					<div class="ui-grid-d" data-theme="a">

						<div class="ui-bar ui-bar-d">


							<div class="ui-block-a">
								<a href="#appointment" data-rel="popup"
									data-position-to="window" data-transition="fade"
									class="ui-btn ui-corner-all ui-shadow ui-btn-inline">Email/SMS</a>
							</div>

							<div class="ui-block-b">
								<a href="#popupMap" data-rel="popup" data-position-to="window"
									data-transition="fade"
									class="ui-btn ui-corner-all ui-shadow ui-btn-inline">Map</a>
							</div>

							<div class="ui-block-c">
								<s:submit value="Products"
									cssClass="button ui-state-default ui-corner-all"
									action="getProductList" clearForm="true" />
							</div>

						</div>

						<!-- <a href="#popupVideo" data-rel="popup" data-position-to="window"

                                  data-transition="fade" class="ui-btn ui-corner-all ui-shadow ui-btn-inline">Video</a> -->

					</div>



					<!-- SMS/Email -->

					<div data-role="popup" id="appointment" data-dismissible="false"
						data-overlay-theme='d' data-theme='d' data-corners='false'
						data-tolerance='15,15' style="width: 300px;">

						<div data-role="header">

							<h1>Appointment</h1>

						</div>

						<div data-role="main" class="ui-content">

							<s:iterator value="%{entity.contacts}" var="contact" id="cnt"
								status="idx">

								<a href=mailto: <s:property value="cntEmail" />>Email</a>

								<br />

								<a href=tel: <s:property value="cntAreaCde" />
									<s:property value="cntPhnNo" />>Phone</a>

								<br />

								<a href=sms: <s:property value="cntAreaCde" />
									<s:property value="cntPhnNo" />>SMS</a>

								<br />

							</s:iterator>

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
		</s:form>
	</sjm:div>





	<jsp:include page="/inc.footer.jsp" />

</sjm:div>





</body>

</html>

