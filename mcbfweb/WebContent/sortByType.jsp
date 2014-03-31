<%@ page import="cl.model.EntityDetail"%>
<%@ page import="cl.mainStream.BSTables"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%
	List<EntityDetail> clients = (List<EntityDetail>) session.getServletContext().getAttribute("ENTITY_DETAIL_LIST");
	
	String bizType = request.getParameter("bizType").trim();

	try {
		String code = "";
		String desc = "";
			List<EntityDetail> filterList = new ArrayList<EntityDetail>();
		for (EntityDetail option : clients) {
			if (option != null && option.getType() != null && option.getBizCode().trim().equalsIgnoreCase(bizType))
				filterList.add(option);
		}
    
		request.setAttribute("filter_list", filterList);
		
	} catch (Exception e) {
		System.out.println(e);
	}
%>