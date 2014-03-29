<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />
<script>
$(function() {
var tt = <%=(String) session.getServletContext().getAttribute("application")%>
alert(tt+ "Done this....");
});
</script>
<sjm:div role="page" id="loginpage" jquerytheme="redmond" data-theme="b" theme="simple">
	<sjm:div role="header" jquerytheme="redmond" data-theme="b">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Login</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content">
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>

		<s:form method="post">
			
				<sjm:textfield id="username" name="username" label="Username"
					required="true" class="forceinline"/>
				<sjm:password id="password" name="password" label="Password"
					required="true" class="forceinline"/>
				<s:token />
				<s:submit id="submitBtn" value="Login" align="center"/>

		</s:form>



	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>


</body>
</html>