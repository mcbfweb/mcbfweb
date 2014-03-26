package cl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.model.TabEcoSec;

@Service
public class TabEcoSecDAOImpl implements TabEcoSecDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertSec(TabEcoSec sector) {
		sessionFactory.getCurrentSession().save(sector);

	}

	@Override
	public TabEcoSec getSecById(String secCode) {
		return (TabEcoSec) sessionFactory.
				getCurrentSession().
				get(TabEcoSec.class, secCode);
	}

	@Override
	public TabEcoSec getSector(String secName) {
		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from TABECOSECM0 where ECODESC = :secName");
		query.setParameter("secName", secName);
		return (TabEcoSec) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabEcoSec> getSectors() {
		Criteria criteria = sessionFactory.
				getCurrentSession().
				createCriteria(TabEcoSec.class);
		return criteria.list();
	}

	@Override
	public void deleteSector(String ecoCode) {
		TabEcoSec code = (TabEcoSec) sessionFactory.getCurrentSession().load(
				TabEcoSec.class, ecoCode);
		if (null != code) {
			this.sessionFactory.getCurrentSession().delete(code);
		}

	}

}
