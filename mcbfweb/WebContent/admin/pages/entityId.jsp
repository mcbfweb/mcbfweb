<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>



<sjm:div role="main" class="ui-content">
	<sjm:div data-role="collapsible-set" data-type="tabs" data-tabs="2"
		data-theme="d" data-content-theme="d">

		<sjm:div data-role="collapsible" data-collapsed="false" data-mini="true">
			<h4>Id1</h4>
			<sjm:div id="id1">
				<sjm:select id="idtype_0" name="entity.ids[0].idTyp"
					class="bizIDTyp" label="ID Type" headerKey="-1"
					headerValue="--Select a ID Type--" emptyOption="false"
					list="bizIDTypeArry" listKey="code" listValue="label" />

				<sjm:textfield id="idnumber_0" name="entity.ids[0].idCode"
					value="%{entity.ids[0].idCode}" label="ID Number" />

			</sjm:div>
		</sjm:div>

		<sjm:div data-role="collapsible" data-collapsed="true" data-mini="true">
			<h4>Id2</h4>
			<sjm:div id="id2">
				<sjm:select id="idtype_1" name="entity.ids[1].idTyp"
					class="bizIDTyp" label="ID Type" headerKey="-1"
					headerValue="--Select a ID Type--" emptyOption="false"
					list="bizIDTypeArry" listKey="code" listValue="label" />

				<sjm:textfield id="idnumber_1" name="entity.ids[1].idCode"
					value="%{entity.ids[1].idCode}" label="ID Number" />
		</sjm:div>
	</sjm:div>

</sjm:div>
</sjm:div>