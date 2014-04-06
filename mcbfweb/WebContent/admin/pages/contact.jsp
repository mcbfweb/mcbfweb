<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>


<div data-role="inlinetabs">
	<ul>
		<li data-tab="cnt1">Contact 1</li>
		<li data-tab="cnt2">Contact 2</li>
	</ul>

	<div data-tab="cnt1">
	    <sjm:textfield id="extention_0" name="entity.contacts[0].cntName"
			value="%{entity.contacts[0].v}" label="Name" required="true" />
		<sjm:textfield id="email_0" name="entity.contacts[0].cntEmail"
			value="%{entity.contacts[0].cntEmail}" label="Email" required="true" />
		<sjm:textfield id="isd_0" name="entity.contacts[0].cntIsdCde"
			value="%{entity.contacts[0].cntIsdCde}" label="Country Code" required="true" />
		<sjm:textfield id="areacode_0" name="entity.contacts[0].cntAreaCde"
			value="%{entity.contacts[0].cntAreaCde}" label="Area Code" />		
		<sjm:textfield id="phone_0" name="entity.contacts[0].cntPhnNo"
			value="%{entity.contacts[0].cntPhnNo}" label="Phone No." required="true" />
		
	</div>
	<div data-tab="cnt2">
		<sjm:textfield id="name_1" name="entity.contacts[1].cntName"
			value="%{entity.contacts[1].cntName}" label="Name" required="true" />
		<sjm:textfield id="email_1" name="entity.contacts[1].cntEmail"
			value="%{entity.contacts[1].cntEmail}" label="Email" required="true" />
		<sjm:textfield id="isd_1" name="entity.contacts[1].cntIsdCde"
			value="%{entity.contacts[1].cntIsdCde}" label="Country Code" required="true" />
		<sjm:textfield id="areacode_1" name="entity.contacts[1].cntAreaCde"
			value="%{entity.contacts[1].cntAreaCde}" label="Area Code" />		
		<sjm:textfield id="phone_1" name="entity.contacts[1].cntPhnNo"
			value="%{entity.contacts[1].cntPhnNo}" label="Phone No." required="true" />
	</div>


</div>



