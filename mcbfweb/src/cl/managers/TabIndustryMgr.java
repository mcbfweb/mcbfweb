package cl.managers;

import java.util.List;

import cl.model.TabIndustry;


public interface TabIndustryMgr {
	
	void insertSec(TabIndustry sector);

	TabIndustry getSecById(String secCode);

	TabIndustry getSector(String secName);

	List<TabIndustry> getByMajorSector(String secName);
	
	List<TabIndustry> getSectors();
	
	void deleteSector(String bizCode);
}
