<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />


<sjm:div role="page" id="maintUser" jquerytheme="cupertino"
	data-theme="b" theme="simple">
	<sjm:div role="header">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Product List</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>

	<sjm:div role="content">
		<s:form method="post">
			<ul data-role="listview" data-inset="true" data-split-icon="gear">
				<s:iterator value="images" id="products">
					<li><a href="<s:url action="../Main/Product"/>"> <img
							src=<s:property value="imagePath" /> class="ui-li-icon"> <s:property
								value="title" />
					</a> <a href="<s:url action="../Main/Product"/>">Delete</a></li>
					<li>
				</s:iterator>
			</ul>
		</s:form>
	</sjm:div>


	<jsp:include page="/inc.footer.jsp" />
</sjm:div>

</body>
</html>


