<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />
<s:url id="remoteurl" action="../Main/populateBizTypeArry.action" />

<%-- <sjm:div data-role="collapsible-set"  data-type="tabs"	data-tabs="2" data-theme="e" data-content-theme="e">
	<sjm:div>
		<h4>Id1</h4>
		<p>enter1</p>
		<sjm:textfield id="idtype0" name="entity.Ids[0].idTyp"
			value="%{entity.Ids[0].idTyp}" label="ID Type" required="true" />
		<sjm:textfield id="idnumber0" name="entity.Ids[0].idCode"
			value="%{entity.Ids[0].idCode}" label="ID Number" required="true" />
	</sjm:div>
	<sjm:div>
		<h4>Id2</h4>
		<p>enter2</p>
		<sjm:textfield id="idtype1" name="entity.Ids[1].idTyp"
			value="%{entity.Ids[1].idTyp}" label="ID Type" required="true" />
		<sjm:textfield id="idnumber1" name="entity.Ids[1].idCode"
			value="%{entity.Ids[1].idCode}" label="ID Number" required="true" />
	</sjm:div>

</sjm:div> --%>

<body>
	<div data-role="page">

		<div data-role="header">
			<h1>My Title</h1>
		</div>
		<!-- /header -->

		<div data-role="inlinetabs">
			<ul>
				<li data-tab="1">First tab</li>
				<li data-tab="2">Second tab</li>
			</ul>

			<div data-tab="1">
				<h4>Id1</h4>
				<p>enter1</p>
				<sjm:textfield id="idtype0" name="entity.Ids[0].idTyp"
					value="%{entity.Ids[0].idTyp}" label="ID Type" required="true" />
				<sjm:textfield id="idnumber0" name="entity.Ids[0].idCode"
					value="%{entity.Ids[0].idCode}" label="ID Number" required="true" />
			</div>

			<div data-tab="2">
				<h4>Id2</h4>
				<p>enter2</p>
				<sjm:textfield id="idtype1" name="entity.Ids[1].idTyp"
					value="%{entity.Ids[1].idTyp}" label="ID Type" required="true" />
				<sjm:textfield id="idnumber1" name="entity.Ids[1].idCode"
					value="%{entity.Ids[1].idCode}" label="ID Number" required="true" />
			</div>
		</div>
	</div>
	<!-- /page -->