package cl.actions;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class GridAction extends ActionSupport implements ServletContextAware,
SessionAware, ServletRequestAware, ServletResponseAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Integer rows = 0;
	public Integer page = 0;
	private String sord;
	private String sidx;
	private String searchField;
	private String searchString;
	private String searchOper;
	public Integer total = 0;
	public Integer records = 0;
	protected ServletContext context = null;
	protected Map<String, Object> session = null;
	protected HttpServletRequest request = null;
	protected HttpServletResponse response = null;

	public GridAction(){
		super();
	}
	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	public ServletContext getContext() {
		return context;
	}
	public void setContext(ServletContext context) {
		this.context = context;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

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
	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

}
