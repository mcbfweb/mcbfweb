<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />

<sjm:div role="page" id="productSearch" data-theme="d" theme="simple">

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

				<h2>Product List</h2>

				<ul id="product-list" data-role="listview" data-theme="d"
					data-inset="true">

					<s:iterator value="%{entity.products}" var="product" id="prd"
						status="idx">

						<li><a href="#purchase_<s:property value="prdCode" />"
							data-rel="popup" data-position-to="window" data-transition="pop">


								<s:iterator value="%{prdImages}" var="img" id="img"
									status="idx2">

									<s:if test="%{datid == prdId}">

										<img src="<s:property value="imagePath" />"
											alt="<s:property value="prdCode" />" />

									</s:if>
								</s:iterator>
								<h2>
									Name - &nbsp;
									<s:property value="prdDesc" />
								</h2>
								<h4>
									Code - &nbsp;
									<s:property value="prdCode" />
								</h4>

								<p>
									Price - &nbsp; <span class="inline"><s:property
											value="prdPrice" /></span>
								</p>

						</a></li>




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

				<div>
					<a data-role="button" data-mini="true"
						href="../Main/ProductSelected.action?mode=view&clientId='' "
						data-position-to="window" data-transition="fade" data-theme="c"
						class='ui-btn ui-corner-all ui-shadow ui-btn-inline'>Checkout</a>
				</div>
			</s:form>
		</sjm:div>
	</sjm:div>
	<jsp:include page="/inc.footer.jsp" />
</sjm:div>
</body>

</html>