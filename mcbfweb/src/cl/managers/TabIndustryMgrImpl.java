package cl.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dao.TabIndustryDAO;
import cl.model.TabIndustry;

@Service
public class TabIndustryMgrImpl implements TabIndustryMgr {

	@Autowired
	private TabIndustryDAO bizSecDAO;

	@Override
	public void insertSec(TabIndustry sector) {
		bizSecDAO.insertSec(sector);

	}

	@Override
	@Transactional
	public TabIndustry getSecById(String secCode) {
		return bizSecDAO.getSecById(secCode);
	}

	@Override
	@Transactional
	public TabIndustry getSector(String secName) {
		return bizSecDAO.getSector(secName);
	}

	@Override
	@Transactional
	public List<TabIndustry> getByMajorSector(String secName) {
		return bizSecDAO.getByMajorSector(secName);
	}

	
	@Override
	@Transactional
	public List<TabIndustry> getSectors() {
		return bizSecDAO.getSectors();
	}

	@Override
	@Transactional
	public void deleteSector(String sector) {
		bizSecDAO.deleteSector(sector);
	}
}
