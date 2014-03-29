<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>


<sjm:div>
	<sjm:div data-role="tabs" id="tabs">
		<sjm:div data-role="navbar">
			<ul>
				<li><a href="#Id1" data-ajax="false">ID 1</a></li>
				<li><a href="#Id2" data-ajax="false">ID 2</a></li>
				
			</ul>
		</sjm:div>
		<s:iterator value="%{entity.Ids}" var="Id" id="eid" status="idx">

			<sjm:div id='Id%{#idx.count}'>
				<ul data-role="listview" data-inset="false">
					<li><sjm:textfield id="email%{#idx.index}"
							name="entity.Ids[%{#idx.index}].email" label="Email"
							required="true" /></li>
					<li><sjm:textfield id="isd%{#idx.index}"
							name="entity.Ids[%{#idx.index}].isd" label="Country Code"
							required="true" /></li>
					<li><sjm:textfield id="areacode%{#idx.index}"
							name="entity.Ids[%{#idx.index}].areacode" label="Area Code" /></li>
					<li><sjm:textfield id="phone%{#idx.index}"
							name="entity.Ids[%{#idx.index}].phone" label="Phone No."
							required="true" /></li>
					<li><sjm:textfield id="extention%{#idx.index}"
							name="entity.Ids[%{#idx.index}].extention" label="Extention"
							required="true" /></li>
				</ul>
			</sjm:div>

		</s:iterator>



	</sjm:div>
</sjm:div>





