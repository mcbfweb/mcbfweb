package cl.interceptors;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import cl.actions.LoginAction;
import cl.mainStream.AppConstants;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;


public class MobileInterceptor extends AbstractInterceptor {

	public static final Pattern MOBILE_PATTERN = Pattern
			.compile(".*(iphone|ipod|android.*mobile|webos|netfront|opera mini|semc-browser|playstation portable|nintendo wii|blackberry).*");
	 static Logger logger = Logger.getLogger(MobileInterceptor.class);
	 
	 public void destroy() {  
	        // TODO Auto-generated method stub  
	          
	    }  
	  
	    @Override  
	    public void init() {  
	        
	    	logger.debug("Mobile Type Interceptor init");
	          
	    }  
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String viewType = null;
				
		if (viewType == null) {
			viewType = getViewTypeFromUserAgent();
		}

		// put the value inside the valueStack
		ValueStack stack = invocation.getStack();
		stack.getContext().put(AppConstants.VIEW_TYPE, viewType);
		
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		session.put(AppConstants.VIEW_TYPE, viewType);
		
		Object action = invocation.getAction();
		if (action instanceof LoginAction) {
			((LoginAction) action).setViewFolder(viewType);
		}
		return invocation.invoke();

	}

	private String getViewTypeFromUserAgent() {
		String userAgent = ServletActionContext.getRequest().getHeader(
				"User-Agent");
		if (userAgent != null) {
			Matcher m = MOBILE_PATTERN.matcher(userAgent.toLowerCase());
			if (m.matches()) {
				return AppConstants.MOBILE_VIEW;
			}
		}
		return AppConstants.DEFAULT_VIEW;
	}

}
