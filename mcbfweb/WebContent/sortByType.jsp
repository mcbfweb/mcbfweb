<%@ page import="cl.model.EntityListDetail"%>
<%@ page import="cl.mainStream.BSTables"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%
	//List<EntityListDetail> clients = (List<EntityListDetail>) session.getServletContext().getAttribute("ENTITY_DETAIL_LIST");
	String bizType = request.getParameter("bizType").trim();
	String SEL_CITY = (String) session.getAttribute("SELECTED_CITY");
	SEL_CITY = SEL_CITY.concat("_").concat(bizType).concat("_CLIENT_LIST");
	List<EntityListDetail> clients = (List<EntityListDetail>) session.getServletContext().getAttribute(SEL_CITY);

	String urlTag = "../Main/findBizByName.action?mode=view&clientId=";
	String buffer = "";
	try {

		if (clients != null) {
			for (EntityListDetail option : clients) {
				if (option != null && option.getBizCode().trim().equalsIgnoreCase(bizType)) {
					String clientId = new Integer(option.getEntity()).toString();

					String bizName = option.getBizName();

					buffer = buffer + "<li><a href='" + urlTag + clientId + "'>" + bizName + "</a></li>";
				}
			}
		}
		else
			buffer = "<li>- No Business Found -</li>";
		response.getWriter().println(buffer);
	} catch (Exception e) {
		System.out.println(e);
	}
%>




