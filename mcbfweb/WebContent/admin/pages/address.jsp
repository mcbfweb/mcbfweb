<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>


<div data-role="inlinetabs">
	<ul>
		<li data-tab="add1">Address 1</li>
		<li data-tab="add2">Address 2</li>
	</ul>

	<div data-tab="add1">
		<sjm:textfield id="type_0" name="entAdrs[0].addtype"
			value="%{entAdrs[0].addtype}" label="Address Type"
			required="true" />
		<sjm:textfield id="streetNo_0" name="entAdrs[0].streetNo"
			value="%{entAdrs[0].streetNo]" label="Street No."
			required="true" />
		<sjm:textfield id="streetName_0" name="entAdrs[0].streetName"
			value="%{entAdrs[0].streetName}" label="Street Name"
			required="true" />
		<sjm:textfield id="addrLine1_0" name="entAdrs[0].addrLine1"
			value="%{entAdrs[0].addrLine1}" label="Address Line 1"
			required="true" />
		<sjm:textfield id="addrLine2_2" name="entAdrs[0].addrLine2"
			value="%{entAdrs[0].addrLine2}" label="Address Line 2"
			required="true" />

	</div>
	<div data-tab="add2">
		<sjm:textfield id="type_1" name="entAdrs[1].addtype"
			value="%{entAdrs[1].addtype}" label="Address Type" />
		<sjm:textfield id="streetNo_1" name="entAdrs[1].streetNo"
			value="%{entAdrs[1].streetNo}" label="Street No." />
		<sjm:textfield id="streetName_1" name="entAdrs[1].streetName"
			value="%{entAdrs[1].streetName}" label="Street Name" />
		<sjm:textfield id="addrLine1_1" name="entAdrs[1].addrLine1"
			value="%{entAdrs[1].addrLine1}" label="Address Line 1" />
		<sjm:textfield id="addrLine2_2" name="entAdrs[1].addrLine2"
			value="%{entAdrs[1].addrLine2}" label="Address Line 2" />
	</div>


</div>

