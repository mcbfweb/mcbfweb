package cl.managers;


import java.util.List;

import cl.model.TabState;

public interface TabStateMgr {

	TabState getStateById(String staCode);
	
	List<TabState> getStates();
		
}
