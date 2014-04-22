package cl.actions;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.context.ApplicationContext;

import cl.managers.BizEntityMgr;
import cl.model.EntityListDetail;

@ParentPackage(value = "default")
@Namespace("/Main")
@ResultPath(value = "/")
@InterceptorRefs({ @InterceptorRef("loginStack"),

})
public class ListClientAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String viewFolder = "";
	private List<EntityListDetail> clients;
	static Logger logger = Logger.getLogger(BaseAction.class.getName());

	@SuppressWarnings("unchecked")
	@Action(value = "ListClient", results = { @Result(name = "success_m", location = "/User/Menu", type = "redirect"),
			@Result(name = "input", location = "/admin/pages/listClient.jsp"),
			@Result(name = "error", location = "/inValidSession.jsp") })
	@Override
	public String execute() throws Exception {

		System.out.println("List Client Action");

		this.clients = (List<EntityListDetail>) getServletContex().getAttribute("ENTITY_DETAIL_LIST");
		if (clients == null) {
			ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");
			BizEntityMgr manager = (BizEntityMgr) ctx.getBean("bizEntityMgrImpl");
			this.clients = manager.getListClients();
			getServletContex().setAttribute("ENTITY_DETAIL_LIST", clients);
		}

		/*List<String> clientArry = new ArrayList<String>();
		for (EntityDetail e : clients) {
			if (e.getNames()[0] != null && e.getNames()[0].getbName() != null && e.getNames()[0].getbName().trim().length() > 0
					&& !e.getNames()[0].getbName().equalsIgnoreCase("null"))
				clientArry.add(e.getNames()[0].getbName());
		}*/
		
		//getServletContex().setAttribute("CLIENT_LIST", clientArry);
		//System.out.println(clientArry.size());
		
		return INPUT;
	}

	public String getViewFolder() {
		return viewFolder;
	}

	public void setViewFolder(String viewFolder) {
		getSession().put("device", viewFolder);
		this.viewFolder = viewFolder;
	}

	public List<EntityListDetail> getClients() {
		return clients;
	}

	public void setClients(List<EntityListDetail> clients) {
		this.clients = clients;
	}

}
