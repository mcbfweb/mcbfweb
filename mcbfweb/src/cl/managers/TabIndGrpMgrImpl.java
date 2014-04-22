package cl.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dao.TabIndGrpDAO;
import cl.model.TabIndGrp;

@Service
public class TabIndGrpMgrImpl implements TabIndGrpMgr {

	@Autowired
	private TabIndGrpDAO bizSecDAO;

	@Override
	public void insertSec(TabIndGrp sector) {
		bizSecDAO.insertSec(sector);

	}

	@Override
	@Transactional
	public TabIndGrp getSecById(String secCode) {
		return bizSecDAO.getSecById(secCode);
	}

	@Override
	@Transactional
	public TabIndGrp getSector(String secName) {
		return bizSecDAO.getSector(secName);
	}

	@Override
	@Transactional
	public List<TabIndGrp> getByMajorSector(String secName) {
		return bizSecDAO.getByMajorSector(secName);
	}

	
	@Override
	@Transactional
	public List<TabIndGrp> getSectors() {
		return bizSecDAO.getSectors();
	}

	@Override
	@Transactional
	public void deleteSector(String sector) {
		bizSecDAO.deleteSector(sector);
	}
}
