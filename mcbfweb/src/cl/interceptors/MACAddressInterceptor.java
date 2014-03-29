package cl.interceptors;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import cl.utils.IterableEnumeration;

public class MACAddressInterceptor extends AbstractInterceptor {

	
	 static Logger logger = Logger.getLogger(MACAddressInterceptor.class);
	 
	 public void destroy() {  
	        // TODO Auto-generated method stub  
	          
	    }  
	  
	    @Override  
	    public void init() {  
	        
	    	logger.debug("Mobile Type Interceptor init");
	          
	    }  
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
	
		  System.out.println("Current IP address : " + InetAddress.getLocalHost().getHostAddress());

		  for(NetworkInterface network : IterableEnumeration.make(NetworkInterface.getNetworkInterfaces())) {
		    byte[] mac = network.getHardwareAddress();
		    if(mac != null) {
		      System.out.print("Current MAC address : ");
		      StringBuilder sb = new StringBuilder();
		      for (int i = 0; i < mac.length; i++) {
		        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		      }
		      System.out.println(sb.toString());
		      //Bound InetAddress for interface
		      for(InetAddress address : IterableEnumeration.make(network.getInetAddresses())) {
		        System.out.println("\tBound to:"+address.getHostAddress());
		      }
		    }
		  }
		  
		  return invocation.invoke();
		}

	
	
}
