package cl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.model.TabBizSec;

@Service
public class TabBizSecDAOImpl implements TabBizSecDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertSec(TabBizSec sector) {
		sessionFactory.getCurrentSession().save(sector);

	}

	@Override
	public TabBizSec getSecById(String secCode) {
		return (TabBizSec) sessionFactory.
				getCurrentSession().
				get(TabBizSec.class, secCode);
	}

	@Override
	public TabBizSec getSector(String secName) {
		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from TABBIZSECM0 where BIZDESC = :secName");
		query.setParameter("secName", secName);
		return (TabBizSec) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabBizSec> getByMajorSector(String secName) {
		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from TABBIZSECM0 where BIZECOCDE = :secName");
		query.setParameter("secName", secName);
		return (List<TabBizSec>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TabBizSec> getSectors() {
		Criteria criteria = sessionFactory.
				getCurrentSession().
				createCriteria(TabBizSec.class);
		return criteria.list();
	}

	@Override
	public void deleteSector(String ecoCode) {
		TabBizSec code = (TabBizSec) sessionFactory.getCurrentSession().load(
				TabBizSec.class, ecoCode);
		if (null != code) {
			this.sessionFactory.getCurrentSession().delete(code);
		}

	}

}
