<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>


<jsp:include page="/inc.header.jsp" />
<sjm:div role="page" id="searchBizpage" jquerytheme="redmond"
	data-theme="b" theme="simple">

	<sjm:div role="header">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Search</h1>
		<sjm:a href="#indexControl" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content">
		<s:form id="formSearchBizPage" action="../Main/SearchBiz"
			class="ui-filterable" method="post">
			<sjm:div role="fieldcontain">

				<sjm:select id="bizGroup" name="bizGroup" class="bizGroup"
						label="Group" headerKey="-1" headerValue="--Select a Group--"
						emptyOption="false" onchange="showChange(this[this.selectedIndex].value, this.id)"
						list="bizGroupArry" listKey="code" listValue="label" />

					<sjm:select id="bizType" name="bizType" class="bizType"
						label="Type" headerKey="-1" headerValue="--Select a Type--"
						emptyOption="false" list="bizTypeArry" listKey="code"
						listValue="label" />

				<input type="text" id="myinput">
				<br />
				<br />
				<ul id="autocomplete" data-role="listview" data-inset="true"
					data-autodividers="true" data-filter="true"
					data-filter-reveal="true"
					data-filter-placeholder="Find a Business	..." data-filter-theme="d"></ul>

			</sjm:div>
			<br />
			<br />
			<s:submit />

		</s:form>
	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>

</body>
</html>