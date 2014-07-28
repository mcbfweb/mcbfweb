
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>


<jsp:include page="/inc.header.jsp" />


<sjm:div role="page" id="productSelectedPage" data-theme="d" theme="simple">

	<sjm:div role="header" data-theme="d">

		<sjm:a href="#" button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>

		<h1>Product Selected</h1>

		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>

	</sjm:div>

	<sjm:div role="content" data-theme="d">

		<s:if test="hasActionErrors()">

			<div class="errors">

				<s:actionerror />

			</div>

		</s:if>
		<s:form method="post">
			<s:hidden name="clientId" />

			
		</s:form>
	</sjm:div>


	<jsp:include page="/inc.footer.jsp" />

</sjm:div>





</body>

</html>

