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
	public int getNextEntityNumber(){
	
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
}
