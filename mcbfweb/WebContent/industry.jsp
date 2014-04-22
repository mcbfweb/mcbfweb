<%@ page import="cl.mainStream.BSOption"%>
<%@ page import="cl.mainStream.BSTables"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%
	List<BSOption> bizTypeArry = BSTables.instance().getTable(BSTables.INDUSTRY, "");
	String bizGroup = request.getParameter("indGrp").trim();

	String buffer = "<option value=\'-1\'>--Select a Type--</option>";
	try {
		String code = "";
		String desc = "";
		List<BSOption> array = new ArrayList<BSOption>();
		for (BSOption option : bizTypeArry) {
			if (option.getMajCode().trim().equalsIgnoreCase(bizGroup))
				buffer = buffer + "<option value='" + option.getCode() + "'>" + option.getLabel() + "</option>";
		}

		//buffer = buffer + "</select>";
		response.getWriter().println(buffer);
	} catch (Exception e) {
		System.out.println(e);
	}
%>