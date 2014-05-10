package cl.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

import com.opensymphony.xwork2.Preparable;

import cl.errors.ClientDoesNotExistError;
import cl.mainStream.AppConstants;
import cl.mainStream.BSOption;
import cl.mainStream.BSTables;
import cl.mainStream.VedaConstants;
import cl.managers.BizEntityMgr;
import cl.model.BizEntAdr;
import cl.model.BizEntCnt;
import cl.model.BizEntId;
import cl.model.BizEntInn;
import cl.model.EntityDetail;

@ParentPackage(value = "default")
@Namespace("/Main")
@ResultPath(value = "/")
@InterceptorRefs({ @InterceptorRef("loginStack"),

})
public class MaintClientAction extends BaseAction implements Preparable {

	private static final long serialVersionUID = 1L;

	private boolean init;
	private String clientId;

	public EntityDetail entity;

	public String mode;

	@Override
	@Action(value = "MaintClient", results = { @Result(name = "input", location = "/admin/pages/maintClient.jsp"),
			@Result(name = "error", location = "pages/error.jsp") })
	public String execute() throws Exception {

		System.out.println("MaintClientAction");
		if (!init)
			setInit(true);

		loadArrays();

		return INPUT;
	}

	public void loadArrays() {

		super.bizGroupArry = BSTables.instance().getTable(BSTables.ECONOMIC_SECTOR, "");
		super.bizTypeArry = new ArrayList<BSOption>();
		super.bizTypeArry.add(new BSOption("", "", ""));
		super.indGrpArry = new ArrayList<BSOption>();
		super.indGrpArry.add(new BSOption("", "", ""));
		super.industryArry = new ArrayList<BSOption>();
		super.industryArry.add(new BSOption("", "", ""));

		super.bizIDTypeArry = BSTables.instance().getTable(BSTables.BIZ_ID_TYPE, "");
		super.ISDCdeArry = BSTables.instance().getTable(BSTables.ISD_CDE, "");
		super.adrTypeArry = BSTables.instance().getTable(BSTables.ADR_TYPE, "");
		super.adrCityArry = BSTables.instance().getTable(BSTables.CITIES, "");
		super.adrStateArry = BSTables.instance().getTable(BSTables.STATES, "");
		super.adrCountryArry = BSTables.instance().getTable(BSTables.COUNTRIES, "");

		System.out.println("Tables Loaded");

	}

	@Action(value = "getClient", results = { @Result(name = "input_m", location = "/admin/pages/maintClient.jsp"), })
	public String getClient() {

		setMode("maintain");

		if (!init)
			setInit(true);

		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");

		BizEntityMgr manager = (BizEntityMgr) ctx.getBean("bizEntityMgrImpl");

		try {

			this.entity = manager.getClientById(new Integer(clientId).intValue());
			session.put("org_entity", entity);

			// loadArrays();
			populateBizTypeArry(entity.getEcoCode());
			populateIndGrpArry(entity.getBizCode());
			populateIndustryArry(entity.getGrpCode());

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

	@Action(value = "updateClient", results = { @Result(name = "input", location = "/admin/pages/maintClient.jsp"),
			@Result(name = "success", location = "/Main/ListClient", type = "redirect") })
	public String updateClient() {

		UserDetails usrd = (UserDetails) getSession().get(VedaConstants.USER_KEY);
		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");

		BizEntityMgr manager = (BizEntityMgr) ctx.getBean("bizEntityMgrImpl");

		Date current = new Date();

		Iterator<BizEntId> itr = entity.getIds().iterator();
		BizEntId eid = null;
		while (itr.hasNext()) {

			eid = (BizEntId) itr.next();
			if (eid.getIdCode().trim().length() == 0)
				itr.remove();
		}
		Iterator<BizEntAdr> itrA = entity.getAddresses().iterator();
		BizEntAdr eadr = null;
		while (itrA.hasNext()) {

			eadr = (BizEntAdr) itrA.next();
			if (eadr.getAdrPstCde().trim().length() == 0)
				itrA.remove();
		}

		Iterator<BizEntCnt> itrC = entity.getContacts().iterator();
		BizEntCnt ecnt = null;
		while (itrC.hasNext()) {

			ecnt = (BizEntCnt) itrC.next();
			if (ecnt.getCntEmail().trim().length() == 0)
				itrC.remove();
		}

		Iterator<BizEntInn> itrN = entity.getNames().iterator();
		BizEntInn enam = null;
		while (itrN.hasNext()) {

			enam = (BizEntInn) itrN.next();
			if (enam.getBizName().trim().length() == 0)
				itrN.remove();
		}

		for (BizEntId e : entity.getIds()) {
			e.setChgByUser(usrd.getUsername());
			e.setChgDate(current);
			e.setVersion(1);

		}

		for (BizEntAdr e : entity.getAddresses()) {
			e.setChgByUser(usrd.getUsername());
			e.setChgDate(current);
			e.setVersion(1);

		}

		for (BizEntCnt e : entity.getContacts()) {
			e.setChgByUser(usrd.getUsername());
			e.setChgDate(current);
			e.setVersion(1);

		}

		for (BizEntInn e : entity.getNames()) {
			e.setChgByUser(usrd.getUsername());
			e.setChgDate(current);
			e.setVersion(1);

		}

		entity.setChgByUser(usrd.getUsername());
		entity.setChgDate(current);

		manager.updateEntityDetail(entity);

		loadArrays();
		return SUCCESS;

	}

	@Action(value = "deleteClient", results = { @Result(name = "input_m", location = "/Main/ListClient", type = "redirect"), })
	public String deleteClient() {

		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");
		BizEntityMgr manager = (BizEntityMgr) ctx.getBean("bizEntityMgrImpl");

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

	public void populateBizTypeArry(String bizcode) {
		populateType(bizcode);
	}

	public void populateIndGrpArry(String indGrp) {
		populateGrp(indGrp);
	}

	public void populateIndustryArry(String ind) {
		populateInd(ind);
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

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public void prepare() throws Exception {

		loadArrays();

	}
}