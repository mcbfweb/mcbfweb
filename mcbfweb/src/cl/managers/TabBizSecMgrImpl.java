package cl.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dao.TabBizSecDAO;
import cl.model.TabBizSec;

@Service
public class TabBizSecMgrImpl implements TabBizSecMgr {

	@Autowired
	private TabBizSecDAO bizSecDAO;

	@Override
	public void insertSec(TabBizSec sector) {
		bizSecDAO.insertSec(sector);

	}

	@Override
	@Transactional
	public TabBizSec getSecById(String secCode) {
		return bizSecDAO.getSecById(secCode);
	}

	@Override
	@Transactional
	public TabBizSec getSector(String secName) {
		return bizSecDAO.getSector(secName);
	}

	@Override
	@Transactional
	public List<TabBizSec> getByMajorSector(String secName) {
		return bizSecDAO.getByMajorSector(secName);
	}

	
	@Override
	@Transactional
	public List<TabBizSec> getSectors() {
		return bizSecDAO.getSectors();
	}

	@Override
	@Transactional
	public void deleteSector(String sector) {
		bizSecDAO.deleteSector(sector);
	}
}
