package cl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.model.TabGen;


/**
 * The Class TabGenDAOImpl
 */
@Service
public class TabGenDAOImpl implements TabGenDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<TabGen> loadAllCodes() {
		Criteria criteria = sessionFactory.
				getCurrentSession().
				createCriteria(TabGen.class);
				
		return criteria.list();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TabGen> loadByDef(String def) {
		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from TABGENM0 where GENDEFTYP = :def");
		query.setParameter("def", def);
		return  query.list();
		
	}
}
