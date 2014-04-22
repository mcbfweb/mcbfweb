package cl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.model.TabState;

@Service
public class TabStateDAOImpl implements TabStateDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public TabState getStateById(String staCode) {
		return (TabState) sessionFactory.getCurrentSession().get(TabState.class, staCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabState> getStates() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TabState.class);
		return criteria.list();
	}

}
