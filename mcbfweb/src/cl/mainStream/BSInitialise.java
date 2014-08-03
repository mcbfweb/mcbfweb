package cl.mainStream;

/* Label: 	NIMR_B61+
 *  		- Added AS400_CONNECTIONS_KEY parameter. This will define number of
 * 			connections required. In case of an error, BSRequest will set this value
 * 			to 1. 
 * Label:	NIMR_B64+
 * 			- Removed changes made under NIMR_B61+ 
 *
 * Label:	NIMR_B67+
 * Issue:	5920
 *  		- Added AS400_CONNECTIONS_KEY parameter. This will define number of
 * 			connections required. In case of an error, BSRequest will set this value
 * 			to 1. 
 * 
 * Label:   NIMR_B75+
 * Issue:   6191
 *          - Modified contextInitialized() to load Properties that map field names in back-end error messages
 *            to ResourceBundle keys of field labels.
 * 
 * Build:	NIMR_89+
 * Issue:	6614 Allow HTML Verisign seal to be included in menu bar
 * 			Initialise ApplicationState from context parameters and place it in application scope
 */

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;









import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




/**
 * Initialiser forBSRequest.instance().<br>
 * Gets the required parameters from the ServletContext.<br>
 * BSInitialise needs to be declared as a Listener in web.xml, and the
 * ServletContext parameters need to be defined in web.xml.
 */
//@WebListener
//@ServerEndpoint("/annotated")
public class BSInitialise implements ServletContextListener {

	private final static String AS400_USERID_KEY = "AS400UserId";
	private final static String AS400_PASSWORD_KEY = "AS400Password";
	private final static String AS400_SYSTEM_NAME_KEY = "AS400SystemName";
	private final static String AS400_CONNECTIONS_KEY = "AS400Connections";
	private final static String LOG_REQUEST_KEY = "LogRequests";

	private final static String DEFAULT_USER_KEY = "DefaultUser";

	private String xslPath = "/Veda_i/JQ3/Report_v1.2_PDF.xsl";

	/**
	 * @see javax.servlet.ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {

	}

	/**
	 * @see javax.servlet.ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext servletContext = sce.getServletContext();
		//final ServerContainer serverContainer = (ServerContainer) sce.getServletContext()
        //        .getAttribute("javax.websocket.server.ServerContainer");
		
		//String system = servletContext.getInitParameter(AS400_SYSTEM_NAME_KEY);
		//String userid = servletContext.getInitParameter(AS400_USERID_KEY);

		// ApplicationContext to be instantiated once for the application
				@SuppressWarnings("resource")
				ApplicationContext ctx =
						new ClassPathXmlApplicationContext("spring.xml");
				
				servletContext.setAttribute("SPRING_CTX", ctx);
								
				//String contextPath =servletContext.getRealPath("");
				//String contextPath =servletContext.getContextPath();
				String contextPath = servletContext.getRealPath("/Temp/images");
				String uploadPath = servletContext.getRealPath("/FTP/Node/upload");
				String downloadPath = servletContext.getRealPath("/FTP/Node/download");
				String imgTempPath = (String) servletContext.getContextPath() + "/Temp/images";
				
				String tempPath= contextPath;
				servletContext.setAttribute("TMP_FOLDER", tempPath);
				servletContext.setAttribute("FTP_UPLOAD", uploadPath);
				servletContext.setAttribute("FTP_DOWNLOAD", downloadPath);
				servletContext.setAttribute("IMG_TMP_FOLDER", imgTempPath);
				//try {
				//	serverContainer.addEndpoint(WordgameServerEndpoint.class);
				//} catch (DeploymentException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
				//}
				
				
                try {
					BSTables.instance().loadApplicationTables(ctx, sce);
				} catch (BSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}
	
	//@OnMessage
    //public String onMessage(String message) {
    //    return message;
    //}

}
