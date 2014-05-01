<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>


<div data-role="inlinetabs" data-content-theme="c" data-mini="true">
	<ul>
		<li data-tab="add1">Address 1</li>
		<li data-tab="add2">Address 2</li>
	</ul>


	<div data-tab="add1">
		
		<sjm:select id="type_0" name="entity.addresses[0].adrTyp"
			class="adrType" label="Address Type" headerKey="-1"
			headerValue="--Select a Type--" emptyOption="false"
			list="adrTypeArry" listKey="code" listValue="label" />

		<sjm:textfield id="streetNo_0" name="entity.addresses[0].adrStrtNo"
			value="%{entity.addresses[0].adrStrtNo}" label="Street No." />
		<sjm:textfield id="streetName_0" name="entity.addresses[0].adrstrNm"
			value="%{entity.addresses[0].adrstrNm}" label="Street Name" />
		<sjm:textfield id="addrLine1_0" name="entity.addresses[0].adrLine1"
			value="%{entity.addresses[0].adrLine1}" label="Address Line 1" />
		<sjm:textfield id="adrPstCde_0" name="entity.addresses[0].adrPstCde"
			value="%{entity.addresses[0].adrPstCde}" label="Post Code" />

		<sjm:select id="adrCity_0" name="entity.addresses[0].adrCity"
			class="adrCity" label="City" headerKey="-1"
			headerValue="--Select a City--" emptyOption="false"
			list="adrCityArry" listKey="code" listValue="label" />

		<sjm:select id="adrState_0" name="entity.addresses[0].adrState"
			class="adrState" label="State/Province" headerKey="-1"
			headerValue="--Select a State--" emptyOption="false"
			list="adrStateArry" listKey="code" listValue="label" />

		<sjm:select id="adrCtry_0" name="entity.addresses[0].adrCtry"
			class="adrCtry" label="Country"  headerKey="CAN"
			headerValue="--Select a Country--" emptyOption="false"
			list="adrCountryArry" listKey="code" listValue="label" />

	</div>
	<div data-tab="add2">
		<sjm:select id="type_1" name="entity.addresses[1].adrTyp"
			class="adrType" label="Address Type" headerKey="-1"
			headerValue="--Select a Type--" emptyOption="false"
			list="adrTypeArry" listKey="code" listValue="label" />
			
		<sjm:textfield id="streetNo_1" name="entity.addresses[1].adrStrtNo"
			value="%{entity.addresses[1].adrStrtNo}" label="Street No." />
		<sjm:textfield id="streetName_1" name="entity.addresses[1].adrstrNm"
			value="%{entity.addresses[1].adrstrNm}" label="Street Name" />
		<sjm:textfield id="addrLine1_1" name="entity.addresses[1].adrLine1"
			value="%{entity.addresses[1].adrLine1}" label="Address Line 1" />
		<sjm:textfield id="adrPstCde_1" name="entity.addresses[1].adrPstCde"
			value="%{entity.addresses[1].adrPstCde}" label="Post Code" />
			
		<sjm:select id="adrCity_1" name="entity.addresses[1].adrCity"
			class="adrCity" label="City" headerKey="-1"
			headerValue="--Select a City--" emptyOption="false"
			list="adrCityArry" listKey="code" listValue="label" />

		<sjm:select id="adrState_1" name="entity.addresses[1].adrState"
			class="adrState" label="State/Province" headerKey="-1"
			headerValue="--Select a State--" emptyOption="false"
			list="adrStateArry" listKey="code" listValue="label" />

		<sjm:select id="adrCtry_1" name="entity.addresses[1].adrCtry"
			class="adrCtry" label="Country" headerKey="CAN"
			headerValue="--Select a Country--" emptyOption="false"
			list="adrCountryArry" listKey="code" listValue="label" />
	</div>


</div>

