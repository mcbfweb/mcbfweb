package cl.dao;


import java.util.List;

import cl.model.TabIndustry;

public interface TabIndustryDAO {

	void insertSec(TabIndustry user);

	TabIndustry  getSecById(String secCode);

	TabIndustry  getSector(String secName);
	
	List<TabIndustry> getByMajorSector(String secName);

	List<TabIndustry> getSectors();
	
	void deleteSector(String ecoCode);
}
