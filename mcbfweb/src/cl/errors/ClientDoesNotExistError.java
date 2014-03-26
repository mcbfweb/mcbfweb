package cl.errors;

public class ClientDoesNotExistError extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientDoesNotExistError(String message) {
        super(message);
    }

}
