package cl.managers;

import java.util.List;

import cl.model.TabEcoSec;


public interface TabEcoSecMgr {
	
	void insertSec(TabEcoSec user);

	TabEcoSec getSecById(String secCode);

	TabEcoSec getSector(String secName);

	List<TabEcoSec> getSectors();
	
	void deleteSector(String ecoCode);
}
