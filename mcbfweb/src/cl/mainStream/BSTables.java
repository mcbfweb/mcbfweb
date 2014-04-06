/*
 * 
 * 19/05/03 - Fred
 * added table names as constant string according to "SaudiCB Master Tables.doc"
 * 
 * NIMR_B19+ issue 4990 added the table SALARY_FLAG
 * 
 * NIMR_B23+ issue 5035 moved pseudo-tables from request to session
 * 
 * NIMR_B28+ issue 5144 replaced table INDACCSCC with INDACCSEC
 * 
 * NIMR_B77+ Issue 6166 added ENQADVMSG table
 * 
 * NIMR_B87+ PVO 33
 * Added Member Type Table ADMACCTYP
 * 
 *  Anil -12/08/2009 - Added Region and Cities table for combo boxes
 */
package cl.mainStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import joptsimple.util.KeyValuePair;

import org.springframework.context.ApplicationContext;
import org.w3c.dom.Element;

import cl.mainStream.ServiceNames;
import cl.mainStream.UserState;
import cl.managers.BizEntityMgr;
import cl.managers.TabBizSecMgr;
import cl.managers.TabEcoSecMgr;
import cl.managers.TabGenMgr;
import cl.model.BizEntity;
import cl.model.EntityDetail;
import cl.model.TabBizSec;
import cl.model.TabEcoSec;
import cl.model.TabGen;

/**
 * BSTables extracts tables of user options from a BureauStream XML response,
 * and caches them in the ServletContext object so that JSP pages can display
 * them in &lt;html:options> tags
 * 
 * @version 1.0
 * @author Brian Cahill
 */
public class BSTables implements ServiceNames {

	// table names
	// each table name corresponds to a XML tag name

	public final static String CLIENTS_LIST = "CLIENTS";
	public final static String ECONOMIC_SECTOR = "TABECOSEC";
	public final static String BUSINESS_SECTOR = "TABBIZSEC";
	// public final static String TABGEN = "TABGEN";
	public final static String MARITAL_STATUS = "MARSTS";

	public final static String IND_ID_TYPE = "INDIDTYP";
	public final static String OCC_TYPE = "OCCTYP";
	public final static String BIZ_ID_TYPE = "BIZIDTYP";
	public final static String CNT_NUM_TYP = "CNTNUMTYP";
	public final static String SEC_AUTH = "SECAT";
	public final static String ACC_STS = "INDACCCON";
	public final static String USR_GRP = "USRGRP";
	public final static String ISD_CDE = "ISDCDE";
	public final static String ADR_TYPE = "ADRTYP";
	private static BSTables bSTables = null;

	public static final String[] applicationTables = new String[] {

		    CLIENTS_LIST,
			ECONOMIC_SECTOR, // "TABECOSEC";
			BUSINESS_SECTOR, // "TABBIZSEC";
			MARITAL_STATUS,
			IND_ID_TYPE,
			OCC_TYPE,
			BIZ_ID_TYPE,
			CNT_NUM_TYP,
			SEC_AUTH,
			ACC_STS,
			USR_GRP,
			ISD_CDE,
			ADR_TYPE
	};

	private HashMap<String, List<BSOption>> englishTables;

	private BSTables() {
	}

	/**
	 * Singleton accessor for the BSTables object.
	 * 
	 * @return BSTables
	 */
	public static BSTables instance() {
		if (bSTables == null) {
			bSTables = new BSTables();
		}

		return (bSTables);
	}

	/**
	 * Loads all the tables for drop-down lists from the server.
	 * 
	 * @throws BSException
	 *             if there is a server error loading a table.
	 */
	public void loadApplicationTables(ApplicationContext ctx, ServletContextEvent sce) throws BSException {
		englishTables = new HashMap<String, List<BSOption>>();

		StringBuffer failedTables = new StringBuffer();
		failedTables.append("ERROR loading tables: ");
		boolean tableFailed = false;

		for (int idx = 0; idx < applicationTables.length; ++idx) {
			try {
				addTable(englishTables, applicationTables[idx], ctx, sce);

			} catch (BSException x) {
				failedTables.append(applicationTables[idx]);
				failedTables.append(", ");
				tableFailed = true;
			}
		}

		if (tableFailed) {
			throw new BSException(failedTables.toString());
		}
	}

	/**
	 * Gets a English or Arabic table (depending on <code>language</code> for a
	 * drop-down list.
	 * 
	 * @param tableName
	 * @param language
	 * @return BSOption[]
	 */
	public List<BSOption> getTable(String tableName, String language) {

		return ((List<BSOption>) englishTables.get(tableName));

	}

