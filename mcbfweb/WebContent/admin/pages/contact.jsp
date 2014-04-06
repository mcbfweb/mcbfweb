<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>


<div data-role="inlinetabs">
	<ul>
		<li data-tab="cnt1">Contact 1</li>
		<li data-tab="cnt2">Contact 2</li>
	</ul>

	<div data-tab="cnt1">
		<sjm:textfield id="extention_0" name="entity.contacts[0].cntName"
			value="%{entity.contacts[0].cntName}" label="Name" required="true" />
		<sjm:textfield id="email_0" name="entity.contacts[0].cntEmail"
			value="%{entity.contacts[0].cntEmail}" label="Email" required="true" />

		<!-- <label for="email_0">Email</label> <input type="email"
			data-clear-btn="false" name="entity.contacts[0].cntEmail"
			id="email_0" value=" "> -->

		<%-- <sjm:textfield id="isd_0" name="entity.contacts[0].cntIsdCde"
			value="%{entity.contacts[0].cntIsdCde}" label="Country Code"
			required="true" /> --%>
			
		<sjm:select id="isd_0" name="entity.contacts[0].cntIsdCde" class="ISDCde"
			label="Country Code" headerKey="-1" headerValue="--Select a Country Code--"
			emptyOption="false"	list="ISDCdeArry" listKey="code" listValue="label" required="true"/>	
			
		<sjm:textfield id="areacode_0" name="entity.contacts[0].cntAreaCde"
			value="%{entity.contacts[0].cntAreaCde}" label="Area Code" />
		<sjm:textfield id="phone_0" name="entity.contacts[0].cntPhnNo"
			value="%{entity.contacts[0].cntPhnNo}" label="Phone No."
			required="true" />

	</div>
	<div data-tab="cnt2">
		<sjm:textfield id="name_1" name="entity.contacts[1].cntName"
			value="%{entity.contacts[1].cntName}" label="Name" required="false" />
		<sjm:textfield id="email_1" name="entity.contacts[1].cntEmail"
			value="%{entity.contacts[1].cntEmail}" label="Email" required="false" />
		<sjm:textfield id="isd_1" name="entity.contacts[1].cntIsdCde"
			value="%{entity.contacts[1].cntIsdCde}" label="Country Code"
			required="false" />
		<sjm:textfield id="areacode_1" name="entity.contacts[1].cntAreaCde"
			value="%{entity.contacts[1].cntAreaCde}" label="Area Code"
			required="false" />
		<sjm:textfield id="phone_1" name="entity.contacts[1].cntPhnNo"
			value="%{entity.contacts[1].cntPhnNo}" label="Phone No."
			required="false" />
	</div>


</div>



