package cl.dao;


import java.util.List;

import cl.model.TabIndGrp;

public interface TabIndGrpDAO {

	void insertSec(TabIndGrp user);

	TabIndGrp getSecById(String secCode);

	TabIndGrp getSector(String secName);
	
	List<TabIndGrp> getByMajorSector(String secName);

	List<TabIndGrp> getSectors();
	
	void deleteSector(String ecoCode);
}
