package cl.dao;


import java.util.List;

import cl.model.TabEcoSec;

public interface TabEcoSecDAO {

	void insertSec(TabEcoSec user);

	TabEcoSec getSecById(String secCode);

	TabEcoSec getSector(String secName);

	List<TabEcoSec> getSectors();
	
	void deleteSector(String ecoCode);
}
