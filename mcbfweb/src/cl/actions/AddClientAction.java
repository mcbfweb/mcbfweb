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
import cl.model.BizEntId;
import cl.model.EntityDetail;

@ParentPackage(value = "default")
@Namespace("/Main")
@ResultPath(value = "/")
@InterceptorRefs({
		@InterceptorRef("loginStack"),

})
@Action(value = "AddClient", results = {
		@Result(name = "success", location = "/User/MaintUser", type = "redirect"),
		@Result(name = "input", location = "/admin/pages/addClient.jsp"),
		@Result(name = "error", location = "pages/error.jsp")
})
public class AddClientAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private boolean init;
	private String clientId;
	private String bizName;
	private String idTyp;
	private String idCode;
	private String addtype;
	private String streetNo;
	private String streetName;
	private String addrLine1;
	private String addrLine2;
	private String email;
	private String isd;
	private String areacode;
	private String phone;
	private String extention;
	private String bizGroup;
	private String bizType;

	private List<BizEntId> entIds ;
	private EntityDetail entity;
	private int entid;
	private UserDetails usrd;
	private BizEntityMgr manager;
	private ApplicationContext ctx;
	// private final static int MAX_ADDRESSES = 3;
	private final static int MAX_CONTACTS = 3;

	// private final static int MAX_OCCUPATIONS = 3;

	@Override
	public String execute() throws Exception {

		System.out.println("AddClientAction");
		
		if (!init) {
			setInit(true);
			loadArrays();
			this.usrd = (UserDetails) getSession().get(VedaConstants.USER_KEY);

			this.ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");

			this.manager = (BizEntityMgr) ctx.getBean("bizEntityMgrImpl");
			this.entity = (EntityDetail) ctx.getBean("entityDetail");
			entity.addId(new BizEntId()); 
			entity.addId(new BizEntId()); 
			entity.addId(new BizEntId()); 
			//this.entid = manager.getNextEntityNumber();

		}

		if (getBizGroup() == null || getBizGroup() == "-1" || getBizGroup().trim().length() == 0)
			return INPUT;

		return INPUT;
	}

	@Action(value = "createClient", results = { @Result(name = "success", location = "/Main/ListClient", type = "redirect"),
			@Result(name = "input", location = "/admin/pages/addClient.jsp") })
	public String addUpdateClient() {

		System.out.println("createClient method Action");

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
		entity.setCrtByUser(usrd.getUsername());
		entity.setCrtDate(current);
		entity.setEcoCode(getBizGroup());
		entity.setEntity(entid);
		entity.setEntTyp("BIZ");
		entIds = entity.getIds();
		
		for (BizEntId e : entIds) {
			e.setChgByUser("");
			e.setChgDate(current);
			e.setIdCode(getIdCode());
			e.setCrtByUser(usrd.getUsername());
			e.setCrtDate(current);
			e.setVersion(1);
			e.setIdTyp(getIdTyp());
		}

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

		super.bizGroupArry = BSTables.instance().getTable(BSTables.ECONOMIC_SECTOR, "");
		super.bizTypeArry = new ArrayList<BSOption>();
		super.bizTypeArry.add(new BSOption("", "", ""));
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

	public String getIdTyp() {
		return idTyp;
	}

	public void setIdTyp(String idTyp) {
		this.idTyp = idTyp;
	}

	public String getIdCode() {
		return idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public String getAddtype() {
		return addtype;
	}

	public void setAddtype(String addtype) {
		this.addtype = addtype;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
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

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
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
