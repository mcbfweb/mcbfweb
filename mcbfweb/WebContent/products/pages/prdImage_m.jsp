<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />

<sjm:div role="page" id="productUpload" data-theme="d" theme="simple"	data-position="inline">
	<sjm:div role="header" data-theme="d">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Product upload</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content">
        <s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>
		<sjm:div>
			<s:form data-ajax="false" id= "productUpload" action="productUpload" namespace="/Main" method="post" enctype="multipart/form-data">
				<s:file name="fileUpload" label="File" />
				<s:submit />
			</s:form>
		</sjm:div>
	</sjm:div>
</sjm:div>
</body>

</html>