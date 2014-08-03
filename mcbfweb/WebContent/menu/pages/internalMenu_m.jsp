<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />

<sjm:div role="page" id="internalMenuPage"  data-theme="d" theme="simple">
	<sjm:div role="header">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Menu</h1>
		<sjm:a href="#indexControl" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content">

		<sjm:div role="content">
			<form action="../User/Menu" method="post">
				<sjm:div role="fieldcontain">
					<fieldset>
						<sjm:radio id="menuItem" name="menuItem" label="Main Menu"
							list="{'Upload Data ', 'Load Image', 'Add Client', 'Maintain Client', 'Maintain User', 'Products'}" />
					</fieldset>
				</sjm:div>
				<s:submit />
			</form>
		</sjm:div>
	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>

</body>
</html>