package cl.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dao.UserLoginDAO;
import cl.errors.UserDoesNotExistError;
import cl.model.User;

@Service
public class UserLoginMgrImpl implements UserLoginMgr {

	@Autowired
	private UserLoginDAO userLoginDAO;

	@Override
	@Transactional
	public User loadUserByName(String name) throws UserDoesNotExistError {
	
		return userLoginDAO.loadUserByName(name);
	
	}
	
}
