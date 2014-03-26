package cl.mainStream;

import java.io.Serializable;

/**
 * @author sudeshp
 * An Error Element <ERR><FIELD/></ERROR></ERR> from General error response	
 * 
 */

/**	 
 * 	Build:			NIMR_B09+
 * 	Issue: 			application wide
 * 	Date:			Friday, September 5, 2003 
 * 	Description:	Created new class to hold and return Application errors returned from backend.
 * 					This will be used by all maintenance action to display backend application errors.
 * 					
*/

public class BSErrorItem implements Serializable {
	
	private final static String GENERAL_ERROR_FIELD_TAG 		= "FIELD";
	private final static String GENERAL_ERROR_MESSAGE_TAG	= "ERROR";
	

}
