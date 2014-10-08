package cl.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.model.BizEntPrd2;

@Service
@Transactional
public class BizEntPrdDAOImpl implements BizEntPrdDAO {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public BizEntPrd2 getPrdById(String client,  String prdCode) {

		Query query = sessionFactory.
				getCurrentSession().
				//createQuery("from BIZENTPRDM0 where PRDENTITY = :entity and PRDCODE = :prdCode");
				createQuery("from BizEntPrd2 where PRDENTITY = :entity and PRDCODE = :prdCode");
		query.setParameter("prdCode", prdCode);
		query.setParameter("entity", client);
		
		if(query.list().size() > 0)
		 return (BizEntPrd2) query.list().get(0);

		return null;
	}
	
}
