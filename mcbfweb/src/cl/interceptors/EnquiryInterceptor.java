package cl.interceptors;

import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class EnquiryInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String LOCALE_PARAMETER = "request_locale";
	static Logger logger = Logger.getLogger(MobileInterceptor.class);

	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {

		logger.debug("Enquiry Interceptor init");
		// put the value inside the valueStack

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		// put the value inside the valueStack
		ValueStack stack = invocation.getStack();
		// stack.getContext().put(AppConstants.VIEW_TYPE, viewType);
		System.out.println("EnquiryInterceptor valuestack root = " + stack.getRoot().toString());

		Map<String, Object> session = invocation.getInvocationContext().getSession();

		Object action = invocation.getAction();
		Iterator<?> iter = stack.getRoot().iterator();
		

		return invocation.invoke();

	}

}
