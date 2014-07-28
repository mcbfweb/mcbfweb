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

				<ul data-role="listview" data-split-icon="gear" data-split-theme="d"
					data-inset="true">

					<s:iterator value="%{entity.products}" var="product" id="prd"
						status="idx">


						<li><a href="#"> <img src="../products/images/1_Pen.png">
								<h2>
									<s:property value="prdDesc" />
								</h2>

								<p>
									Item # -
									<s:property value="prdCode" />
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Price -
									<s:property value="prdPrice" />

								</p>



						</a> <a href="#purchase_<s:property value="prdCode" />"
							data-rel="popup" data-position-to="window" data-transition="pop">Image</a></li>
							
						<%-- <input type="number"
							class='textwidth80  floatright forceinline miniinputheight'
							name="quantity" id="<s:property value="prdCode" />" /> --%>


					</s:iterator>


				</ul>
				<s:iterator value="%{entity.products}" var="product" id="prd"
					status="idx">
					<div data-role="popup" id="purchase_<s:property value="prdCode" />"
						data-theme="a" data-overlay-theme="b" class="ui-content"
						style="max-width: 340px; padding-bottom: 2em;">
						<h3>
							<s:property value="prdDesc" />
						</h3>
						<p>Your download will begin immediately on your mobile device
							when you purchase.</p>
						<a href="index.html" data-rel="back"
							class="ui-shadow ui-btn ui-corner-all ui-btn-b ui-icon-check ui-btn-icon-left ui-btn-inline ui-mini">Buy:
							$<s:property value="prdPrice" />
						</a> <a href="index.html" data-rel="back"
							class="ui-shadow ui-btn ui-corner-all ui-btn-inline ui-mini">Cancel</a>
					</div>
				</s:iterator>

				<a href="../Main/ProductSelected.action?mode=view&clientId='' "
					class='ui-btn'>Checkout</a>
			</s:form>
		</sjm:div>
	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>
</body>

</html>