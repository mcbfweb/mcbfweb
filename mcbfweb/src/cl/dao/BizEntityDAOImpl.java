package cl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.errors.ClientDoesNotExistError;
import cl.errors.UserDoesNotExistError;
import cl.model.BizEntInn;
import cl.model.BizEntity;
import cl.model.EntityDetail;
import cl.model.TabBizSec;
import cl.model.User;

/**
 * The Class UserLoginDAOImpl
 */
@Service
@Transactional
public class BizEntityDAOImpl implements BizEntityDAO {

	@Autowired(required = false)
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public List<BizEntInn> loadEntityDetail(String ecoCode, String bizCode) {

		return fetchEntityDetail(ecoCode, bizCode);

	}

	@SuppressWarnings("unchecked")
	public List<BizEntInn> fetchEntityDetail(String ecoCode, String bizCode) {
		DetachedCriteria subCriteria = DetachedCriteria
				.forClass(BizEntity.class);
		subCriteria.add(Property.forName("ecoCode").eq(ecoCode));
		subCriteria.add(Property.forName("bizCode").eq(bizCode));

		subCriteria.setProjection(Projections.property("entity"));

		DetachedCriteria criteria = DetachedCriteria.forClass(BizEntInn.class);
		criteria.add(Property.forName("entity").in(subCriteria));
		return criteria.getExecutableCriteria(
				sessionFactory.getCurrentSession()).list();

	}

	@Override
	public void insertEntity(BizEntity entity) {
		sessionFactory.getCurrentSession().save(entity);

	}

	@Override
	public void insertEntityDetail(EntityDetail entity) {
		sessionFactory.getCurrentSession().save(entity);

	}

	@Override
	public void updateEntityDetail(EntityDetail entity) {
		sessionFactory.getCurrentSession().update(entity);

	}

	@Override
	public void deleteEntityDetail(EntityDetail entity) {
		sessionFactory.getCurrentSession().delete(entity);

	}

	@Override
	public int getNextEntityNumber() {

		DetachedCriteria maxId = DetachedCriteria.forClass(EntityDetail.class)
				.setProjection(Projections.max("entity"));
		@SuppressWarnings("unchecked")
		List<EntityDetail> results = sessionFactory.getCurrentSession()
				.createCriteria(EntityDetail.class)
				.add(Property.forName("entity").eq(maxId)).list();

		try {
			if (results.get(0) == null)
				return 1;
		} catch (Exception e) {

			e.printStackTrace();
			return 1;
		}

		EntityDetail max = (EntityDetail) results.get(0);

		return max.getEntity() + 1;
	}

	@Override
	public EntityDetail getClientById(int clientId)
			throws ClientDoesNotExistError {

		@SuppressWarnings("unchecked")
		List<EntityDetail> clients = (List<EntityDetail>) sessionFactory
				.getCurrentSession().createCriteria(EntityDetail.class)
				.add(Restrictions.eq("entity", clientId))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		
		if (clients != null)
			return clients.get(0);

		throw new ClientDoesNotExistError("Did not find client id");

	}

	@Override
	public List<EntityDetail> getAllClients() {

		@SuppressWarnings("unchecked")
		List<EntityDetail> clients = (List<EntityDetail>) sessionFactory
				.getCurrentSession().createCriteria(EntityDetail.class)
				.addOrder(Order.asc("ctry"))
				.addOrder(Order.asc("ctry"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return clients;

	}
	
	@Override
	public List<EntityDetail> getAllClientsByCountry(String country) {

		@SuppressWarnings("unchecked")
		List<EntityDetail> clients = (List<EntityDetail>) sessionFactory
				.getCurrentSession().createCriteria(EntityDetail.class)
				.add( Restrictions.like("ctry", country))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return clients;

	}
	
	@Override
	public List<EntityDetail> getAllClientsByCountryCity(String country, String city) {

		@SuppressWarnings("unchecked")
		List<EntityDetail> clients = (List<EntityDetail>) sessionFactory
				.getCurrentSession().createCriteria(EntityDetail.class)
				.add( Restrictions.like("ctry", country))
				.add( Restrictions.like("addresses.adrCity", city))				
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return clients;

	}
}
