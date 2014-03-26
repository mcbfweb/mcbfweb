<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>

	<%
		//boolean inValidSession = false;

		if (session.getAttribute("application") != null
				|| session.getAttribute("partner") != null
				|| session.getAttribute("respondXML") != null) {
			System.out.println("index.jsp - old session was invalidated");
			session.invalidate();
			session = request.getSession();
			//inValidSession = true;			
		}

		//session.setAttribute("inValidSession", inValidSession);
		session.setAttribute("application",
				request.getParameter("application"));
		session.setAttribute("partner", request.getParameter("partner"));
	%>


	<div id="indexControl">
		<s:action name="Index" namespace="/User" executeResult="true"/>
	</div>

</body>
</html>