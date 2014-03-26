package cl.actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.dispatcher.SessionMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.mainStream.AppConstants;

@ParentPackage(value = "default")
@Namespace("/User")
@ResultPath(value = "/")
@InterceptorRefs({
		@InterceptorRef("securityStack"),		
})
public class IndexAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String viewFolder = "";

	static Logger logger = Logger.getLogger(BaseAction.class.getName());

	@SuppressWarnings("rawtypes")
	@Action(value = "Index", results = {
			@Result(name = "success_m", location = "Login", type="chain"),
			@Result(name = "public_m", location = "../menu/pages/publicMenu_m.jsp"),
			@Result(name = "obsolete", location = "/obsoletePage.jsp"),
			@Result(name = "error", location = "/inValidSession.jsp") })
	@Override
	public String execute() throws Exception {

		logger.debug("Index execute");
		// This code will check browser compatability uncomment when required
		
		//((SessionMap)this.session).invalidate();
		Map<String, Object> sessionMap = getSession();

		System.out.print("index.jsp - " + sessionMap.get("application"));
		System.out.print('\n' + "index.jsp - " + sessionMap.get("partner") + '\n');

		if (viewFolder.equalsIgnoreCase(AppConstants.MOBILE_VIEW))
			return "success_m";

		if (sessionMap.get("partner") != null && ((String)sessionMap.get("partner")).trim().equalsIgnoreCase("public"))
				return "public_m";
				
		return "success_m";
	}

	public String getViewFolder() {
		return viewFolder;
	}

	public void setViewFolder(String viewFolder) {
		getSession().put("device", viewFolder);
		this.viewFolder = viewFolder;
	}

}
