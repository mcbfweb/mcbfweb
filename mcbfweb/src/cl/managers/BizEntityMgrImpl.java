package cl.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dao.BizEntityDAO;
import cl.errors.ClientDoesNotExistError;
import cl.model.BizEntInn;
import cl.model.BizEntity;
import cl.model.EntityDetail;
import cl.model.EntityListDetail;

@Service
public class BizEntityMgrImpl implements BizEntityMgr {

	@Autowired
	private BizEntityDAO bizEntityDAO;

	@Override
	@Transactional
	public List<BizEntInn> loadEntityDetail(String ecoCode, String bizCode) {

		return bizEntityDAO.loadEntityDetail(ecoCode, bizCode);

	}

	@Override
	@Transactional
	public void insertEntity(BizEntity entity) {
	
		bizEntityDAO.insertEntity(entity);
	
	}
	
	@Override
	@Transactional
	public void insertEntityDetail(EntityDetail entity){
	
		bizEntityDAO.insertEntityDetail(entity);
	
	}
	
	@Override
	@Transactional
	public void updateEntityDetail(EntityDetail entity){
	
		bizEntityDAO.updateEntityDetail(entity);
	
	}
	@Override
	@Transactional
	public void deleteEntityDetail(EntityDetail entity){
	
		bizEntityDAO.deleteEntityDetail(entity);
	
	}
	
	@Override
	@Transactional
	public Integer getNextEntityNumber(){
	
		return bizEntityDAO.getNextEntityNumber();
	
	}
	
	@Override
	@Transactional
	public EntityDetail getClientById(int client) throws ClientDoesNotExistError{
	
		return bizEntityDAO.getClientById(client);
	
	}
	
	@Override
	@Transactional
	public  List <EntityDetail> getAllClients() {
	
		return bizEntityDAO.getAllClients();
	
	}
	
	@Override
	@Transactional
	public  List <EntityListDetail> getListClients() {
	
		return bizEntityDAO.getListClients();
	
	}
	
	@Override
	@Transactional
	public  List <EntityDetail> getAllClientsByCountry(String country) {
	
		return bizEntityDAO.getAllClientsByCountry(country);
	
	}
	@Override
	@Transactional
	public  List <EntityDetail> getAllClientsByCountryCity(String country, String city) {
	
		return bizEntityDAO.getAllClientsByCountryCity(country, city);
	
	}
	
	public Integer getNextAdrDtaid() {
	
		return bizEntityDAO.getNextAdrDtaid();
	
	}
	public Integer getNextInnDtaid(){
	
		return bizEntityDAO.getNextInnDtaid();
	
	}
	public Integer getNextIdDtaid(){
	
		return bizEntityDAO.getNextIdDtaid();
	
	}
	public Integer getNextCntDtaid(){
	
		return bizEntityDAO.getNextCntDtaid();
	
	}
}
