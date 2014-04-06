<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

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


		<s:form id="addClientForm" method="post">
			<fieldset>
				<legend>
					<b>Add Client</b>
				</legend>
				<sjm:div role="fieldcontain">
					<sjm:textfield id="bizName" name="bizName"
						value="%{entity.bizName}" label="Business Name" required="true" />

					<div data-role="collapsible-set" data-inset="false">
						<div data-role="inlinetabs">
							<ul>
								<li data-tab="id">Id</li>
								<li data-tab="address">Address</li>
								<li data-tab="contact">Contact</li>
							</ul>

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
					<sjm:select id="bizGroup" name="bizGroup" class="bizGroup"
						label="Group" headerKey="-1" headerValue="--Select a Group--"
						emptyOption="false"
						onchange="showChange(this[this.selectedIndex].value, this.id)"
						list="bizGroupArry" listKey="code" listValue="label" />

					<sjm:select id="bizType" name="bizType" class="bizType"
						label="Type" headerKey="-1" headerValue="--Select a Type--"
						emptyOption="false" list="bizTypeArry" listKey="code"
						listValue="label" />


					<s:submit value="Add Client"
						cssClass="button ui-state-default ui-corner-all"
						action="createClient" clearForm="true" />
				</sjm:div>
			</fieldset>
		</s:form>



	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>


</body>
</html>
