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
@Namespace("/User")
@ResultPath(value = "/")
@InterceptorRefs({
	@InterceptorRef("loginStack"),
	
 })

@Action(value = "Menu", results = {
		@Result(name = "load_data", location = "/data/upload/fileUpload.jsp", type = "redirect"),
		@Result(name = "add_client", location = "../Main/AddClient", type = "redirect"),
		@Result(name = "maint_client", location = "../Main/ListClient", type = "redirect"),
		@Result(name = "products", location = "../Main/Product", type = "redirect"),
		@Result(name = "maint_user", location = "../User/MaintUser", type = "redirect"),
		@Result(name = "input", location = "/menu/pages/internalMenu_m.jsp"),
		@Result(name = "error", location = "pages/error.jsp")
		})   

public class InternalMenuAction extends ActionSupport {    
	
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
        
		if(AppConstants.LOAD_DATA.equalsIgnoreCase(getMenuItem().trim()))
				return "load_data";
		
		if(AppConstants.ADD_CLIENT.equalsIgnoreCase(getMenuItem().trim()))
			return "add_client";
		
		if(AppConstants.MAINT_CLIENT.equalsIgnoreCase(getMenuItem().trim()))
			return "maint_client";
		
		if(AppConstants.MAINT_USER.equalsIgnoreCase(getMenuItem().trim()))
			return "maint_user";
		
		if(AppConstants.PRODUCTS.equalsIgnoreCase(getMenuItem().trim()))
			return "products";
		
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