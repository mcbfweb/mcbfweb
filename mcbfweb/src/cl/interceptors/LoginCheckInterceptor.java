package cl.interceptors;

import java.util.Collections;
import java.util.Map;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;

import cl.actions.LoginAction;
import cl.mainStream.AppConstants;
import cl.mainStream.VedaConstants;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.TextParseUtil;

public class LoginCheckInterceptor implements Interceptor {

	/** 
     *  
     */
	private static final long serialVersionUID = -5361082118609994164L;
	static Logger logger = Logger.getLogger(LoginCheckInterceptor.class);

	private static final String AUTH_REQD = "authentication_required";
	private Set excludeActions = Collections.EMPTY_SET;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		logger.debug("Login check Interceptor init");

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		Map<String, Object> session = invocation.getInvocationContext().getSession();
		String view = (String) session.get(AppConstants.VIEW_TYPE);
		UserDetails validUser = (UserDetails) session.get(VedaConstants.USER_KEY);
		// this code should also if Login attribute is true...for now ok
		Object action = invocation.getAction();
		if (action instanceof LoginAction)
			return invocation.invoke();

		System.out.println("LoginCheckInterceptor " + validUser);
		if (validUser == null) {
			/*
			 * addActionError(invocation,
			 * "You must be authenticated to access this page"); logger.debug
			 * ("You must be authenticated to access this page");
			 */
			// return success for now later change to error
			System.out.println("valid user");
			// return Action.SUCCESS;
			// return Action.ERROR;

			return AUTH_REQD;
		}

		logger.debug("Login check Interceptor intercept");
		return invocation.invoke();
	}

	private void addActionError(ActionInvocation invocation, String message) {
		Object action = invocation.getAction();
		if (action instanceof ValidationAware) {
			((ValidationAware) action).addActionError(message);
		}
	}

	public void setExcludeActions(String values) {

		if (values != null) {

			this.excludeActions = TextParseUtil.commaDelimitedStringToSet(values);
		}
	}
}
