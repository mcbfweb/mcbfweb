package cl.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import joptsimple.util.KeyValuePair;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.ApplicationContext;

import cl.errors.ClientDoesNotExistError;
import cl.mainStream.AppConstants;
import cl.mainStream.BSOption;
import cl.mainStream.BSTables;
import cl.managers.BizEntityMgr;
import cl.model.BizEntInn;
import cl.model.EntityDetail;

@ParentPackage(value = "default")
@Namespace("/Main")
@ResultPath(value = "/")
@InterceptorRefs({
		@InterceptorRef("defaultStack"),
		@InterceptorRef("mobileType")
})
@Action(value = "SearchBiz", results = {
		@Result(name = "success", location = "/User/MaintUser", type = "redirect"),
		@Result(name = "input", location = "/search/pages/searchBiz_m.jsp"),
		@Result(name = "error", location = "pages/error.jsp")
})
public class SearchBizAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private List<EntityDetail> clients;

	public String mode;
	public EntityDetail entity;

	private String clientId;
	protected List<String> clientArry = new ArrayList<String>();

	@Override
	public String execute() throws Exception {

		System.out.println("SearchBizAction Success");
		setArrays();
		getEntityDetailList();
		return INPUT;
	}

	@Action(value = "findBizByType", results = { @Result(name = "success", type = "json") })
	public String findBizByType() throws Exception {

		// System.out.println("findBiz");
		System.out.println(request.getParameter("q"));
		String query = request.getParameter("q");

		return SUCCESS;
	}

	@Action(value = "findBizByName", results = { @Result(name = "input_m", location = "/search/pages/searchResult_m.jsp") })
	public String findBizName() throws Exception {

		// System.out.println("findBiz");
		System.out.println(request.getParameter("clientId"));
		String clientId = request.getParameter("clientId");
		String mode = request.getParameter("mode");
		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");
		BizEntityMgr manager =
				(BizEntityMgr) ctx.getBean("bizEntityMgrImpl");

		try {
			this.entity = manager.getClientById(new Integer(clientId).intValue());

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

	@SuppressWarnings("unchecked")
	public void getEntityDetailList() {

		clients = (List<EntityDetail>) getServletContex().getAttribute("ENTITY_DETAIL_LIST");
		if (clients == null) {
			ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");

			BizEntityMgr manager =
					(BizEntityMgr) ctx.getBean("bizEntityMgrImpl");

			clients = manager.getAllClients();
			getServletContex().setAttribute("ENTITY_DETAIL_LIST", clients);
		}

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

	@JSON(serialize = true)
	public List<String> getClientArry() {
		return clientArry;
	}

	public void setClientArry(List<String> clientArry) {
		this.clientArry = clientArry;
	}

	public void setArrays() {
		setBizTypeArry(BSTables.instance().getTable(BSTables.BUSINESS_SECTOR, ""));
	}
}
