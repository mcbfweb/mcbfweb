package cl.actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;

import cl.mainStream.BSOption;
import cl.mainStream.BSTables;
import cl.mainStream.VedaConstants;
import cl.managers.BizEntityMgr;
import cl.model.BizEntAdr;
import cl.model.BizEntCnt;
import cl.model.BizEntId;
import cl.model.EntityDetail;

@ParentPackage(value = "default")
@Namespace("/Main")
@ResultPath(value = "/")
@InterceptorRefs({ @InterceptorRef("loginStack"),

})
@Action(value = "AddClient", results = {
		@Result(name = "success", location = "/User/MaintUser", type = "redirect"),
		@Result(name = "input", location = "/admin/pages/addClient.jsp"),
		@Result(name = "error", location = "pages/error.jsp") })
public class AddClientAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private boolean init;
	private String clientId;
	private String bizName;
	
	private String bizGroup;
	private String bizType;

	private BizEntId entIds[];
	private BizEntAdr entAdrs[];
	private BizEntCnt entCnts[];

	private EntityDetail entity;
	private int entid;
	private UserDetails usrd;
	private BizEntityMgr manager;
	private ApplicationContext ctx;
	// private final static int MAX_ADDRESSES = 3;
	private final static int MAX_CONTACTS = 3;

	@Override
	public String execute() throws Exception {

		System.out.println("AddClientAction");

		if (!init) {
			setInit(true);
			loadArrays();
			entIds = new BizEntId[2];
			entAdrs = new BizEntAdr[2];
			entCnts = new BizEntCnt[2];
			// this.entid = manager.getNextEntityNumber();
			this.entid = 2;

		}

		if (getBizGroup() == null || getBizGroup() == "-1"
				|| getBizGroup().trim().length() == 0)
			return INPUT;

		return INPUT;
	}

	@Action(value = "createClient", results = {
			@Result(name = "success", location = "/Main/ListClient", type = "redirect"),
			@Result(name = "input", location = "/admin/pages/addClient.jsp") })
	public String addUpdateClient() {

		System.out.println("createClient method Action");
		ctx = (ApplicationContext) getServletContex()
				.getAttribute("SPRING_CTX");

		manager = (BizEntityMgr) ctx.getBean("bizEntityMgrImpl");
		entity = (EntityDetail) ctx.getBean("entityDetail");
		// entIds = entity.getIds();
		// entAdrs = entity.getAddresses();
		// entCnts = entity.getContacts();
		usrd = (UserDetails) getSession().get(VedaConstants.USER_KEY);
		Date current = new Date();
		Calendar cal = Calendar.getInstance();

		entity.setBizCode(getBizType());
		entity.setBizName(getBizName());
		entity.setfName("");
		entity.setlName("");
		entity.setsName("");
		entity.setuName("");
		entity.setType("PRMRY");
		entity.setChgByUser("");
		entity.setChgDate(current);
		entity.setCrtByUser(getUsrd().getUsername());
		entity.setCrtDate(current);
		entity.setEcoCode(getBizGroup());
		entity.setEntity(entid);
		entity.setEntTyp("BIZ");

		for (BizEntId e : entIds) {
			e.setChgByUser("");
			e.setChgDate(current);
			e.setCrtByUser(usrd.getUsername());
			e.setCrtDate(current);
			e.setVersion(1);

		}

		for (BizEntAdr e : entAdrs) {
			e.setChgByUser("");
			e.setChgDate(current);
			e.setCrtByUser(usrd.getUsername());
			e.setCrtDate(current);
			e.setVersion(1);
		}

		for (BizEntCnt e : entCnts) {
			e.setChgByUser("");
			e.setChgDate(current);
			e.setCrtByUser(usrd.getUsername());
			e.setCrtDate(current);
			e.setVersion(1);
		}
		entity.setIds(entIds);
		entity.setAddresses(entAdrs);
		entity.setContacts(entCnts);

		entity.setIds(entIds);
		entity.setInnchgByUser("");
		entity.setInnchgDate(current);
		entity.setInncrtByUser(usrd.getUsername());
		entity.setInncrtDate(current);
		entity.setInnversion(1);
		entity.setVersion(1);

		manager.insertEntityDetail(entity);
		// reload clients
		List<EntityDetail> clients = manager.getAllClients();
		getServletContex().setAttribute("CLIENTS_LIST", clients);

		return SUCCESS;
	}

	public void loadArrays() {

		super.bizGroupArry = BSTables.instance().getTable(
				BSTables.ECONOMIC_SECTOR, "");
		super.bizTypeArry = new ArrayList<BSOption>();
		super.bizTypeArry.add(new BSOption("", "", ""));
	}

	public BizEntId[] getEntIds() {
		return entIds;
	}

	public void setEntIds(BizEntId[] entIds) {
		this.entIds = entIds;
	}

	public BizEntAdr[] getEntAdrs() {
		return entAdrs;
	}

	public void setEntAdrs(BizEntAdr[] entAdrs) {
		this.entAdrs = entAdrs;
	}

	public BizEntCnt[] getEntCnts() {
		return entCnts;
	}

	public void setEntCnts(BizEntCnt[] entCnts) {
		this.entCnts = entCnts;
	}

	public int getEntid() {
		return entid;
	}

	public void setEntid(int entid) {
		this.entid = entid;
	}

	public UserDetails getUsrd() {
		return usrd;
	}

	public void setUsrd(UserDetails usrd) {
		this.usrd = usrd;
	}

	public BizEntityMgr getManager() {
		return manager;
	}

	public void setManager(BizEntityMgr manager) {
		this.manager = manager;
	}

	public ApplicationContext getCtx() {
		return ctx;
	}

	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}

	public EntityDetail getEntity() {
		return entity;
	}

	public void setEntity(EntityDetail entity) {
		this.entity = entity;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public String getBizGroup() {
		return bizGroup;
	}

	public void setBizGroup(String bizGroup) {
		this.bizGroup = bizGroup;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public boolean isInit() {
		return init;
	}

	public void setInit(boolean init) {
		this.init = init;
	}

}
