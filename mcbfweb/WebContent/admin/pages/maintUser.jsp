<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />

<sjm:div role="page" id="maintUser" jquerytheme="cupertino"
	data-theme="b" theme="simple">
	<sjm:div role="header">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Maintain User</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content">
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>

		<sjm:div>
			<s:form id="getUserForm" method="post">
				<fieldset>
					<legend>
						<b>Update User</b>
					</legend>
					<sjm:div role="fieldcontain">
						<sjm:textfield id="client1" name="client1" label="Client ID"
							required="true" />
						<sjm:textfield id="usrid1" name="usrid1" label="User ID"
							required="true" />
					</sjm:div>
					<s:submit value="Get User" id="getUserBtn"
						cssClass="button ui-state-default ui-corner-all" action="getUser"
						clearForm="true" />
				</fieldset>
			</s:form>
		</sjm:div>

		<s:form id="maintUserForm" method="post">
			<fieldset>
				<legend>
					<b>Add New User</b>
				</legend>
				<sjm:div role="fieldcontain">
					<sjm:textfield id="client" name="client" label="Client ID"
						required="true" />
					<sjm:textfield id="usrid" name="usrid" label="User ID"
						required="true" />
					<sjm:textfield id="usrname" name="usrname" label="User Name"
						required="true" />

					<sjm:textfield id="email" name="email" label="Email" required="true" />
					
					<label for="email">Email:</label>
					<input data-clear-btn="false" name="email" id="email" value=""
						type="email">
					<sjm:textfield id="isd" name="isd" label="ISD" required="true" />

					<sjm:textfield id="areacode" name="areacode" label="Area Code" />

					<sjm:textfield id="phone" name="phone" label="Phone No."
						required="true" />

					<sjm:select id="role" name="role" class="role" headerKey="-1"
						headerValue="--Select User Role--" emptyOption="false"
						list="roleArry" listKey="code" listValue="label" />
					<sjm:select id="group" name="group" class="group" headerKey="-1"
						headerValue="--Select User Group--" emptyOption="false"
						list="groupArry" listKey="code" listValue="label" />
					<sjm:select id="status" name="status" class="status" headerKey="-1"
						headerValue="--Select Status--" emptyOption="false"
						list="statusArry" listKey="code" listValue="label" />

					<s:submit value="Add/Update User"
						cssClass="button ui-state-default ui-corner-all" action="addUpdateUser"
						clearForm="true" />
				</sjm:div>
			</fieldset>
		</s:form>



	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>


</body>
</html>
