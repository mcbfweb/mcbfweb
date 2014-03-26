package cl.managers;

import java.util.List;

import cl.model.TabGen;

public interface TabGenMgr {
	
	List<TabGen> loadAllCodes();
	
	List<TabGen> loadByDef(String def);
}
