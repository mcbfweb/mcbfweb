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


		<s:form id="maintClientForm" method="post">
			<fieldset>
				<legend>
					<b>Add/Update Client</b>
				</legend>
				<sjm:div role="fieldcontain">
					<sjm:textfield id="bizName" name="bizName" value="%{entity.bizName}" label="Business Name"
						required="true" />
					<sjm:textfield id="idtype" name="idTyp" value="%{entity.idTyp}" label="ID Type"
						required="true" />
					<sjm:textfield id="idnumber" name="idCode"  value="%{entity.idCode}" label="ID Number"
						required="true" />
					<sjm:div data-role="collapsible-set" data-inset="false">
						<sjm:div data-role="collapsible">
							<h3>Address</h3>
							<ul data-role="listview" data-inset="false">
								<li><sjm:textfield id="type" name="addtype"
										label="Address Type" required="true" /></li>
								<li><sjm:textfield id="streetNo" name="streetNo"
										label="Street No." required="true" /></li>
								<li><sjm:textfield id="streetName" name="streetName"
										label="Street Name" required="true" /></li>
								<li><sjm:textfield id="addrLine1" name="addrLine1"
										label="Address Line 1" required="true" /></li>
								<li><sjm:textfield id="addrLine2" name="addrLine2"
										label="Address Line 2" required="true" /></li>
							</ul>
						</sjm:div>
						<sjm:div data-role="collapsible">
							<h3>Contact</h3>
							<ul data-role="listview" data-inset="false">
								<li><sjm:textfield id="email" name="email" label="Email"
										required="true" /></li>
								<li><sjm:textfield id="isd" name="isd" label="Country Code"
										required="true" /></li>
								<li><sjm:textfield id="areacode" name="areacode"
										label="Area Code" /></li>
								<li><sjm:textfield id="phone" name="phone"
										label="Phone No." required="true" /></li>
								<li><sjm:textfield id="extention" name="extention"
										label="Extention" required="true" /></li>
							</ul>
						</sjm:div>

					</sjm:div>
					<sjm:select id="bizGroup" name="bizGroup" class="bizGroup"
						label="Group" headerKey="-1" headerValue="--Select a Group--"
						emptyOption="false" onchange="showChange(this[this.selectedIndex].value, this.id)"
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
