package cl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.model.TabIndGrp;

@Service
public class TabIndGrpDAOImpl implements TabIndGrpDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertSec(TabIndGrp sector) {
		sessionFactory.getCurrentSession().save(sector);

	}

	@Override
	public TabIndGrp getSecById(String secCode) {
		return (TabIndGrp) sessionFactory.
				getCurrentSession().
				get(TabIndGrp.class, secCode);
	}

	@Override
	public TabIndGrp getSector(String secName) {
		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from TABINDGRPM0 where GRPDESC = :secName");
		query.setParameter("secName", secName);
		return (TabIndGrp) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabIndGrp> getByMajorSector(String secName) {
		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from TABINDGRPM0 where GRPBIZCDE = :secName");
		query.setParameter("secName", secName);
		return (List<TabIndGrp>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TabIndGrp> getSectors() {
		Criteria criteria = sessionFactory.
				getCurrentSession().
				createCriteria(TabIndGrp.class);
		return criteria.list();
	}

	@Override
	public void deleteSector(String ecoCode) {
		TabIndGrp code = (TabIndGrp) sessionFactory.getCurrentSession().load(
				TabIndGrp.class, ecoCode);
		if (null != code) {
			this.sessionFactory.getCurrentSession().delete(code);
		}

	}

}
