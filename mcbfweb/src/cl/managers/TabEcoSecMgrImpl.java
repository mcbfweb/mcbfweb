package cl.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dao.TabEcoSecDAO;
import cl.model.TabEcoSec;

@Service
public class TabEcoSecMgrImpl implements TabEcoSecMgr {

	@Autowired
	private TabEcoSecDAO ecoSecDAO;

	@Override
	public void insertSec(TabEcoSec sector) {
		ecoSecDAO.insertSec(sector);

	}

	@Override
	@Transactional
	public TabEcoSec getSecById(String secCode) {
		return ecoSecDAO.getSecById(secCode);
	}

	@Override
	@Transactional
	public TabEcoSec getSector(String username) {
		return ecoSecDAO.getSector(username);
	}

	@Override
	@Transactional
	public List<TabEcoSec> getSectors() {
		return ecoSecDAO.getSectors();
	}

	@Override
	@Transactional
	public void deleteSector(String sector) {
		ecoSecDAO.deleteSector(sector);
	}
}
