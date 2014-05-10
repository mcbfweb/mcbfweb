<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>



<div role="main" class="ui-content">
	<div data-role="tabs">
		<div data-role="navbar">
			<ul>
				<li><a href="#id1">Id 1</a></li>
				<li><a href="#id2">Id 2</a></li>
			</ul>
		</div>

		<div id="id1">
			<sjm:select id="idtype_0" name="entity.ids[0].idTyp" class="bizIDTyp"
				label="ID Type" headerKey="-1" headerValue="--Select a ID Type--"
				emptyOption="false" list="bizIDTypeArry" listKey="code"
				listValue="label" />

			<sjm:textfield id="idnumber_0" name="entity.ids[0].idCode"
				value="%{entity.ids[0].idCode}" label="ID Number" />


		</div>
		<div id="id2">
			<sjm:select id="idtype_1" name="entity.ids[1].idTyp" class="bizIDTyp"
				label="ID Type" headerKey="-1" headerValue="--Select a ID Type--"
				emptyOption="false" list="bizIDTypeArry" listKey="code"
				listValue="label" />

			<sjm:textfield id="idnumber_1" name="entity.ids[1].idCode"
				value="%{entity.ids[1].idCode}" label="ID Number" />


		</div>


	</div>
</div>