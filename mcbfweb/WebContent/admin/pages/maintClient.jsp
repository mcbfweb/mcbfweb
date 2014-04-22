<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<%@ page import="cl.mainStream.*"%>
<%@ page import="java.util.List"%>

<jsp:include page="/inc.header.jsp" />
<s:url id="remoteurl" action="../Main/populateBizTypeArry.action" />
<sjm:div role="page" id="maintUser" jquerytheme="cupertino"
	data-theme="b" theme="simple">
	<sjm:div role="header">
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

			<fieldset>
				<legend>
					<b>Update Client</b>
				</legend>
				<sjm:div role="fieldcontain">

					<div data-tab="id">
						<h3>Name</h3>
						<s:include value="name.jsp"></s:include>
					</div>
					<sjm:select id="ctry" name="entity.ctry" class="ctry"
						label="Country" headerKey=" " headerValue="--Select a Country--"
						emptyOption="false" list="adrCountryArry" listKey="code"
						listValue="label" />

					<div data-role="collapsible-set" data-inset="false">
						<div data-role="inlinetabs">
							<ul>
								<li data-tab="id">Id</li>
								<li data-tab="address">Address</li>
								<li data-tab="contact">Contact</li>
							</ul>
							<s:include value="hidden.jsp"></s:include>
							<div data-tab="id">
								<h3>Identity</h3>
								<s:include value="entityId.jsp"></s:include>
							</div>
							<div data-tab="address">
								<h3>Addresses</h3>
								<s:include value="address.jsp"></s:include>
							</div>
							<div data-tab="contact">
								<h3>Contacts</h3>
								<s:include value="contact.jsp"></s:include>
							</div>
						</div>
					</div>
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


					<s:submit id="submitBtn" value="Update Client" align="center" />

				</sjm:div>
			</fieldset>
		</s:form>



	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>


</body>
</html>
