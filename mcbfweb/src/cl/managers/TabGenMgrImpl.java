package cl.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dao.AdmUsrDAO;
import cl.dao.TabGenDAO;
import cl.dao.UserLoginDAO;
import cl.model.TabGen;
import cl.model.User;

@Service
public class TabGenMgrImpl implements TabGenMgr {

	@Autowired
	private TabGenDAO tabGenDAO;

	
	@Override
	@Transactional
	public List<TabGen> loadAllCodes() {
	
		return tabGenDAO.loadAllCodes();
	
	}
	
	@Override
	@Transactional
	public List<TabGen> loadByDef(String def) {
	
		return tabGenDAO.loadByDef(def);
	
	}
	
}
