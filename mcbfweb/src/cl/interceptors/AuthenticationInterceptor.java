/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.interceptors;

/**
 *
 * @author anil
 */

import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.ActionInvocation;
import java.util.Map;


public class AuthenticationInterceptor implements Interceptor {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void destroy() {
    }

    public void init() {
    }

    public String intercept(ActionInvocation actionInvocation) throws Exception {
        boolean isMember = true;
        Map session = actionInvocation.getInvocationContext().getSession();

        return "";

    }
}

