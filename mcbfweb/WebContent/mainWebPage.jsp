<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />
<sjm:div role="page" id="searchBizMenu" data-theme="d" theme="simple"
	data-position="inline">

	<sjm:div role="header" data-theme="d">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Main Menu</h1>
		<sjm:a href="#indexControl" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content" data-theme="d">
		<ul data-role="listview" data-inset="true" data-theme="d"
			data-divider-theme="d">
			<li data-role="list-divider">Internal User Menu</li>
			<li><a href="./index.jsp">Login</a></li>
			<li><a href="../pages/dialog.html" data-rel="dialog">Dialog
					link: data-rel="dialog" (not tracked in history)</a></li>
			<li data-role="list-divider">External User Menu</li>
			<li><a href="./Main/SearchBiz">MyCity Business Search</a></li>
			<li><a href="http://www.jquery.com">MyCity Business Finder
					Website</a></li>
			<li><a href="./Main/SearchBiz data-rel="dialog">Make a
					booking - Popup</a></li>
			
			<li data-role="list-divider">Email links</li>
			<li><a href="mailto:jdoe@foo.com">Basic email:
					mailto:jdoe@foo.com</a></li>
			<li><a
				href="mailto:jdoe@foo.com?cc=bill@bar.com&bcc=mark@abc.com&subject=Happy%20Birthday&body=Best%20wishes!">Mailto
					with a cc:, bcc:, subject and body pre-filled</a></li>

			<li data-role="list-divider">Phone links</li>
			<li><a href="tel:15555555555">Phone: tel:83143414</a></li>
			<li data-role="list-divider">Other</li>
			<li><a href="#">A href="#" will return false</a></li>
		</ul>

	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>

</body>