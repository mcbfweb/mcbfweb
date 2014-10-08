package cl.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dao.BizEntPrdDAO;
import cl.model.BizEntPrd2;

@Service
public class BizEntPrdMgrImpl implements BizEntPrdMgr {

	@Autowired
	private BizEntPrdDAO bizEntPrd;	

	@Override
	@Transactional
	public BizEntPrd2  getPrdById(String client,  String prdCode) {

		return bizEntPrd.getPrdById(client, prdCode) ;
	}
	
}
