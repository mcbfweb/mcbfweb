package cl.mainStream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author sudeshp
 * An Error Element <ERRORS><ERR><FIELD/></ERROR></ERR></ERRORS> from General error response	
 */

/**	 
 * 	Build:			NIMR_B09+
 * 	Issue: 			application wide
 * 	Date:			Friday, September 5, 2003 
 * 	Description:	Created new class to hold and return Application errors returned from backend.
 * 					This will be used by all maintenance action to display backend application errors.
 * 					
*/

public class BSError implements Serializable {
	
	private final static String GENERAL_ERRORS_TAG 	= "ERRORS";
	private final static String GENERAL_ERROR_TAG	= "ERR";

	
	private BSErrorItem[] errors = null;
		
	
	/**
	 * Method getErrors.
	 * @return BSElement[] with elements consisting FIELD and ERROR
	 */
	public BSErrorItem[] getErrors() {
		return errors;
	} 	
	
	

}
