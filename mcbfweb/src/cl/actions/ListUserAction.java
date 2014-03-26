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

import cl.managers.AdmUsrMgr;
import cl.managers.BizEntityMgr;
 
import cl.model.User;

@ParentPackage(value = "default")
@Namespace("/User")
@ResultPath(value = "/")
@InterceptorRefs({
	@InterceptorRef("loginStack"),
	
})
public class ListUserAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String viewFolder = "";
	private List<User> users;
	static Logger logger = Logger.getLogger(BaseAction.class.getName());

	@SuppressWarnings("unchecked")
	@Action(value = "ListUser", results = {
			@Result(name = "success_m", location = "/User/Menu", type = "redirect"),
			@Result(name = "input", location = "/admin/pages/listUser.jsp"),
			@Result(name = "error", location = "/inValidSession.jsp") })
	@Override
	public String execute() throws Exception {

		System.out.println("List User Action");

		users = (List<User>) getServletContex().getAttribute("USER_LIST");
		if (users == null) {
			ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");

			AdmUsrMgr manager =
					(AdmUsrMgr) ctx.getBean("admUsrMgrImpl");

			users = manager.getAllUsers();
			getServletContex().setAttribute("USER_LIST", users);
		}

		System.out.println(((User) users.get(0)).getUserName());
		return INPUT;
	}

	public String getViewFolder() {
		return viewFolder;
	}

	public void setViewFolder(String viewFolder) {
		getSession().put("device", viewFolder);
		this.viewFolder = viewFolder;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setClients(List<User> users) {
		this.users = users;
	}

}
