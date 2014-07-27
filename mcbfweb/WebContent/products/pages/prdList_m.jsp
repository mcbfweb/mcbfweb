<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />

<sjm:div role="page" id="productSearch" data-theme="d" theme="simple"
	data-dom-cache="true">

	<sjm:div role="header" data-theme="d">
		<sjm:a href="#" button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>Product List</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>

	<sjm:div role="content" data-theme="d">
		<sjm:div>
			<s:form method="post">
				<s:hidden name="clientId" value="%{entity.entity}" />

				<s:set var="urlTag"
					value="%{'../Main/findProductById.action?mode=view&clientId=#clientId'}"></s:set>
				<s:set var="prdTag" value="%{'&prdId='}"></s:set>

				<ul data-role="listview" data-inset="true" data-theme="c"
					data-mini="true">

					<s:iterator value="%{entity.products}" var="product" id="prd"	status="idx">

						<li>Product Code - <s:property value="prdCode" />

							<div data-role="fieldcontain" class='forceinline'>
								<div class='floatleft closespacing'>
									<input type="checkbox" name="<s:property value="prdCode" />"
										id="<s:property value="prdCode" />" /> <label
										for="<s:property value="prdCode" />"> <s:property
											value="prdDesc" /></label>
								</div>
								<div class='floatright '>
									Price:
									<s:property value="prdPrice" />
								</div>
							</div>

							<div class='floatleft closespacing'>
								<label for="quantity_<s:property value="prdCode" />">Quantity:</label>
							</div>

							<div class='textwidth80  floatright'>
								<input type="number" name="quantity"
									id="quantity_<s:property value="prdCode" />" value="" />
							</div>
						</li>
					</s:iterator>


				</ul>

				<a href="../Main/ProductSelected.action?mode=view&clientId='' "
					class='ui-btn'>Checkout</a>

			</s:form>
		</sjm:div>
	</sjm:div>
</sjm:div>
</body>

</html>