package cl.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cl.errors.UserDoesNotExistError;
import cl.mainStream.AppConstants;
import cl.mainStream.ServerProperty;
import cl.mainStream.VedaConstants;
import cl.managers.UserLoginMgr;
import cl.model.CustomUser;
import cl.model.User;
import cl.service.UserGrantedAuthority;

@ParentPackage(value = "default")
@Namespace("/User")
@ResultPath(value = "/")
@InterceptorRefs({
		@InterceptorRef("securityStack"),
		//@InterceptorRef("mobileType")
})
public class LoginAction extends BaseAction {
	public String username;
	public String password;
	public static final String system = "baycorp2";

	private static String CANCEL = "cancel";
	private static final long serialVersionUID = 136932283889158803L;
	static Logger logger = Logger.getLogger(LoginAction.class);
	String viewFolder = "";
	static Logger log = Logger.getLogger(ServerProperty.class.getName());

	@Action(value = "Login", results = {
			@Result(name = "success_m", location = "/User/Menu", type = "redirect"),
			@Result(name = "error", location = "../user/pages/login_m.jsp"),
			@Result(name = "input_m", location = "/user/pages/login_m.jsp") })
	@Override
	public String execute() throws Exception {

		logger.debug("Login execute");
		try {

			if (getUsername() == null || getUsername().trim().length() == 0 || getPassword() == null
					|| getPassword().trim().length() == 0)

				if (AppConstants.MOBILE_VIEW.equalsIgnoreCase(getViewFolder()))
					return AppConstants.INPUT_MOBILE_VIEW;
				else
					return AppConstants.INPUT_MOBILE_VIEW;

			UserDetails cu = validateUser(getUsername());

			if (cu == null) {
				addActionError("Invlaid Login Information!");
				return ERROR;
			}
			if (getPassword().trim().equalsIgnoreCase(cu.getPassword())) {
				getSession().put(VedaConstants.USER_KEY, cu);
				return AppConstants.SUCCESS_MOBILE_VIEW;
			} else {
				addActionError("Invlaid Login Information!");
				return ERROR;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		// return INPUT;
		return AppConstants.INPUT_MOBILE_VIEW;
	}

	public UserDetails validateUser(String username) {

		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");

		UserLoginMgr manager =
				(UserLoginMgr) ctx.getBean("userLoginMgrImpl");
		User user;
		try {
			user = (User) manager.loadUserByName(username);
		} catch (UserDoesNotExistError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		System.out.println(user.getUserPwd());
		GrantedAuthority grantedAuth = new UserGrantedAuthority(user.getUserRole());
		CustomUser cu = new CustomUser(user.getDatId(), user.getUserID(), user.getUserPwd(),
				new GrantedAuthority[] { grantedAuth });
		return cu;

	}

	public String reset() throws Exception {
		super.clearErrorsAndMessages();

		this.username = "";
		this.password = "";

		return INPUT;
	}

	public String cancel() throws Exception {
		super.clearErrorsAndMessages();

		this.username = "";
		this.password = "";

		return CANCEL;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		System.out.println("UserName set  " + username);
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void main(String args[]) {

	}

	public HttpServletRequest getRequest() {

		return ServletActionContext.getRequest();
	}

	public String getViewFolder() {
		return viewFolder;
	}

	public void setViewFolder(String viewFolder) {
		this.viewFolder = viewFolder;
	}

}