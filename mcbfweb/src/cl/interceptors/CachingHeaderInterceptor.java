/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.interceptors;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CachingHeaderInterceptor implements Interceptor {

    private static final long serialVersionUID = 1L;

    public String intercept(ActionInvocation invocation) throws Exception {

    	final ActionContext actx = invocation.getInvocationContext();
    	HttpServletResponse response = (HttpServletResponse) actx.get(StrutsStatics.HTTP_RESPONSE); 
       
        if(response != null){
        	
        	response.setHeader("Cache-control", "no-cache, no-store");
        	response.setHeader("Pragma", "no-cache");
        	response.setHeader("Expires", "-1");
        	
        }
        
        System.out.println("Caching Header Interceptor");
        
        return invocation.invoke();
         
    }

    public void destroy() {
        System.out.println("Destroying CachingHeaderInterceptor...");
    }

    public void init() {
        System.out.println("Initializing CachingHeaderInterceptor...");
    }
}
