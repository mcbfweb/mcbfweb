package cl.dao;

import cl.model.BizEntPrd;

public interface BizEntPrdDAO {

	BizEntPrd getPrdById(String client, String prdCode);

}
