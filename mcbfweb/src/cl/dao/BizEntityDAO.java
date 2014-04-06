package cl.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cl.errors.ClientDoesNotExistError;
import cl.model.BizEntInn;
import cl.model.BizEntity;
import cl.model.EntityDetail;

@Transactional
public interface BizEntityDAO {

	List<BizEntInn> loadEntityDetail(String ecoCode, String bizCode);

	void insertEntity(BizEntity entity);

	void insertEntityDetail(EntityDetail entity);

	void updateEntityDetail(EntityDetail entity);

	void deleteEntityDetail(EntityDetail entity);

	int getNextEntityNumber();

	EntityDetail getClientById(int client) throws ClientDoesNotExistError;

	List<EntityDetail> getAllClients();
	List<EntityDetail> getAllClientsByCountry(String country);
	List<EntityDetail> getAllClientsByCountryCity(String country, String city);
}
