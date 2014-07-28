package cl.actions;

import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;

import org.apache.struts2.convention.annotation.Action;

import org.apache.struts2.convention.annotation.InterceptorRef;

import org.apache.struts2.convention.annotation.InterceptorRefs;

import org.apache.struts2.convention.annotation.Namespace;

import org.apache.struts2.convention.annotation.ParentPackage;

import org.apache.struts2.convention.annotation.Result;

import org.apache.struts2.convention.annotation.ResultPath;

import cl.model.EntityDetail;

@ParentPackage(value = "default")
@Namespace("/Main")
@ResultPath(value = "/")
@InterceptorRefs({ @InterceptorRef("defaultStack"),

@InterceptorRef("mobileType") })
@Action(value = "ProductList", results = {
@Result(name = "success", location = "/products/pages/prdList_m.jsp" ),
@Result(name = "input", location = "/products/pages/prdList_m.jsp"),
@Result(name = "error", location = "pages/error.jsp") })

public class ProductListAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	static Logger logger = Logger.getLogger(SearchBizAction.class);

	 
	public String mode;

	public EntityDetail entity;

	
	@Override
	public String execute() throws Exception {

		logger.info("ProductListAction Success");
		this.entity = (EntityDetail) getServletContex().getAttribute("ENTITY_DETAIL");
		return INPUT;

	}

	
	public EntityDetail getEntity() {
		return entity;
	}

	public void setEntity(EntityDetail entity) {
		this.entity = entity;
	}
	
	

}