	private void addTable(HashMap<String, List<BSOption>> englishTables, String tableName, ApplicationContext ctx, ServletContextEvent sce)
			throws BSException {
		if (CLIENTS_LIST.equalsIgnoreCase(tableName)){
			BizEntityMgr manager =
					(BizEntityMgr) ctx.getBean("bizEntityMgrImpl");
			List<EntityDetail> clients = manager.getAllClients();
			System.out.println(clients.size());
			sce.getServletContext().setAttribute(tableName, clients);
			sce.getServletContext().setAttribute("ENTITY_DETAIL_LIST", clients);
			
			
			//Map<String,String> clientArry = new HashMap<String,String>();
			List<String> clientArry =new ArrayList<String>();
			
			for(EntityDetail e: clients){
				if( e.getBizName() != null && e.getBizName().trim().length() > 0 && !e.getBizName().equalsIgnoreCase("null"))
				clientArry.add(e.getBizName());	
			}
			System.out.println(clientArry.size());
			sce.getServletContext().setAttribute("CLIENT_LIST", clientArry);
		}
		
		if (ECONOMIC_SECTOR.equalsIgnoreCase(tableName)) {
			TabEcoSecMgr manager =
					(TabEcoSecMgr) ctx.getBean("tabEcoSecMgrImpl");
			List<TabEcoSec> ecoSectors = manager.getSectors();
			// BSOption[] options = new BSOption[ecoSectors.size()];
			List<BSOption> bizGroupArry = new ArrayList<BSOption>();
			System.out.println("\nEcoSector list fetched!"
					+ "\nSector count: " + ecoSectors.size());
			int i = 0;
			for (TabEcoSec ecoSector : ecoSectors) {
				bizGroupArry.add(new BSOption(ecoSector.getEcoCode(), ecoSector.getEcoDesc(), ""));
			}

			englishTables.put(tableName, bizGroupArry);
		}

		if (BUSINESS_SECTOR.equalsIgnoreCase(tableName)) {
			TabBizSecMgr manager =
					(TabBizSecMgr) ctx.getBean("tabBizSecMgrImpl");
			List<TabBizSec> bizSectors = manager.getSectors();
			// BSOption[] options = new BSOption[ecoSectors.size()];
			List<BSOption> bizArry = new ArrayList<BSOption>();
			System.out.println("\nEcoSector list fetched!"
					+ "\nSector count: " + bizSectors.size());

			for (TabBizSec bizSector : bizSectors) {
				bizArry.add(new BSOption(bizSector.getBizCode(), bizSector.getBizDesc(), bizSector.getBizEcoCde()));
			}

			englishTables.put(tableName, bizArry);
		}

		//TABGEN Tables 
		if (!BUSINESS_SECTOR.equalsIgnoreCase(tableName) && !ECONOMIC_SECTOR.equalsIgnoreCase(tableName)) {
			TabGenMgr manager =
					(TabGenMgr) ctx.getBean("tabGenMgrImpl");
			List<TabGen> tabGen = manager.loadByDef(tableName);
			//List<TabGen> tabGen = manager.loadAllCodes();
			List<BSOption> tabGenArry = new ArrayList<BSOption>();
			

			System.out.println("\nTabGen list fetched!"
					+ "\nCode count: " + tabGen.size());

			for (TabGen defs : tabGen) {
				System.out.println(defs.getGenCodId() + "  " + defs.getGenDesc());
			  	tabGenArry.add(new BSOption(defs.getGenCodId(), defs.getGenDesc(), ""));				

			}

			englishTables.put(tableName, tabGenArry);
		}

	}

	/**
	 * Cache the required tables in the user's session.
	 * 
	 * @param request
	 *            Contains the user's logon name and session object
	 * @param Array
	 *            of required table names
	 */
	public void getTables(HttpServletRequest request, String[] requiredTables) throws BSException {
		String user = request.getRemoteUser();
		HttpSession session = request.getSession();
		UserState userState = (UserState) request.getSession().getAttribute("userState");

		// for each required table
		for (int idx = 0; idx < requiredTables.length; ++idx) {
			String tableName = requiredTables[idx];

			// special case - "live" table
			/*
			 * if (TRANSACTION_CODE.equals(tableName)) {
			 * //session.setAttribute(tableName, getTableFromServer(tableName,
			 * null)); continue; }
			 */

			if (tableName.trim().length() > 0) {

				session.setAttribute(tableName, getTable(tableName, userState.getPreferredLanguage()));

			}
		}
	}

}