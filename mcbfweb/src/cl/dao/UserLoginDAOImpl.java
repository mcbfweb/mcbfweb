package cl.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.errors.UserDoesNotExistError;
import cl.model.User;

/**
 * The Class UserLoginDAOImpl
 */
@Service
public class UserLoginDAOImpl implements UserLoginDAO {

	
	@Autowired(required = false)
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	//@Autowired
	//private SessionFactory sessionFactoryB;

	
	@Override
	public User loadUserByName(String name) throws UserDoesNotExistError {

		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from ADMUSRM0 where USRID = :name");
		query.setParameter("name", name);

		if (query.list().size() > 0)
			return (User) query.list().get(0);

		throw new UserDoesNotExistError("Did not find user");
	}

	

}
