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
					<center><b>Search Info</b></center>
				</legend>
				<sjm:div role="fieldcontain">

					<div>
						Name :
						<s:property value="entity.bizName" />
					</div>
					<sjm:div>
						<h4>Address</h4>
						Street :<s:property value="entity.streetNo" />  <s:property
							value="entity.streetName" /><br/>
						Address 1:<s:property value="entity.addrLine1" /><br/>
						Address 2:<s:property value="entity.addrLine2" /><br/>						 
					</sjm:div>
					<sjm:div data-role="collapsible">
						<h3>Contact</h3>
						Email :<s:property value="entity.addrLine1" />
						Phone :<s:property value="entity.isd" />+" "+Address 1:<s:property
							value="entity.areacode" />+ " "+Address 1:<s:property
							value="entity.phone" /> 
						Extention:<s:property value="entity.extension" />
					</sjm:div>


				</sjm:div>
			</fieldset>
	 
	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>


</body>
</html>
