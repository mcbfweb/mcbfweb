/**
 * 
 */
/**
 * @author anil
 *
 */
@TypeDefs( {
	  @TypeDef(name = "encryptedString",
	      typeClass = EncryptedStringType.class,
	      parameters = {
	        @Parameter(name = "encryptorRegisteredName",
	            value = "strongHibernateStringEncryptor")
	      })
	})

package cl.model;

import org.hibernate.annotations.TypeDefs;

import org.hibernate.annotations.TypeDef;

import org.hibernate.annotations.Parameter;

import org.jasypt.hibernate4.type.EncryptedStringType;



