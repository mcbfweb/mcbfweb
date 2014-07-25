<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<%@ page import="cl.mainStream.*"%>
<%@ page import="java.util.List"%>

<jsp:include page="/inc.header.jsp" />
<s:url id="remoteurl" action="../Main/populateBizTypeArry.action" />

<sjm:div role="page" id="maintUser" data-theme="d" theme="simple">

	<sjm:div role="header" data-position="fixed">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Maintain Client</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>

	<sjm:div role="content">
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>


		<s:form method="post" action="../Main/updateClient.action">

			<s:include value="hidden.jsp"></s:include>

			<sjm:div role="main" class="ui-content">
				<sjm:div id="name">					 
					<s:include value="name.jsp"></s:include>
					<sjm:textfield id="name_0" name="entity.url" value="%{entity.url}"
						label="Website" />
				</sjm:div>

				<sjm:select id="ctry " name="entity.ctry" class="ctry"
					label="Country" headerKey=" " headerValue="--Select a Country--"
					emptyOption="false" list="adrCountryArry" listKey="code"
					listValue="label" required="true" />


				<sjm:div data-role="collapsible-set" data-type="tabs" data-tabs="4"
					data-theme="d" data-content-theme="d">

					<sjm:div data-role="collapsible" data-collapsed="true">

						<h4>Id</h4>
						<sjm:div id="id">
							<s:include value="entityId.jsp"></s:include>
						</sjm:div>
					</sjm:div>
					<sjm:div data-role="collapsible" data-collapsed="true">
						<h4>Address</h4>
						<sjm:div id="address">
							<s:include value="address.jsp"></s:include>
						</sjm:div>
					</sjm:div>
					<sjm:div data-role="collapsible" data-collapsed="true">
						<h4>Contact</h4>
						<sjm:div id="contact">
							<s:include value="contact.jsp"></s:include>
						</sjm:div>
					</sjm:div>

				</sjm:div>



				<sjm:div id="srvname">
					<s:include value="srvName.jsp"></s:include>
				</sjm:div>


				<sjm:div data-role="collapsible-set" data-type="tabs" data-tabs="4"
					data-theme="d" data-content-theme="d">

					<sjm:div data-role="collapsible" data-collapsed="true">

						<h4>Industry/Group</h4>

						<sjm:select id="bizGroup" name="entity.ecoCode" class="bizGroup"
							label="Group" headerKey="-1" headerValue="--Select a Group--"
							emptyOption="false"
							onchange="showChange(this[this.selectedIndex].value, this.id)"
							list="bizGroupArry" listKey="code" listValue="label" />

						<sjm:select id="bizType" name="entity.bizCode" class="bizType"
							label="Type" headerKey="-1" headerValue="--Select a Type--"
							emptyOption="false"
							onchange="showChange(this[this.selectedIndex].value, this.id)"
							list="bizTypeArry" listKey="code" listValue="label" />

						<sjm:select id="indGrp" name="entity.grpCode" class="indGrp"
							label="Ind.Group" headerKey="-1" headerValue="--Select a Group--"
							emptyOption="false"
							onchange="showChange(this[this.selectedIndex].value, this.id)"
							list="indGrpArry" listKey="code" listValue="label" />

						<sjm:select id="industry" name="entity.indCode" class="industry"
							label="Industry" headerKey="-1"
							headerValue="--Select an Industry--" emptyOption="false"
							list="industryArry" listKey="code" listValue="label" />
					</sjm:div>
				</sjm:div>

				<s:submit id="submitBtn" value="Update Client" align="center" />
			</sjm:div>
		</s:form>



	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>


</body>
</html>
