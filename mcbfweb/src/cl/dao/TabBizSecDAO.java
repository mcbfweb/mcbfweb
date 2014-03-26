package cl.dao;


import java.util.List;

import cl.model.TabBizSec;

public interface TabBizSecDAO {

	void insertSec(TabBizSec user);

	TabBizSec getSecById(String secCode);

	TabBizSec getSector(String secName);
	
	List<TabBizSec> getByMajorSector(String secName);

	List<TabBizSec> getSectors();
	
	void deleteSector(String ecoCode);
}
