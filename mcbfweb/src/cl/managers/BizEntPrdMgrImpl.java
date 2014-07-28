package cl.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.dao.BizEntPrdDAO;
import cl.model.BizEntPrd;

@Service
public class BizEntPrdMgrImpl implements BizEntPrdMgr {

	@Autowired
	private BizEntPrdDAO bizEntPrd;	

	@Override
	public BizEntPrd getPrdById(String client,  String prdCode) {

		return bizEntPrd.getPrdById(client, prdCode) ;
	}
	
}
