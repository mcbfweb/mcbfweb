<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>


<div data-role="inlinetabs">
	<ul>
		<li data-tab="add1">Address 1</li>
		<li data-tab="add2">Address 2</li>
	</ul>

	<div data-tab="add1">
		<%-- <sjm:textfield id="type_0" name="entity.addresses[0].adrTyp"
			value="%{entity.addresses[0].adrTyp}" label="Address Type"
			required="true" /> --%>
		<sjm:select id="type_0" name="entity.addresses[0].adrTyp"
			class="adrType" label="Address Type" headerKey="-1"
			headerValue="--Select a Type--" emptyOption="false"
			list="adrTypeArry" listKey="code" listValue="label" required="true" />

		<sjm:textfield id="streetNo_0" name="entity.addresses[0].adrStrtNo"
			value="%{entity.addresses[0].adrStrtNo}" label="Street No."
			required="true" />
		<sjm:textfield id="streetName_0" name="entity.addresses[0].adrstrNm"
			value="%{entity.addresses[0].adrstrNm}" label="Street Name"
			required="true" />
		<sjm:textfield id="addrLine1_0" name="entity.addresses[0].adrLine1"
			value="%{entity.addresses[0].adrLine1}" label="Address Line 1"
			required="true" />
		<sjm:textfield id="addrLine2_2" name="entity.addresses[0].adrLine2"
			value="%{entity.addresses[0].adrLine2}" label="Address Line 2"
			required="true" />

	</div>
	<div data-tab="add2">
		<sjm:select id="type_1" name="entity.addresses[1].adrTyp"
			class="adrType" label="Address Type" headerKey="-1"
			headerValue="--Select a Type--" emptyOption="false"
			list="adrTypeArry" listKey="code" listValue="label" required="true" />
		<sjm:textfield id="streetNo_1" name="entity.addresses[1].adrStrtNo"
			value="%{entity.addresses[1].adrStrtNo}" label="Street No." />
		<sjm:textfield id="streetName_1" name="entity.addresses[1].adrstrNm"
			value="%{entity.addresses[1].adrstrNm}" label="Street Name" />
		<sjm:textfield id="addrLine1_1" name="entity.addresses[1].adrLine1"
			value="%{entity.addresses[1].adrLine1}" label="Address Line 1" />
		<sjm:textfield id="addrLine2_2" name="entity.addresses[1].adrLine2"
			value="%{entity.addresses[1].adrLine2}" label="Address Line 2" />
	</div>


</div>

