package cl.managers;

import cl.model.BizEntPrd;

public interface BizEntPrdMgr {

	BizEntPrd getPrdById(String client, String prdCode);

}
