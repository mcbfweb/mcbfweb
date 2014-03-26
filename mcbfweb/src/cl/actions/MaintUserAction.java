package cl.actions;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import cl.mainStream.BSOption;
import cl.mainStream.BSTables;
import cl.mainStream.ServerProperty;
import cl.mainStream.VedaConstants;
import cl.managers.AdmUsrMgr;
import cl.managers.UserLoginMgr;
import cl.model.CustomUser;
import cl.model.User;
import cl.service.UserGrantedAuthority;

@ParentPackage(value = "default")
@Namespace("/User")
@ResultPath(value = "/")
@InterceptorRefs({
	@InterceptorRef("loginStack"),
	 
})
public class MaintUserAction extends BaseAction {

	private String client;
	private String status;
	private String usrid;
	private String role;
	private String group;
	private String usrname;
	private String email;
	private String isd;
	private String areacode;
	private String phone;

	private String usrid1;
	private String client1;

	private List<BSOption> statusArry;
	private List<BSOption> roleArry;
	private List<BSOption> groupArry;
	private boolean init;

	private static String CANCEL = "cancel";
	private static final long serialVersionUID = 136932283889158803L;
	static Logger logger = Logger.getLogger(MaintUserAction.class);

	@Action(value = "MaintUser", results = {
			@Result(name = "success_m", location = "/User/Menu", type = "redirect"),
			@Result(name = "error", location = "../user/pages/login_m.jsp"),
			@Result(name = "input_m", location = "/admin/pages/maintUser.jsp") })
	@Override
	public String execute() throws Exception {

		logger.debug("Maintain User execute");
		try {
			if (!init) {
				setInit(true);
				loadArrays();
			}

			if (getClient() == null || getClient().trim().length() == 0)
				return AppConstants.INPUT_MOBILE_VIEW;

			if (!isValidEmailAddress(getEmail())) {
				addActionError("Invlaid Email!");
				return AppConstants.INPUT_MOBILE_VIEW;
			}
			// addUpdateUser();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		// return INPUT;
		return AppConstants.INPUT_MOBILE_VIEW;
	}

	@Action(value = "getUser", results = { @Result(name = "input_m", location = "/admin/pages/maintUser.jsp"), })
	public String getUser() {

		 
		if(usrid != null && usrid.trim().length() > 0){
			setClient1(client);
			setUsrid1(usrid);
		}
		 
		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");

		AdmUsrMgr manager =
				(AdmUsrMgr) ctx.getBean("admUsrMgrImpl");
		User user;
		try {
			user = (User) manager.getUserById(getClient1(), getUsrid1());
		} catch (UserDoesNotExistError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			addActionError("Invlaid ID!");
			return AppConstants.INPUT_MOBILE_VIEW;
		}

		setClient(Integer.toString(user.getClient()));
		setStatus(user.getStatus());
		setUsrid(user.getUserID());
		setRole(user.getUserRole());
		setGroup(user.getUserGroup());
		setUsrname(user.getUserName());
		setEmail(user.getUserEmail());
		setIsd(user.getUserISDCde());
		setAreacode(user.getUserAreaCde());
		setPhone(user.getUserPhnNo());

		loadArrays();
		// return INPUT;
		return AppConstants.INPUT_MOBILE_VIEW;

	}

	@Action(value = "addUpdateUser", results = { @Result(name = "input_m", location = "/User/ListUser", type = "redirect"), })
	public String addUpdateUser() {
		User user = null;
		boolean doUpdate = false;
		UserDetails usrd = (UserDetails) session.get(VedaConstants.USER_KEY);
		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");

		AdmUsrMgr manager =
				(AdmUsrMgr) ctx.getBean("admUsrMgrImpl");

		Date current = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(current);
		cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH) + 6));
		Date expiry = cal.getTime();

		try {
			user = manager.getUserById(getClient(), getUsrid());
		} catch (UserDoesNotExistError e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			addActionError("New User Added!");
		}

		if (user == null) {
			doUpdate = true;
			user = (User) ctx.getBean("user");
			user.setCrtByUser(usrd.getUsername());
			user.setCrtDate(current);
			user.setPwdExpDt(expiry);
			user.setStatusDate(current);
			user.setVersion(1);
		}
		else {
			user.setVersion(user.getVersion() + 1);
			user.setChgByUser(usrd.getUsername());
			user.setChgDate(current);
		}
		user.setClient(new Integer(getClient()).intValue());
		user.setStatus(getStatus());

		user.setUserID(getUsrid());
		user.setUserPwd(getUsrid());

		user.setUserRole(getRole());
		user.setUserGroup(getGroup());
		user.setUserName(getUsrname());
		user.setUserEmail(getEmail());
		user.setUserISDCde(getIsd());
		user.setUserAreaCde(getAreacode());
		user.setUserPhnNo(getPhone());

		if (doUpdate)
			manager.insertUser(user);
		else
			manager.updateUser(user);

		loadArrays();
		// return INPUT;
		return AppConstants.INPUT_MOBILE_VIEW;
	}

	public void loadArrays() {

		this.statusArry = BSTables.instance().getTable(BSTables.ACC_STS, "");
		this.roleArry = BSTables.instance().getTable(BSTables.SEC_AUTH, "");
		this.groupArry = BSTables.instance().getTable(BSTables.USR_GRP, "");

	}

	public static boolean isValidEmailAddress(String email) {
		boolean stricterFilter = true;
		String stricterFilterString = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
		String laxString = ".+@.+\\.[A-Za-z]{2}[A-Za-z]*";
		String emailRegex = stricterFilter ? stricterFilterString : laxString;
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(emailRegex);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsrid() {
		return usrid;
	}

	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsd() {
		return isd;
	}

	public void setIsd(String isd) {
		this.isd = isd;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsrid1() {
		return usrid1;
	}

	public List<BSOption> getStatusArry() {
		return statusArry;
	}

	public void setStatusArry(List<BSOption> statusArry) {
		this.statusArry = statusArry;
	}

	public List<BSOption> getRoleArry() {
		return roleArry;
	}

	public void setRoleArry(List<BSOption> roleArry) {
		this.roleArry = roleArry;
	}

	public List<BSOption> getGroupArry() {
		return groupArry;
	}

	public void setGroupArry(List<BSOption> groupArry) {
		this.groupArry = groupArry;
	}

	public boolean isInit() {
		return init;
	}

	public void setInit(boolean init) {
		this.init = init;
	}

	public void setUsrid1(String usrid1) {
		this.usrid1 = usrid1;
	}

	public String getClient1() {
		return client1;
	}

	public void setClient1(String client1) {
		this.client1 = client1;
	}

	public String reset() throws Exception {
		super.clearErrorsAndMessages();

		// this.username = "";
		// this.password = "";

		return INPUT;
	}

	public String cancel() throws Exception {
		super.clearErrorsAndMessages();

		// this.username = "";
		// this.password = "";

		return CANCEL;
	}

}
