package cl.dao;


import java.util.List;

import cl.model.TabState;

public interface TabStateDAO {

	TabState getStateById(String staCode);
	
	List<TabState> getStates();
		
}
