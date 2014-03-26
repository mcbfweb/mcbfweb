package cl.dao;

import cl.errors.UserDoesNotExistError;
import cl.model.User;

public interface UserLoginDAO {
	
	User loadUserByName (String name) throws UserDoesNotExistError;

}
