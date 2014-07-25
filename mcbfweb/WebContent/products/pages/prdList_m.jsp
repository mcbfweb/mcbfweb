<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />

<sjm:div role="page" id="productSearch" jquerytheme="cupertino"
	data-theme="b" theme="simple">
	<sjm:div role="header">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Products</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content">
		<sjm:div>
			<s:form data-ajax="false" method="post" class="ui-grid-b">
				<s:hidden name="clientId" value="%{entity.entity}" />

				<%-- <s:set var="urlTag"
					value="%{'../Main/findProductById.action?mode=view&clientId='}"></s:set>
				<s:set var="prdTag" value="%{'&prdId='}"></s:set> --%>

				<ul data-role="listview" data-split-icon="gear" data-split-theme="d"
					data-inset="true">
					<%-- <s:iterator value="%{entity.products}" var="product" id="prd"
						status="idx"> --%>

						<li>
							<%-- <a href=<s:property value="#urlTag" />
							<s:property value="entity" /> <s:property value="#prdTag" />
							<s:property value="prdCode" />> <img
								src=<s:property value="imagePath" /> class="ui-li-icon"> <s:property
									value="title" /> --%>
							<h2>
								<s:property value="prdDesc" />
							</h2>
							<p>
								Price:
								<s:property value="prdPrice" />
							</p> <!-- </a> <a href="#purchase" data-rel="popup" data-position-to="window"
							data-transition="pop">Purchase album</a> -->

						</li>
						<%-- </s:iterator> --%>
				</ul>
				


			</s:form>
		</sjm:div>
	</sjm:div>
</sjm:div>
</body>

</html>