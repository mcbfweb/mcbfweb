<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>



<div data-role="inlinetabs">
	<ul>
		<li data-tab="id1">Id 1</li>
		<li data-tab="id2">Id 2</li>
	</ul>

	<div data-tab="id1">
		<sjm:textfield id="idtype_0" name="entity.ids[0].idTyp"
			value="%{entity.ids[0].idTyp}" label="ID Type" required="true" />
		<sjm:textfield id="idnumber_0" name="entity.ids[0].idCode"
			value="%{entity.ids[0].idCode}" label="ID Number" required="true" />
	</div>
	<div data-tab="id2">
		<sjm:textfield id="idtype_1" name="entIds[1].idTyp"
			value="%{entIds[1].idTyp}" label="ID Type" />
		<sjm:textfield id="idnumber_1" name="entIds[1].idCode"
			value="%{entIds[1].idCode}" label="ID Number" />
	</div>


</div>
