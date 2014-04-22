package cl.managers;


import java.util.List;

import cl.model.TabCity;

public interface TabCityMgr {

	TabCity getCityById(String ctyCode);
	
	List<TabCity> getCities();
		
}
