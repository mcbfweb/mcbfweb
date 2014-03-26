package cl.dao;

import java.util.List;

import cl.model.TabGen;


public interface TabGenDAO {
	
	List<TabGen> loadAllCodes();
	
	List<TabGen> loadByDef(String def);

}
