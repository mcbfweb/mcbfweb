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

import cl.mainStream.BSOption;
import cl.mainStream.BSTables;
import cl.mainStream.VedaConstants;
import cl.managers.BizEntityMgr;
import cl.model.BizEntAdr;
import cl.model.BizEntCnt;
import cl.model.BizEntId;
import cl.model.BizEntInn;
import cl.model.BizEntSrv;
import cl.model.EntityDetail;
import cl.model.EntityListDetail;

@ParentPackage(value = "default")
@Namespace("/Main")
@ResultPath(value = "/")
@InterceptorRefs({ @InterceptorRef("loginStack"),

})
@Action(value = "AddClient", results = { @Result(name = "success", location = "/User/MaintUser", type = "redirect"),
		@Result(name = "input", location = "/admin/pages/addClient.jsp"), @Result(name = "error", location = "pages/error.jsp") })
public class AddClientAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private boolean init;
	private String clientId;

	private EntityDetail entity;
	private Integer entid;
	private UserDetails usrd;
	private BizEntityMgr manager;
	private ApplicationContext ctx;
    private Date current;
    Integer innDatid;
    Integer idDatid;
    Integer adrDatid;
    Integer cntDatid;
    Integer srvDatid;
	@Override
	public String execute() throws Exception {

		System.out.println("AddClientAction");
		ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");
		manager = (BizEntityMgr) ctx.getBean("bizEntityMgrImpl");
		 
		 
		if (!init) {
			setInit(true);
			this.ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");
			this.manager = (BizEntityMgr) ctx.getBean("bizEntityMgrImpl");
			this.entity = (EntityDetail) ctx.getBean("entityDetail");
		}

		loadArrays();

		return INPUT;
	}

	@Action(value = "createClient", results = { @Result(name = "success", location = "/Main/ListClient", type = "redirect"),
			@Result(name = "input", location = "/admin/pages/addClient.jsp") })
	public String addUpdateClient() {

		System.out.println("createClient method Action");
		ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");
		manager = (BizEntityMgr) ctx.getBean("bizEntityMgrImpl");
		entid = manager.getNextEntityNumber();
		entity.setEntity(entid);
		usrd = (UserDetails) getSession().get(VedaConstants.USER_KEY);
		current = new Date();
		 
		innDatid = manager.getNextInnDtaid();
		idDatid = manager.getNextIdDtaid();
		adrDatid = manager.getNextAdrDtaid();
		cntDatid = manager.getNextCntDtaid();
		srvDatid = manager.getNextSrvDtaid();

		Iterator<BizEntId> itr = entity.getIds().iterator();
		BizEntId eid = null;
		while(itr.hasNext()){

		  eid = (BizEntId)itr.next();
		  if(eid.getIdCode().trim().length() == 0)		 
		    itr.remove();
		}
		Iterator<BizEntAdr> itrA = entity.getAddresses().iterator();
		BizEntAdr eadr = null;
		while(itrA.hasNext()){

		  eadr = (BizEntAdr)itrA.next();
		  if(eadr.getAdrPstCde().trim().length() == 0)		 
		    itrA.remove();
		}  
		
		Iterator<BizEntCnt> itrC = entity.getContacts().iterator();
		BizEntCnt ecnt = null;
		while(itrC.hasNext()){

		  ecnt = (BizEntCnt)itrC.next();
		  if(ecnt.getCntEmail().trim().length() == 0)		 
		    itrC.remove();
		}  
		
//		Iterator<BizEntInn> itrN = entity.getNames().iterator();
//		BizEntInn enam = null;
//		while(itrN.hasNext()){
//
//		  enam = (BizEntInn)itrN.next();
//		  if(enam.getBizName().trim().length() == 0)		 
//		    itrN.remove();
//		}  
		
		for (BizEntId e : entity.getIds()) {

			e.setDatid(idDatid++);
			e.setEntity(entid);
			e.setChgByUser(usrd.getUsername());
			e.setChgDate(current);
			e.setCrtByUser(usrd.getUsername());
			e.setCrtDate(current);
			e.setVersion(1);

		}

		
		for (BizEntAdr e : entity.getAddresses()) {
			e.setEntity(entid);
			e.setDatid(adrDatid++);
			e.setChgByUser(usrd.getUsername());
			e.setChgDate(current);
			e.setCrtByUser(usrd.getUsername());
			e.setCrtDate(current);
			e.setVersion(1);

		}
		

		for (BizEntCnt e : entity.getContacts()) {
			e.setDatid(cntDatid++);
			e.setCntTyp("EML");
			e.setCntPos("MGR");
			e.setEntity(entid);
			e.setChgByUser(usrd.getUsername());
			e.setChgDate(current);
			e.setCrtByUser(usrd.getUsername());
			e.setCrtDate(current);
			e.setVersion(1);
			
		}

		for (BizEntInn e : entity.getNames()) {
			e.setEntity(entid);
			e.setDatid(innDatid++);
			e.setChgByUser("");
			e.setChgDate(current);
			e.setCrtByUser(usrd.getUsername());
			e.setCrtDate(current);
			e.setVersion(1);
			e.setFstName("");
			e.setLstName("");
			e.setSurName("");
			e.setUnfName("");
			e.setType("PRMRY");
			e.setChgByUser(usrd.getUsername());
			e.setChgDate(current);
			e.setVersion(1);

		}
		for (BizEntSrv e : entity.getSrvNames()) {
			e.setDatid(srvDatid++);
			e.setEntity(entid);
			e.setChgByUser(usrd.getUsername());
			e.setChgDate(current);
			e.setCrtByUser(usrd.getUsername());
			e.setCrtDate(current);
			e.setVersion(1);
			
		}
		
		
		entity.setVersion(1);
		entity.setChgByUser("");
		entity.setChgDate(current);
		entity.setCrtByUser(getUsrd().getUsername());
		entity.setCrtDate(current);
		entity.setEntTyp("BIZ");

		// add
		manager.insertEntityDetail(entity);
		// reload clients

		List<EntityListDetail> clients = manager.getListClients();
		getServletContex().setAttribute("ENTITY_DETAIL_LIST", clients);

		return SUCCESS;
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
	}

	public Integer getEntid() {
		return entid;
	}

	public void setEntid(Integer entid) {
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

	public boolean isInit() {
		return init;
	}

	public void setInit(boolean init) {
		this.init = init;
	}

}
