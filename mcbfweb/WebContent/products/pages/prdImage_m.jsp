<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />
<script>
	$(document).on('mobileinit', function() {
		$.mobile.ignoreContentEnabled = true;
	});
</script>
<sjm:div role="page" id="maintUser" jquerytheme="cupertino"
	data-theme="b" theme="simple">
	<sjm:div role="header">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>File upload</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content">

		<sjm:div>
			<s:form data-ajax="false" method="post" enctype="multipart/form-data">
				<s:file name="fileUpload" label="File" />
				<s:submit />
			</s:form>
		</sjm:div>
	</sjm:div>
</sjm:div>
</body>

</html>