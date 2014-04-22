<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>
<%@ page import="cl.model.*"%>
<%@ page import="java.util.List"%>

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
		<%-- <%
		List<EntityListDetail> clients  = (List<EntityListDetail>) request.getSession().getAttribute("clients");
			for (EntityListDetail e : clients) {
						if (e.getbName() != null && e.getbName().trim().length() > 0)
							System.out.println(e.getbName());
					}
		%> --%>


		<sjm:div>
			<s:form id="getClientListForm" method="post">

			  <ul data-role="listview" data-inset="true" data-split-icon="gear" data-autodividers="true"  data-filter="true">
					<s:iterator value="clients" id="clients">	
					  <s:if test="%{#clients.bizName != ''}">
					    <s:url action="../Main/getClient.action" var="urlTag" >
                           <s:param name="clientId"><s:property value="entity" /></s:param>
                           <s:param name="mode"><s:property value="maintain" /></s:param>
                         </s:url>
					
						    <li><s:a href="%{urlTag}"><s:property value="bizName" /></s:a></li>
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
