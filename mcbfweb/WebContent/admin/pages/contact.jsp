<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>


<sjm:div role="main" class="ui-content">
	<sjm:div data-role="collapsible-set" data-type="tabs" data-tabs="2"
		data-theme="d" data-content-theme="d">

		<sjm:div data-role="collapsible" data-collapsed="false" data-mini="true">

			<h4>Contact 1</h4>

			<sjm:div id="cnt1">
				<sjm:textfield id="extention_0" name="entity.contacts[0].cntName"
					value="%{entity.contacts[0].cntName}" label="Name" />
				<sjm:textfield id="email_0" name="entity.contacts[0].cntEmail"
					value="%{entity.contacts[0].cntEmail}" label="Email" />


				<sjm:select id="isd_0" name="entity.contacts[0].cntIsdCde"
					class="ISDCde" label="Country Code" headerKey="-1"
					headerValue="--Select a Country Code--" emptyOption="false"
					list="ISDCdeArry" listKey="code" listValue="label" />

				<sjm:textfield id="areacode_0" name="entity.contacts[0].cntAreaCde"
					value="%{entity.contacts[0].cntAreaCde}" label="Area Code" />
				<sjm:textfield id="phone_0" name="entity.contacts[0].cntPhnNo"
					value="%{entity.contacts[0].cntPhnNo}" label="Phone No." />

			</sjm:div>
		</sjm:div>
		
		<sjm:div data-role="collapsible" data-collapsed="true" data-mini="true">

			<h4>Contact 2</h4>

			<sjm:div id="cnt2">
				<sjm:textfield id="name_1" name="entity.contacts[1].cntName"
					value="%{entity.contacts[1].cntName}" label="Name" />
				<sjm:textfield id="email_1" name="entity.contacts[1].cntEmail"
					value="%{entity.contacts[1].cntEmail}" label="Email" />
				<sjm:textfield id="isd_1" name="entity.contacts[1].cntIsdCde"
					value="%{entity.contacts[1].cntIsdCde}" label="Country Code" />
				<sjm:textfield id="areacode_1" name="entity.contacts[1].cntAreaCde"
					value="%{entity.contacts[1].cntAreaCde}" label="Area Code" />
				<sjm:textfield id="phone_1" name="entity.contacts[1].cntPhnNo"
					value="%{entity.contacts[1].cntPhnNo}" label="Phone No." />
			</sjm:div>
		</sjm:div>

	</sjm:div>
</sjm:div>