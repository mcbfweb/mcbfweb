<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>



<jsp:include page="/inc.header.jsp" />

<sjm:div role="page" id="searchBizpage" data-theme="d" theme="simple"
	data-dom-cache="true">

	<sjm:div role="header" data-theme="d">
		<sjm:a href="#searchBizMenu" button="true" buttonIcon="arrow-l"
			data-rel="back">Back</sjm:a>
		<h1>Search</h1>
		<sjm:a href="#searchBizMenu" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content" data-theme="d">

		<sjm:div>
			<s:form id="formSearchBizPage" action="../Main/SearchBiz"
				class="ui-filterable" method="post">

				<sjm:select id="bizType" name="bizType" class="bizType" label="Type"
					headerKey="-1" headerValue="--Select a Type--" emptyOption="false"
					onchange="filterByType(this[this.selectedIndex].value, this.id)"
					list="bizTypeArry" listKey="code" listValue="label" />

				<br />

				<form class="ui-filterable">
					<input id="filterUsersInput" data-type="search">
				</form>

				<ul id="filterList" data-role="listview" data-inset="true"
					data-input="#filterUsersInput" data-split-icon="gear"
					data-autodividers="true" data-filter="true">


				</ul>
			</s:form>
		</sjm:div>



	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>

</body>
</html>