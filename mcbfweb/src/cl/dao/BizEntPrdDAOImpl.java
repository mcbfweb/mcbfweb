package cl.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.model.BizEntPrd;

@Service
public class BizEntPrdDAOImpl implements BizEntPrdDAO {

	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public BizEntPrd getPrdById(String client,  String prdCode) {

		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from BIZENTPRDM0 where PRDENTITY = :client and PRDCODE = :prdCode");
		query.setParameter("prdCode", prdCode);
		query.setParameter("client", client);
		
		if(query.list().size() > 0)
		 return (BizEntPrd) query.list().get(0);

		return null;
	}
	
}
