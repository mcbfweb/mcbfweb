<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />
<s:url id="remoteurl" action="../Main/populateBizTypeArry.action" />
<sjm:div role="page" id="uploadFile" data-theme="d" theme="simple">
	<sjm:div role="header">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Add Client</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content">
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>


		<h1>Bureau File Upload - 10K max</h1>
		<center>
			<s:form id="fileupload" action="uploadFile" namespace="/" method="POST" enctype="multipart/form-data">

				<s:file name="fileUpload" label="Select a file to upload" size="30" />
				<br />
				<s:submit value="Upload" />

			</s:form>
		</center>
		<h1>File Upload with Struts 2</h1>
		

	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>


</body>
</html>