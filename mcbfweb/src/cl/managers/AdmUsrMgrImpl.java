package cl.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dao.AdmUsrDAO;
import cl.dao.UserLoginDAO;
import cl.errors.UserDoesNotExistError;
import cl.model.User;

@Service
public class AdmUsrMgrImpl implements AdmUsrMgr {

	@Autowired
	private AdmUsrDAO admUsrDAO;

	@Override
	@Transactional
	public User loadUserByName(String name) {
	
		return admUsrDAO.loadUserByName(name);
	
	}
	
	@Override
	@Transactional
	public User getUserById(String client, String userid) throws UserDoesNotExistError{
	
		return admUsrDAO.getUserById(client, userid) ;
	
	}
	
	@Override
	@Transactional
	public void insertUser(User user) {
	
		admUsrDAO.insertUser(user);
	
	}
	
	@Override
	@Transactional
	public void updateUser(User user) {
	
		admUsrDAO.updateUser(user);
	
	}
	@Override
	@Transactional
	public List <User> getAllUsers(){
		
		return admUsrDAO.getAllUsers();
	}
}
