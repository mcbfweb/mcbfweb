package cl.dao;

import java.util.List;

import cl.errors.UserDoesNotExistError;
import cl.model.User;

public interface AdmUsrDAO {
	
	User loadUserByName(String name);
	
	void insertUser(User user);
	
	void updateUser(User user);

	User getUserById(String client, String userId) throws UserDoesNotExistError;
	
	List <User> getAllUsers();
}
