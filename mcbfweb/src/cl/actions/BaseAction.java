package cl.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.apache.struts2.util.ServletContextAware;

import cl.mainStream.BSOption;
import cl.mainStream.BSTables;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletContextAware,
		SessionAware, ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ServletContext context = null;
	protected Map<String, Object> session = null;
	protected HttpServletRequest request = null;
	protected HttpServletResponse response = null;
	protected List<BSOption> bizGroupArry;
	protected List<BSOption> bizTypeArry;
	protected List<BSOption> indGrpArry ;
	protected List<BSOption> industryArry;
	protected List<BSOption> bizIDTypeArry;
	protected List<BSOption>ISDCdeArry;
	protected List<BSOption>adrTypeArry;
	protected List<BSOption>adrCityArry;
	protected List<BSOption>adrStateArry;
	protected List<BSOption>adrCountryArry;
	
	

	// BSoptions

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}
	@JSON(serialize=false)
	public Map<String, Object> getSession() {

		return this.session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void loadOptions() {

		try {

		} catch (Exception e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}

	public void populateType(String bizGroup) {

		setBizTypeArry(BSTables.instance().getTable(BSTables.BUSINESS_SECTOR, ""));
		List<BSOption> array = new ArrayList<BSOption>();
		for (BSOption option : bizTypeArry) {
			if (option.getMajCode().trim().equalsIgnoreCase( bizGroup))
				array.add(option);
		}

		setBizTypeArry(array);
	}
	public void populateGrp(String bizGroup) {

		setIndGrpArry(BSTables.instance().getTable(BSTables.INDUSTRY_GROUP, ""));
		List<BSOption> array = new ArrayList<BSOption>();
		for (BSOption option : indGrpArry) {
			if (option.getMajCode().trim().equalsIgnoreCase( bizGroup))
				array.add(option);
		}

		setIndGrpArry(array);
	}
	
	public void populateInd(String bizGroup) {

		setIndustryArry(BSTables.instance().getTable(BSTables.INDUSTRY, ""));
		List<BSOption> array = new ArrayList<BSOption>();
		for (BSOption option : industryArry) {
			if (option.getMajCode().trim().equalsIgnoreCase( bizGroup))
				array.add(option);
		}

		setIndustryArry(array);
	}
	@JSON(serialize=false)
	public List<BSOption> getBizGroupArry() {
		return bizGroupArry;
	}

	public void setBizGroupArry(List<BSOption> bizGroupArry) {
		this.bizGroupArry = bizGroupArry;
	}
	@JSON(serialize=false)
	public List<BSOption> getBizTypeArry() {
		return bizTypeArry;
	}

	public void setBizTypeArry(List<BSOption> bizTypeArry) {
		this.bizTypeArry = bizTypeArry;
	}
	 
		
	public List<BSOption> getBizIDTypeArry() {
		return bizIDTypeArry;
	}
	public void setBizIDTypeArry(List<BSOption> bizIDTypeArry) {
		this.bizIDTypeArry = bizIDTypeArry;
	}
		
	
	public List<BSOption> getIndGrpArry() {
		return indGrpArry;
	}
	public void setIndGrpArry(List<BSOption> indGrpArry) {
		this.indGrpArry = indGrpArry;
	}
	public List<BSOption> getIndustryArry() {
		return industryArry;
	}
	public void setIndustryArry(List<BSOption> industryArry) {
		this.industryArry = industryArry;
	}
	@Override
	public void setServletContext(ServletContext ctx) {
		this.context = ctx;

	}

	
	public List<BSOption> getISDCdeArry() {
		return ISDCdeArry;
	}
	public void setISDCdeArry(List<BSOption> iSDCdeArry) {
		ISDCdeArry = iSDCdeArry;
	}
	
	
	public List<BSOption> getAdrTypeArry() {
		return adrTypeArry;
	}
	public void setAdrTypeArry(List<BSOption> adrTypeArry) {
		this.adrTypeArry = adrTypeArry;
	}
	
	
	
	public List<BSOption> getAdrCityArry() {
		return adrCityArry;
	}
	public void setAdrCityArry(List<BSOption> adrCityArry) {
		this.adrCityArry = adrCityArry;
	}
	public List<BSOption> getAdrStateArry() {
		return adrStateArry;
	}
	public void setAdrStateArry(List<BSOption> adrStateArry) {
		this.adrStateArry = adrStateArry;
	}
	
	
	public List<BSOption> getAdrCountryArry() {
		return adrCountryArry;
	}
	public void setAdrCountryArry(List<BSOption> adrCountryArry) {
		this.adrCountryArry = adrCountryArry;
	}
	@JSON(serialize=false)
	public ServletContext getServletContex() {
		return this.context;
	}

	/*
	 * @Override public void setParameters(Map<String, String[]> arg0) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 */

}
