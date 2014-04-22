package cl.managers;

import java.util.List;

import cl.errors.ClientDoesNotExistError;
import cl.model.BizEntInn;
import cl.model.BizEntity;
import cl.model.EntityDetail;
import cl.model.EntityListDetail;

public interface BizEntityMgr {

	List<BizEntInn> loadEntityDetail(String ecoCode, String bizCode);

	void insertEntity(BizEntity entity);

	void insertEntityDetail(EntityDetail entity);

	void updateEntityDetail(EntityDetail entity);

	void deleteEntityDetail(EntityDetail entity);

	Integer getNextEntityNumber();

	EntityDetail getClientById(int client) throws ClientDoesNotExistError;

	List<EntityDetail> getAllClients();
	List<EntityListDetail>  getListClients();
	List<EntityDetail> getAllClientsByCountry(String country);
	List<EntityDetail> getAllClientsByCountryCity(String country, String city);
	
	Integer getNextAdrDtaid();
	Integer getNextInnDtaid();
	Integer getNextIdDtaid();
	Integer getNextCntDtaid();
}
