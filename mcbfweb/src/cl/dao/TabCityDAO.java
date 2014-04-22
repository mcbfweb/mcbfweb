package cl.dao;


import java.util.List;

import cl.model.TabCity;

public interface TabCityDAO {

	TabCity getCityById(String ctyCode);
	
	List<TabCity> getCities();
		
}
