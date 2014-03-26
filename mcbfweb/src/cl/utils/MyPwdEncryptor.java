package cl.utils;

import java.util.Map;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.hibernate4.encryptor.HibernatePBEStringEncryptor;

public class MyPwdEncryptor {
/**
 * Steps - 1. set e.encryptText("text/pwd to be encrypted");
 *         2. set encryptor.setPassword("set this to some pwd that will be used for encryption");
 *         3. run the program
 *         4. cut and paste the encrypted string in web.xml or properties file which can be read by spring.xml 
 *         5. For spring store the pwd used for encryption in 2 above (in this case select12) in Windows or System environment variable "APP_ENCRYPTION_PASSWORD" and
 *            refer to in using <property name="passwordEnvName" value="APP_ENCRYPTION_PASSWORD" /> in spring.xml
 *             
 *   
 *   eg spring.xml
	 *        <bean
			class="org.jasypt.spring31.properties.EncryptablePropertyPlaceholderConfigurer">
			<constructor-arg>
				<bean class="org.jasypt.encryption.pbe.StandardPBEStringEncryptor">
					<property name="config">
						<bean class="org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig">
							<property name="algorithm" value="PBEWithMD5AndDES" />
							<!-- I have set the variable below in the Environment variables in 
								Control Panel -->
							<property name="passwordEnvName" value="APP_ENCRYPTION_PASSWORD" 
								/>						
						</bean>
					</property>
				</bean>
			</constructor-arg>
			<property name="locations">
				<list>
					<value>jdbc.properties</value>
				</list>
			</property>
		</bean>  
	
	eg jdbc.properties
		jdbc.driver=com.mysql.jdbc.Driver
		jdbc.url=jdbc:mysql://cbsuat:3306/clbizdat
		jdbc.username=itso
		jdbc.password=ENC(iJ1fv0WtAnNTxMSMGz97gg==)
			
 * 
 * 
 * @param text
 */
	public void encryptText(String text) {
		//StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();		
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		encryptor.setProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		encryptor.setPassword("select12"); // we HAVE TO set a password
		encryptor.setAlgorithm("PBEWithMD5AndDES"); // optionally set the
		encryptor.setPoolSize(1);                        
		
		String encryptedText = encryptor.encrypt(text);

		String plainText = encryptor.decrypt(encryptedText);
		System.out.println(encryptedText);
		System.out.println(plainText);
	}

	public static void main(String args[]){
		
		Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                              envName,
                              env.get(envName));
        }
		
		MyPwdEncryptor e = new MyPwdEncryptor();
		e.encryptText("1d818e83");
		
	}
	
}
