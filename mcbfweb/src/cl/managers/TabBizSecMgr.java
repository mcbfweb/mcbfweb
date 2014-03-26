package cl.managers;

import java.util.List;

import cl.model.TabBizSec;


public interface TabBizSecMgr {
	
	void insertSec(TabBizSec sector);

	TabBizSec getSecById(String secCode);

	TabBizSec getSector(String secName);

	List<TabBizSec> getByMajorSector(String secName);
	
	List<TabBizSec> getSectors();
	
	void deleteSector(String bizCode);
}
