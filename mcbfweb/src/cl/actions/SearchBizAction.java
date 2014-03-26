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
	protected List<String> clientArry = new ArrayList <String>();
    public String q;
	

	@Override
	public String execute() throws Exception {

		System.out.println("SearchBizAction Success");

		setArrays();

		return INPUT;
	}

	@Action(value = "findBiz", results = { @Result(name = "success", type="json" )})
	public String findBiz() throws Exception {

		//System.out.println("findBiz");
		System.out.println(request.getParameter("q"));
		String query = request.getParameter("q");
		clientArry.clear();
		setArrays();
		@SuppressWarnings("unchecked")
		List<String> clientList = (List<String>) getServletContex().getAttribute("CLIENT_LIST");   
		String client ="";
		for(String c: clientList){
		  client = c.toLowerCase();	
		  if(client.startsWith(query.toLowerCase())) {
              clientArry.add(c);
          }	
		}
						
		return SUCCESS;
	}

	@JSON(serialize = true)
	public List<String> getClientArry() {
		return clientArry;
	}

	public void setClientArry(List<String> clientArry) {
		this.clientArry = clientArry;
	}

    public void setQ(String query){
    	
    	this.q = query;
    }
	

	public void setArrays() {
		setBizGroupArry(BSTables.instance().getTable(BSTables.ECONOMIC_SECTOR, ""));
		bizTypeArry = new ArrayList<BSOption>();
		bizTypeArry.add(new BSOption("", "", ""));
		setBizTypeArry(bizTypeArry);

		// clientArry = (List<String>) getServletContex().getAttribute("CLIENT_LIST");

	}
}
