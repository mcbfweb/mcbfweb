<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />
<s:url id="remoteurl" action="../Main/populateBizTypeArry.action" />
<sjm:div role="page" id="maintUser" jquerytheme="redmond" data-theme="b" theme="simple">
	<sjm:div role="header">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Add Client</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content">
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>


		<s:form method="post" action="../Main/createClient.action"
			novalidate="novalidate">


			<div id="id">
				<h3>Name</h3>
				<s:include value="name.jsp"></s:include>
			</div>
			<sjm:select id="ctry " name="entity.ctry" class="ctry"
				label="Country" headerKey=" " headerValue="--Select a Country--"
				emptyOption="false" list="adrCountryArry" listKey="code"
				listValue="label" required="true" />

			<div role="main" class="ui-content">
				<div data-role="tabs">
					<div data-role="navbar">
						<ul>
							<li><a href="#id">Id</a></li>
							<li><a href="#address">Address</a></li>
							<li><a href="#contact">Contact</a></li>
							<li><a href="#srvname">Service</a></li>
						</ul>
					</div>


					<s:include value="hidden.jsp"></s:include>
					<div id="id">
						<s:include value="entityId.jsp"></s:include>
					</div>
					<div id="address">
						<s:include value="address.jsp"></s:include>
					</div>
					<div id="contact">
						<s:include value="contact.jsp"></s:include>
					</div>
					<div id="srvname">
						<s:include value="srvName.jsp"></s:include>
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

				<s:submit id="submitBtn" value="Add Client" align="center" />
			</div>

		</s:form>



	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>


</body>
</html>
