package cl.dao;

import cl.model.BizEntPrd2;

public interface BizEntPrdDAO {

	BizEntPrd2  getPrdById(String client, String prdCode);

}
