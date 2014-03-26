package cl.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.errors.UserDoesNotExistError;
import cl.model.EntityDetail;
import cl.model.User;

/**
 * The Class UserLoginDAOImpl
 */
@Service
public class AdmUsrDAOImpl implements AdmUsrDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Override
	public User loadUserByName(String name) {
				
		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from ADMUSRM0 where USRID = :name");
		query.setParameter("name", name);
		return (User) query.list().get(0);

	}

	@Override
	public void insertUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}
	
	@Override
	public User getUserById(String client,  String userid) throws UserDoesNotExistError {

		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from ADMUSRM0 where USRCLIENT = :client and USRID = :userid");
		query.setParameter("userid", userid);
		query.setParameter("client", client);
		
		if(query.list().size() > 0)
		return (User) query.list().get(0);

		throw new UserDoesNotExistError("Did not find user");
	}
	
	@Override
	public List <User> getAllUsers(){

		@SuppressWarnings("unchecked")
		List <User> users = (List <User>) sessionFactory.getCurrentSession().createCriteria(User.class).addOrder(Order.asc("userName")).list();
	
		  return users;
		
		
	}
}
