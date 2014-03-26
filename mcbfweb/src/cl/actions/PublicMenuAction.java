package cl.actions;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import cl.mainStream.AppConstants;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "default")
@Namespace("/Public")
@ResultPath(value = "/")
@InterceptorRefs({
@InterceptorRef("defaultStack"),
@InterceptorRef("mobileType") 
 })

@Action(value = "Menu", results = {
		@Result(name = "biz_type", location = "../Main/SearchBiz", type = "redirect"),
		@Result(name = "biz_name", location = "../Main/SearchBiz", type = "redirect"),
		@Result(name = "input", location = "/menu/pages/publicMenu_m.jsp"),
		@Result(name = "error", location = "pages/error.jsp")
		})   

public class PublicMenuAction extends ActionSupport {    
	
	//static Logger logger = Logger.getLogger(PublicUserMenuAction.class);
	
	//static Logger log = Logger.getLogger(ServerProperty.class.getName());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public String menuItem;
	
    @Override
    public String execute() throws Exception {
    	
		System.out.println("Public Menu Success");
		
		if(getMenuItem() == null || getMenuItem().trim().length() == 0)	 	
		    return INPUT;
        
		if(AppConstants.SEARCH_BY_BIZ_TYPE.equalsIgnoreCase(getMenuItem().trim()))
			return "biz_type";
		
		if(AppConstants.SEARCH_BY_BIZ_NAME.equalsIgnoreCase(getMenuItem().trim()))
			return "biz_name";
		
		System.out.println(getMenuItem().trim());
		
		return SUCCESS;
    }

	public String getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}

    
	

}