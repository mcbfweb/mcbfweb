<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />
<s:url id="remoteurl" action="../Main/populateBizTypeArry.action" />
<sjm:div role="page" id="maintUser" jquerytheme="cupertino"
	data-theme="b" theme="simple">
	<sjm:div role="header">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Search Result</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content">
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>
		<s:hidden name="clientId" />
		<fieldset>
			<legend>
				<center>
					<b>Search Info</b>
				</center>
			</legend>
			<sjm:div role="fieldcontain">

				<div>
					Name :
					<s:property value="entity.bizName" />
				</div>
				<sjm:div>
					<h4>Address</h4>
						Street :<s:property value="%{entity.addresses[0].adrStrtNo}" />
					<s:property value="%{entity.addresses[0].adrStrtNm}" />
					<br />
						Address 1:<s:property value="%{entity.addresses[0].adrLine1}" />
					<br />
						Address 2:<s:property value="%{entity.addresses[0].adrLine2}" />
					<br />
				</sjm:div>
				<sjm:div>
					<h4>Contact</h4>
						Email :<s:property value="%{entity.contacts[0].cntEmail}" />
					<br />
						Phone : (  <s:property value="%{entity.contacts[0].cntAreaCde}" /> ) <s:property
						value="%{entity.contacts[0].cntPhnNo}" />

				</sjm:div>
				<div data-role=content>

					<p>Make Contact :</p>

					<a href=mailto:anil@creditbureau.com.sg>By mail</a><br /> <br />
					<a href=tel:83143414>By phone</a><br /> <br /> <a
						href=sms:83143414>By SMS</a><br /> <br />

				</div>

			</sjm:div>
		</fieldset>

	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>


</body>
</html>
