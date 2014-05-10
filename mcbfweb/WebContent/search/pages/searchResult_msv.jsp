<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>


<jsp:include page="/inc.header.jsp" />
<sjm:div role="page" id="searchResultPage" data-theme="d" theme="simple"
	data-position="inline">

	<s:hidden name="clientId" />
	<s:hidden id="lat" name="entity.locLat" value="%{entity.locLat}" />
	<s:hidden id="lon" name="entity.locLon" value="%{entity.locLon}" />

	<sjm:div role="header" data-theme="d">
		<sjm:a href="./Main/SearchBiz" button="true" buttonIcon="arrow-l"
			data-rel="back" data-transition="slide" data-direction="reverse">Back</sjm:a>
		<h1>Search Result</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>


	<sjm:div data-role="content" data-theme="d">
		<sjm:div>
			Name :
			<s:property value="entity.names[0].bizName" />
		</sjm:div>
		<a href="#address" data-dialog="true" data-theme="d"
			class="ui-shadow ui-btn ui-corner-all ui-btn-inline"
			data-transition="pop">Address</a>
		<a href="#contact"
			class="ui-shadow ui-btn ui-corner-all ui-btn-inline"
			data-transition="pop">Contact</a>
		<a href="#appointment"
			class="ui-shadow ui-btn ui-corner-all ui-btn-inline"
			data-transition="pop">Call</a>
		<a href="#services"
			class="ui-shadow ui-btn ui-corner-all ui-btn-inline"
			data-transition="pop">Services</a>


	</sjm:div>

	<jsp:include page="/inc.footer.jsp" />
</sjm:div>

<sjm:div role="page" id="address" data-dialog="true" data-theme="d"
	theme="simple" data-position="inline">

	<sjm:div class="ui-content">
				Street :
				<s:property value="%{entity.addresses[0].adrStrtNo}" />
		<s:property value="%{entity.addresses[0].adrStrtNm}" />
		<br /> Address 1:
				<s:property value="%{entity.addresses[0].adrLine1}" />
		<br /> Address 2:
				<s:property value="%{entity.addresses[0].adrLine2}" />
	</sjm:div>
</sjm:div>

<sjm:div role="page" id="contact" data-dialog="true" data-theme="d"
	theme="simple" data-position="inline">

	<sjm:div data-theme="d" class="ui-content">
				Email :
				<s:property value="%{entity.contacts[0].cntEmail}" />
		<br /> Phone : (
				<s:property value="%{entity.contacts[0].cntAreaCde}" />
				)
				<s:property value="%{entity.contacts[0].cntPhnNo}" />
	</sjm:div>
</sjm:div>

<sjm:div role="page" id="appointment" data-dialog="true" data-theme="d"
	theme="simple" data-position="inline">

	<sjm:div data-theme="d" class="ui-content">
		<a href=mailto:anil@creditbureau.com.sg>Email</a>
		<br />
		<br />
		<a href=tel:83143414>Phone</a>
		<br />
		<br />
		<a href=sms:83143414>SMS</a>
		<br />
		<br />
	</sjm:div>
</sjm:div>

<sjm:div role="page" id="services" data-dialog="true" data-theme="d"
	theme="simple" data-position="inline">

	<sjm:div data-theme="d" class="ui-content">
		<s:include value="/maps/js/savewaypoints.jsp"></s:include>
	</sjm:div>
	
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>

</body>
</html>