package cl.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dao.TabCityDAO;
import cl.model.TabCity;

@Service
public class TabCityMgrImpl implements TabCityMgr {

	@Autowired
	private TabCityDAO tabCityDAO;

	@Override
	@Transactional
	public TabCity getCityById(String ctyCode) {
		
		return tabCityDAO.getCityById(ctyCode);
	}
	
	@Override
	@Transactional
	public List<TabCity> getCities() {
		return tabCityDAO.getCities();
	}

}
