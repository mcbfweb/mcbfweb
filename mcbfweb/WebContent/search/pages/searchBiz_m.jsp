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

				<sjm:select id="bizType" name="bizType" class="bizType" label="Type"
					headerKey="-1" headerValue="--Select a Type--" emptyOption="false"
					onchange="filterByType(this[this.selectedIndex].value, this.id)"
					list="bizTypeArry" listKey="code" listValue="label" />

				<br />
				<form>
					<input type="text" data-type="search" id="filterable-input">
				</form>
				<form data-role="controlgroup" data-filter-reveal="true"
					data-filter="true" data-input="#filterable-input">

					<s:iterator value="filterList" id="filterList">
						<s:if test="%{#filterList.bizName != ''}">
							<s:url action="../Main/findBizByType.action" var="urlTag">
								<s:param name="clientId">
									<s:property value="entity" />
								</s:param>
								<s:param name="mode">
									<s:property value="view" />
								</s:param>
							</s:url>

							<li><s:a href="%{urlTag}">
									<s:property value="bizName" />
								</s:a></li>
						</s:if>
					</s:iterator>
					
				</form>

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