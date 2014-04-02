<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>


<div data-role="inlinetabs">
	<ul>
		<li data-tab="cnt1">Contact 1</li>
		<li data-tab="cnt2">Contact 2</li>
	</ul>

	<div data-tab="cnt1">
		<sjm:textfield id="email_0" name="entCnts[0].email"
			value="%{entCnts[0].email}" label="Email" required="true" />
		<sjm:textfield id="isd_0" name="entCnts[0].isd"
			value="%{entCnts[0].isd}" label="Country Code" required="true" />
		<sjm:textfield id="areacode_0" name="entCnts[0].areacode"
			value="%{entCnts[0].areacode}" label="Area Code" />		
		<sjm:textfield id="phone_0" name="entCnts[0].phone"
			value="%{entCnts[0].phone}" label="Phone No." required="true" />
		<sjm:textfield id="extention_0" name="entCnts[0].extention"
			value="%{entCnts[0].extention}" label="Extention" required="true" />
	</div>
	<div data-tab="cnt2">
		<sjm:textfield id="email_1" name="entCnts[1].email"
			value="%{entCnts[1].email}" label="Email"  />
		<sjm:textfield id="isd_1" name="entCnts[1].isd"
			value="%{entCnts[1].isd}" label="Country Code"  />
		<sjm:textfield id="areacode_1" name="entCnts[1].areacode"
			value="%{entCnts[1].areacode}" label="Area Code" />		
		<sjm:textfield id="phone_1" name="entCnts[1].phone"
			value="%{entCnts[1].phone}" label="Phone No."  />
		<sjm:textfield id="extention_1" name="entCnts[1].extention"
			value="%{entCnts[1].extention}" label="Extention"  />
	</div>


</div>



