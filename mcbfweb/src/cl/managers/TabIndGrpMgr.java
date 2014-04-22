package cl.managers;

import java.util.List;

import cl.model.TabIndGrp;


public interface TabIndGrpMgr {
	
	void insertSec(TabIndGrp sector);

	TabIndGrp getSecById(String secCode);

	TabIndGrp getSector(String secName);

	List<TabIndGrp> getByMajorSector(String secName);
	
	List<TabIndGrp> getSectors();
	
	void deleteSector(String bizCode);
}
