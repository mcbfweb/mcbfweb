<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>

<jsp:include page="/inc.header.jsp" />

<sjm:div role="page" id="maintUser" jquerytheme="cupertino"
	data-theme="b" theme="simple">
	<sjm:div role="header">
		<sjm:a button="true" buttonIcon="arrow-l" data-rel="back">Back</sjm:a>
		<h1>File upload</h1>
		<sjm:a href="#indexPage" button="true" buttonIcon="home">Back to Start</sjm:a>
	</sjm:div>
	<sjm:div role="content">
		<sjm:div>
			<s:form data-ajax="false" method="post" class="ui-grid-b">
				<table data-role="table" id="table-column-toggle"
					data-mode="columntoggle" class="ui-responsive table-stroke">
					<thead>
						<tr>
							<th data-priority="2">Product Name</th>
							<th>Description</th>
							<th data-priority="3">Details</th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>1</th>
							<td><a href="http://en.wikipedia.org/wiki/Citizen_Kane"
								data-rel="external">Citizen Kane</a></td>
							<td>1941</td>
							
						</tr>
						<tr>
							<th>2</th>
							<td><a href="http://en.wikipedia.org/wiki/Casablanca_(film)"
								data-rel="external">Casablanca</a></td>
							<td>1942</td>
							
						</tr>
						<tr>
							<th>3</th>
							<td><a href="http://en.wikipedia.org/wiki/The_Godfather"
								data-rel="external">The Godfather</a></td>
							<td>1972</td>
							
						</tr>
						<tr>
							<th>4</th>
							<td><a
								href="http://en.wikipedia.org/wiki/Gone_with_the_Wind_(film)"
								data-rel="external">Gone with the Wind</a></td>
							<td>1939</td>
							
						</tr>
						<tr>
							<th>5</th>
							<td><a
								href="http://en.wikipedia.org/wiki/Lawrence_of_Arabia_(film)"
								data-rel="external">Lawrence of Arabia</a></td>
							<td>1962</td>
							
						</tr>
						<tr>
							<th>6</th>
							<td><a href="http://en.wikipedia.org/wiki/Dr._Strangelove"
								data-rel="external">Dr. Strangelove Or How I Learned to Stop
									Worrying and Love the Bomb</a></td>
							<td>1964</td>
							
						</tr>
						<tr>
							<th>7</th>
							<td><a href="http://en.wikipedia.org/wiki/The_Graduate"
								data-rel="external">The Graduate</a></td>
							<td>1967</td>
							
						</tr>
						<tr>
							<th>8</th>
							<td><a
								href="http://en.wikipedia.org/wiki/The_Wizard_of_Oz_(1939_film)"
								data-rel="external">The Wizard of Oz</a></td>
							<td>1939</td>
							
						</tr>
						<tr>
							<th>9</th>
							<td><a
								href="http://en.wikipedia.org/wiki/Singin%27_in_the_Rain"
								data-rel="external">Singin' in the Rain</a></td>
							<td>1952</td>
							
						</tr>
						<tr>
							<th>10</th>
							<td class="title"><a
								href="http://en.wikipedia.org/wiki/Inception"
								data-rel="external">Inception</a></td>
							<td>2010</td>
							
						</tr>
					</tbody>
				</table>
			</s:form>
		</sjm:div>
	</sjm:div>
</sjm:div>
</body>

</html>