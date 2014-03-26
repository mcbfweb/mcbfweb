/*
 *  Build:          NIMR_B09+
 *  Issue:          application wide
 *  Date:           Friday, September 5, 2003 
 *  Description:    Replaced the use of HashMap with BSError. Changed constructors accordingly.
 *                  
 * Label: NIMR_B21+
 *        - Added type OTHER_ERROR
 *        - Added BLANK_ERROR_MESSAGE description for blank System errors.
 */
package cl.mainStream;

import java.util.HashMap;

/**
 * @author brianc
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class BSException extends Exception {
  public static final String SYSTEM_ERROR="SYSTEM";
  public static final String GENERAL_ERROR="ERROR";
  public static final String OTHER_ERROR="OTHER";
	
    private static final String BLANK_ERROR_MESSAGE = "{BLANK_ERROR_MESSAGE}";
    
  private String status;
  private String systemError;
  private BSError generalError;

    /**
     * Constructor for BSException.
     */
    public BSException() {
        super();
    }

    /**
     * Constructor for BSException.
     * @param arg0
     */
    public BSException(String arg0) {
        super(arg0);
        status = OTHER_ERROR;
    }

	/**
	 * Method BSException.
	 * @param status i.e. Error status
	 * @param applicationError
	 */
    public BSException(String status, BSError generalError) {
		super("General Error : " +  generalError);
    	this.status=status;
    	this.generalError = generalError;
    }

	/**
	 * Method BSException.
	 * @param status i.e. System Error status
	 * @param systemError
	 */
    public BSException(String status, String systemError) {
		super("System Error : " + systemError);
    	this.status = status;
    	this.systemError = ((systemError.length() > 0) ? systemError : BLANK_ERROR_MESSAGE);
    }
    
    public boolean isSystemError() {
    	return SYSTEM_ERROR.equals(status);
    }
    
    public boolean isGeneralError() {
    	return GENERAL_ERROR.equals(status);
    }
    
    public String getSystemError() {
    	return systemError;
    }
    
    public BSError getGeneralError() {
    	return generalError;
    }
}
