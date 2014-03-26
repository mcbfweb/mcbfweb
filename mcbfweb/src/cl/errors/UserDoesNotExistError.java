package cl.errors;

public class UserDoesNotExistError extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDoesNotExistError(String message) {
        super(message);
    }

}
