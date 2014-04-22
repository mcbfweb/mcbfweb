package cl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.model.TabIndustry;

@Service
public class TabIndustryDAOImpl implements TabIndustryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertSec(TabIndustry sector) {
		sessionFactory.getCurrentSession().save(sector);

	}

	@Override
	public TabIndustry getSecById(String secCode) {
		return (TabIndustry) sessionFactory.
				getCurrentSession().
				get(TabIndustry.class, secCode);
	}

	@Override
	public TabIndustry getSector(String secName) {
		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from TABINDUSTRYM0 where INDDESC = :secName");
		query.setParameter("secName", secName);
		return (TabIndustry) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabIndustry> getByMajorSector(String secName) {
		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from TABINDUSTRYM0 where INDGRPCDE = :secName");
		query.setParameter("secName", secName);
		return (List<TabIndustry>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TabIndustry> getSectors() {
		Criteria criteria = sessionFactory.
				getCurrentSession().
				createCriteria(TabIndustry.class);
		return criteria.list();
	}

	@Override
	public void deleteSector(String ecoCode) {
		TabIndustry code = (TabIndustry) sessionFactory.getCurrentSession().load(
				TabIndustry.class, ecoCode);
		if (null != code) {
			this.sessionFactory.getCurrentSession().delete(code);
		}

	}

}
