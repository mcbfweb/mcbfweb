package cl.actions;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;

import cl.errors.UserDoesNotExistError;
import cl.mainStream.AppConstants;
import cl.mainStream.VedaConstants;
import cl.managers.AdmUsrMgr;
import cl.managers.BizEntPrdMgr;
import cl.model.BizEntPrd;
import cl.model.EntityDetail;
import cl.model.User;

@ParentPackage(value = "default")
@Namespace("/Main")
@ResultPath(value = "/")
@InterceptorRefs({
		@InterceptorRef("defaultStack"),
		@InterceptorRef("mobileType")
})
@Action(value = "Product", results = {
		@Result(name = "success", location = "/User/MaintUser", type = "redirect"),
		@Result(name = "input", location = "/products/pages/prdList_m.jsp"),
		@Result(name = "error", location = "pages/error.jsp")
})

public class ProductAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(SearchBizAction.class);
	private String client;
	public EntityDetail entity;
	
	@Override
	public String execute() throws Exception {
		logger.info("ProductAction");
		
		System.out.println("ProductAction");
		this.entity = (EntityDetail) getServletContex().getAttribute("ENTITY_DETAIL");
		String urlTag = "../Main/getProductDetail.action?mode=view&clientId=";
		System.out.println(entity.getProducts().get(0));
		System.out.println(entity.getProducts().get(1));
		return INPUT;
	}
	
	@Action(value = "findProductById", results = { @Result(name = "input_m", location = "/products/pages/prdList_m.jsp")  })
	public String findProductById() {
		
		System.out.println(request.getParameter("clientId"));
		System.out.println(request.getParameter("prdId"));
		System.out.println("findProductById");
		
		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");

		BizEntPrdMgr manager =
				(BizEntPrdMgr) ctx.getBean("bizEntPrdMgrImpl");
		
		
		BizEntPrd	product = (BizEntPrd) manager.getPrdById(request.getParameter("clientId"), request.getParameter("prdId"));
		System.out.println(product.getPrdTitle() + " "+ product.getPrdPrice());
		
		return AppConstants.INPUT_MOBILE_VIEW;
	}

	
	


	public String getClient() {
		return client;
	}



	public void setClient(String client) {
		this.client = client;
	}


}
