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

import cl.errors.ClientDoesNotExistError;
import cl.mainStream.AppConstants;
import cl.mainStream.BSOption;
import cl.mainStream.BSTables;
import cl.mainStream.VedaConstants;
import cl.managers.BizEntityMgr;
import cl.model.BizEntId;
import cl.model.BizEntInn;
import cl.model.BizEntity;
import cl.model.EntityDetail;
import cl.model.User;

@ParentPackage(value = "default")
@Namespace("/Main")
@ResultPath(value = "/")
@InterceptorRefs({
	@InterceptorRef("loginStack"),
	 
})
@Action(value = "MaintClient", results = {
		@Result(name = "success", location = "/admin/pages/addClient.jsp", type = "redirect"),
		@Result(name = "input", location = "/admin/pages/selectClient.jsp"),
		@Result(name = "error", location = "pages/error.jsp")
})
public class MaintClientAction extends BaseAction {

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
	private int innVersion;
	private int version;
	private int idVersion;
	 

	public EntityDetail entity;
	public EntityDetail entityR;
	public String mode;

	@Override
	public String execute() throws Exception {

		System.out.println("MaintClientAction");
		if (!init) {
			setInit(true);
			loadArrays();

		}

		if (getBizGroup() == null || getBizGroup() == "-1" || getBizGroup().trim().length() == 0)
			return INPUT;

		return INPUT;
	}

	public void loadArrays() {

		super.bizGroupArry = BSTables.instance().getTable(BSTables.ECONOMIC_SECTOR, "");
		super.bizTypeArry = new ArrayList<BSOption>();
		super.bizTypeArry.add(new BSOption("", "", ""));
	}

	@Action(value = "getClient", results = { @Result(name = "input_m", location = "/admin/pages/maintClient.jsp"), })
	public String getClient() {

		setMode("maintain");
		//setMode((String) getSession().get("mode"));
		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");
		String cid = (String) getSession().get("clientId");
		BizEntityMgr manager =
				(BizEntityMgr) ctx.getBean("bizEntityMgrImpl");

		try {
			entityR = manager.getClientById(new Integer(clientId).intValue());
			setEntity(entityR);
			setBizGroup(entityR.getEcoCode());
			setBizType(entityR.getBizCode());
			setBizName(entityR.getBizName());
			setClientId(new Integer(entityR.getEntity()).toString());
			 
			this.version = entityR.getVersion() + 1;
			this.idVersion = entityR.getIdversion() + 1;
			this.innVersion = entityR.getInnversion() + 1;

			loadArrays();
			populateBizTypeArry();

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientDoesNotExistError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return INPUT;
		return AppConstants.INPUT_MOBILE_VIEW;

	}

	@Action(value = "updateClient", results = { @Result(name = "input_m", location = "/Main/ListClient"), })
	public String updateClient() {
		
		UserDetails usrd = (UserDetails) getSession().get(VedaConstants.USER_KEY);
		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");

		BizEntityMgr manager =
				(BizEntityMgr) ctx.getBean("bizEntityMgrImpl");

		Date current = new Date();
		Calendar cal = Calendar.getInstance();
		EntityDetail entity = (EntityDetail) ctx.getBean("entityDetail");

		entity.setBizCode(getBizType());
		entity.setBizName(getBizName());
		entity.setfName("");
		entity.setlName("");
		entity.setsName("");
		entity.setuName("");
		// entity.setType("PRMRY");
		entity.setChgByUser("");
		entity.setChgDate(current);
		entity.setCrtByUser(usrd.getUsername());
		entity.setCrtDate(current);
		entity.setEcoCode(getBizGroup());
		// entity.setEntity(entid);
		// entity.setEntTyp("BIZ");
		entity.setIdchgByUser("");
		entity.setIdchgDate(current);
		entity.setIdCode(getIdCode());
		entity.setIdcrtByUser(usrd.getUsername());
		entity.setIdcrtDate(current);
		entity.setIdversion(getIdVersion());
		entity.setIdTyp(getIdTyp());
		entity.setInnchgByUser("");
		entity.setInnchgDate(current);
		entity.setInncrtByUser(usrd.getUsername());
		entity.setInncrtDate(current);
		entity.setInnversion(getInnVersion());
		entity.setVersion(getVersion());

		manager.updateEntityDetail(entity);

		// reload clients
		List<EntityDetail> clients = manager.getAllClients();
		getServletContex().setAttribute("CLIENTS_LIST", clients);

		loadArrays();
		// return INPUT;
		return AppConstants.INPUT_MOBILE_VIEW;
	}
	@Action(value = "deleteClient", results = { @Result(name = "input_m", location = "/Main/ListClient", type = "redirect"), })
	public String deleteClient() {
		
		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");
  		BizEntityMgr manager =
				(BizEntityMgr) ctx.getBean("bizEntityMgrImpl");
  		 
		try {
			EntityDetail entityR = manager.getClientById(Integer.parseInt(clientId));
			manager.deleteEntityDetail(entityR);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientDoesNotExistError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// reload clients
		List<EntityDetail> clients = manager.getAllClients();
		getServletContex().setAttribute("CLIENTS_LIST", clients);

		loadArrays();
		// return INPUT;
		return AppConstants.INPUT_MOBILE_VIEW;
	}
	public void populateBizTypeArry() {
		populateType(getBizGroup());
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public boolean isInit() {
		return init;
	}

	public void setInit(boolean init) {
		this.init = init;
	}

	public EntityDetail getEntity() {
		return entity;
	}

	public void setEntity(EntityDetail entity) {
		this.entity = entity;
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

	public int getInnVersion() {
		return innVersion;
	}

	public void setInnVersion(int innVersion) {
		this.innVersion = innVersion;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getIdVersion() {
		return idVersion;
	}

	public void setIdVersion(int idVersion) {
		this.idVersion = idVersion;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	 

}
