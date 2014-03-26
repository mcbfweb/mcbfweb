package cl.utils.db;


import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;





/**
 * Registers and unregisters the Oracle JDBC driver.
 * 
 * Use only when the ojdbc jar is deployed inside the webapp (not as an
 * appserver lib)
 */
public class OjdbcDriverRegistrationListener implements ServletContextListener {

    private static final Logger LOG = Logger.getLogger(OjdbcDriverRegistrationListener.class);

    private Driver driver = null;

    /**
     * Registers the Oracle JDBC driver
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        
    }

    /**
     * Deregisters JDBC driver
     * 
     * Prevents Tomcat 7 from complaining about memory leaks.
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    	 // This manually deregisters JDBC driver, which prevents Tomcat 7 from complaining about memory leaks wrto this class
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                 LOG.log(Level.INFO, String.format("deregistering jdbc driver: %s", driver));
            } catch (SQLException e) {
                 LOG.log(Level.FATAL, String.format("Error deregistering driver %s", driver), e);
            }

        }

    }
}
