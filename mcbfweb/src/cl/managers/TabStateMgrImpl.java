package cl.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dao.TabStateDAO;
import cl.model.TabState;

@Service
public class TabStateMgrImpl implements TabStateMgr {

	@Autowired
	private TabStateDAO tabStateDAO;

	@Override
	@Transactional
	public TabState getStateById(String staCode) {
		
		return tabStateDAO.getStateById(staCode);
	}
	
	@Override
	@Transactional
	public List<TabState> getStates() {
		return tabStateDAO.getStates();
	}

}
