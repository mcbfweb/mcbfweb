package cl.mainStream;

import java.io.Serializable;

//import nimr.UserState;

public class BSOption implements Serializable {

	public String code;
	public String label_EN;
	public String majCode;

	// private UserState userState;

	public BSOption(String code, String label_EN, String majCode) {

		this.code = code;
		this.label_EN = label_EN;
		this.majCode= majCode;
		
	}

	/**
	 * Returns the code.
	 * 
	 * @return String
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Returns the label.
	 * 
	 * @return String
	 */
	public String getLabel() {

		return label_EN;

	}

	public String getMajCode() {
		return majCode;
	}
    
	
	
}
