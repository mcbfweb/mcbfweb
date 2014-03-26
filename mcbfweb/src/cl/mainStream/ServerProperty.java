/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.mainStream;

import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author anil
 */
public class ServerProperty {

    static Logger log = Logger.getLogger(ServerProperty.class.getName());
    public static Properties properties;
    /**This method retrieves values from the file system.properties,
     * based on a key specified. If the key is not found in the file,
     * the database will be searched.
     * @param key The key that identifies which value to be retrieved.
     * @return The retrieved value that corresponds to the key specified.
     * @throws Exception
     */
    public static String getProperty(String key) {
        String value = null;

            //properties = System.getProperties();
            value = properties.getProperty(key);

        return value;
    }



}
