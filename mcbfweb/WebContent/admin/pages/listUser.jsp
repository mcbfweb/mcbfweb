<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>


<jsp:include page="/inc.header.jsp" />
<s:url id="remoteurl" action="../Main/populateBizTypeArry.action" />
<sjm:div role="page" id="maintUser" jquerytheme="cupertino"
	data-theme="b" theme="simple">
	<sjm:div role="header">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Select Client</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content">
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>

		<sjm:div>
			<s:form id="getUserListForm" method="post">

				<ul data-role="listview" data-inset="true" data-split-icon="gear" data-autodividers="true"  data-filter="true">
					<s:iterator value="users" id="users">	
					  <s:if test="%{#users.getUserName() != ''}">
					    <s:url action="../User/getUser.action" var="urlTag" >
                           <s:param name="usrid"><s:property value="userID" /></s:param>
                           <s:param name="client"><s:property value="client" /></s:param>
                           <s:param name="mode"><s:property value="maintain" /></s:param>
                         </s:url>
					
						    <li><s:a href="%{urlTag}"><s:property value="userName" /></s:a></li>
						</s:if>	 
						</s:iterator>
					</ul>
		 
			</s:form>
		</sjm:div>


	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>


</body>
</html>
