package cl.managers;

import cl.errors.UserDoesNotExistError;
import cl.model.User;


public interface UserLoginMgr {
	
	User loadUserByName(String name)throws UserDoesNotExistError;
}
