<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />

<sjm:div role="page" id="loginpage" data-theme="d" theme="simple"
	data-position="inline">
	<sjm:div role="header" data-theme="d">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Login</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content" data-theme="d">
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>

		<s:form method="post">

			<sjm:textfield id="username" name="username" label="Username"
				required="true" class="forceinline" />
			<sjm:password id="password" name="password" label="Password"
				required="true" class="forceinline" />
			<s:token />
			<s:submit id="submitBtn" value="Login" align="center" />

		</s:form>



	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>


</body>
</html>