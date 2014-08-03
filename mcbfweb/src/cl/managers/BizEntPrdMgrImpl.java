package cl.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dao.BizEntPrdDAO;
import cl.model.BizEntPrd;

@Service
public class BizEntPrdMgrImpl implements BizEntPrdMgr {

	@Autowired
	private BizEntPrdDAO bizEntPrd;	

	@Override
	@Transactional
	public BizEntPrd getPrdById(int client,  int prdCode) {

		return bizEntPrd.getPrdById(client, prdCode) ;
	}
	
}
