package cl.utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.WebPBEConfig;
import org.jasypt.web.pbeconfig.WebPBEInitializer;

public class MyWebPBEInitializer implements WebPBEInitializer {
	  
    public void initializeWebPBEConfigs() {
    
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        
        WebPBEConfig webConfig = new WebPBEConfig();
        webConfig.setValidationWord("jasypt");
        webConfig.setName("Main Password");

        encryptor.setConfig(webConfig);
        
        // Get some user-defined singleton or similar, and register
        // the encryptor with it so that it can be accessed from the
        // rest of the application.
        
    }
    
}