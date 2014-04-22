package cl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.model.TabCity;

@Service
public class TabCityDAOImpl implements TabCityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public TabCity getCityById(String ctyCode) {
		return (TabCity) sessionFactory.getCurrentSession().get(TabCity.class, ctyCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabCity> getCities() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TabCity.class);
		return criteria.list();
	}

}
