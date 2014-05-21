package cl.actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;

import cl.mainStream.VedaConstants;
import cl.managers.BizEntityMgr;
import cl.model.BizEntAdr;
import cl.model.BizEntCnt;
import cl.model.BizEntId;
import cl.model.BizEntInn;
import cl.model.BizEntSrv;
import cl.model.EntityDetail;

import com.mcbf.REQUEST;
import com.mcbf.REQUEST.MESSAGE.ENTITIES;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.ADDRESSES;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.ADDRESSES.ADDRESS;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.CONTACTS;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.CONTACTS.CONTACT;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.IDS;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.IDS.ID;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.NAMES;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.NAMES.NAME;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.SERVICES;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.SERVICES.SERVICE;

@ParentPackage(value = "default")
@Namespace("/Data")
@ResultPath(value = "/")
@InterceptorRefs({ @InterceptorRef("loginStack"),

})
public class FileUploadAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private BizEntityMgr manager;
	private ApplicationContext ctx;
	private EntityDetail entity;
	private UserDetails usrd;
	private Date current;
	private Integer entid;
	private Integer innDatid;
	private Integer idDatid;
	private Integer adrDatid;
	private Integer cntDatid;
	private Integer srvDatid;

	private File fileUpload;
	private String fileUploadFileName;
	private String fileUploadContentType;

	@SkipValidation
	@Override
	@Action(value = "LoadData", results = { @Result(name = "success", location = "/user/pages/login_m.jsp"),
			@Result(name = "input", location = "/data/upload/fileUpload.jsp"),
			@Result(name = "error", location = "pages/error.jsp") })
	public String execute() {

		return INPUT;
	}

	public String uploadFile() throws Exception {
		// File saveFilePath = new File("C:/Upload/" + fileUploadFileName);
		// MultiPartRequestWrapper multiWrapper = (MultiPartRequestWrapper)
		// ServletActionContext.getRequest();
		// Enumeration fileParameterNames =
		// multiWrapper.getFileParameterNames();
		System.out.println("File Name is:" + getFileUploadFileName());
		System.out.println("File ContentType is:" + getFileUploadContentType());

		try {
			String uploadPath = (String) getServletContex().getAttribute("FTP_UPLOAD");
			this.ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");
			manager = (BizEntityMgr) ctx.getBean("bizEntityMgrImpl");
			entid = manager.getNextEntityNumber();
			this.manager = (BizEntityMgr) ctx.getBean("bizEntityMgrImpl");
			this.entity = (EntityDetail) ctx.getBean("entityDetail");
			usrd = (UserDetails) getSession().get(VedaConstants.USER_KEY);
			current = new Date();

			File file = new File(uploadPath + "/" + getFileUploadFileName().trim());
			try {
				FileUtils.copyFile(fileUpload, file);
			} catch (IOException ex) {
				System.out.println("Couldn't save file: " + ex.getMessage());
			}

			JAXBContext jaxbContext = JAXBContext.newInstance(REQUEST.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			REQUEST request = (REQUEST) jaxbUnmarshaller.unmarshal(file);
			REQUEST.HEADER header = (REQUEST.HEADER) request.headerOrMESSAGE.get(0);
			REQUEST.MESSAGE message = (REQUEST.MESSAGE) request.headerOrMESSAGE.get(1);

			if (header.getACTION().equalsIgnoreCase("A") && header.getSERVICE().equalsIgnoreCase("CLIENT")) {

				List<ENTITIES> entities = message.getENTITIES();

				for (int i = 0; i < entities.size(); i++) {
					@SuppressWarnings("unchecked")
					REQUEST.MESSAGE.ENTITIES ent2 = (REQUEST.MESSAGE.ENTITIES) entities.get(i);
					List<ENTITY> ent = ent2.getENTITY();
					// writeEntity();
					for (int j = 0; j < ent.size(); j++) {
						entity.setBizCode(ent.get(j).getITYBIZCODE());
						entity.setCtry(ent.get(j).getITYCTRY());
						entity.setEcoCode(ent.get(j).getITYECOCODE());
						entity.setGrpCode(ent.get(j).getITYGRPCODE());
						entity.setIndCode(ent.get(j).getITYINDCODE());
						entity.setBizCode(ent.get(j).getITYBIZCODE());
						entity.setLocLat(ent.get(j).getITYLOCLAT());
						entity.setLocLon(ent.get(j).getITYLOCLON());
						entity.setEntTyp(ent.get(j).getITYENTTYP());
						entity.setEntity(entid);
						entity.setCrtByUser(usrd.getUsername());
						entity.setCrtDate(current);
						entity.setChgByUser(usrd.getUsername());
						entity.setChgDate(current);
						entity.setVersion(1);
						
						List<ADDRESSES> addresses = ent.get(j).getADDRESSES();
						writeAddress(addresses);
						List<CONTACTS> contacts = ent.get(j).getCONTACTS();
						writeContact(contacts);
						List<SERVICES> services = ent.get(j).getSERVICES();
						writeServices(services);
						List<NAMES> names = ent.get(j).getNAMES();
						writeNames(names);
						List<IDS> ids = ent.get(j).getIDS();
						writeIds(ids);
					}

				}

				// add
				manager.insertEntityDetail(entity);

			}

			System.out.println(header.service);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;

	}

	
	private void writeAddress(List<ADDRESSES> addresses) {

		Integer adrDatid = manager.getNextAdrDtaid();
		usrd = (UserDetails) getSession().get(VedaConstants.USER_KEY);
		current = new Date();
		List<BizEntAdr> addrs = new ArrayList<BizEntAdr>();
		for (int i = 0; i < addresses.size(); i++) {

			List<ADDRESS> address = (List<ADDRESS>) addresses.get(i).getADDRESS();
			BizEntAdr adr = new BizEntAdr();
			for (int j = 0; j < address.size(); j++) {
				System.out.println(address.get(j).getADRPSTCDE());
				adr.setEntity(entid);
				adr.setDatid(adrDatid++);
				adr.setCrtDate(current);
				adr.setCrtByUser(usrd.getUsername());
				adr.setAdrAptNo(address.get(j).getADRAPTNO());
				adr.setAdrBldg(address.get(j).getADRBLDG());
				adr.setAdrCity(address.get(j).getADRCITY());
				adr.setAdrCtry(address.get(j).getADRCTRY());
				adr.setAdrFlr(address.get(j).getADRFLR());
				adr.setAdrLine1(address.get(j).getADRLINE1());
				adr.setAdrLine2(address.get(j).getADRLINE2());
				adr.setAdrLine3(address.get(j).getADRLINE3());
				adr.setAdrPstCde(address.get(j).getADRPSTCDE());
				adr.setAdrState(address.get(j).getADRSTATE());
				adr.setAdrstrNm(address.get(j).getADRSTRNM());
				adr.setAdrStrtNo(address.get(j).getADRSTRTNO());
				adr.setAdrTyp(address.get(j).getADRTYP());
				adr.setVersion(1);
				addrs.add(adr);
			}

		}
		
		entity.setAddresses(addrs);
	}

	private void writeContact(List<CONTACTS> contacts) {

		Integer cntDatid = manager.getNextCntDtaid();
		usrd = (UserDetails) getSession().get(VedaConstants.USER_KEY);
		current = new Date();
		List<BizEntCnt> conts = new ArrayList<BizEntCnt>();
		for (int i = 0; i < contacts.size(); i++) {

			List<CONTACT> contact = (List<CONTACT>) contacts.get(i).getCONTACT();
			BizEntCnt cnt = new BizEntCnt();
			for (int j = 0; j < contact.size(); j++) {
				System.out.println(contact.get(j).getCNTAREACDE());
				cnt.setEntity(entid);
				cnt.setDatid(cntDatid++);
				cnt.setCrtDate(current);
				cnt.setCrtByUser(usrd.getUsername());
				cnt.setCntAreaCde(contact.get(j).getCNTAREACDE());
				cnt.setCntEmail(contact.get(j).getCNTEMAIL());
				cnt.setCntIsdCde(contact.get(j).getCNTISDCDE());
				cnt.setCntName(contact.get(j).getCNTNAME());
				cnt.setCntPhnNo(contact.get(j).getCNTPHNNO());
				cnt.setCntPos(contact.get(j).getCNTPOS());
				cnt.setCntTyp(contact.get(j).getCNTTYP());
				cnt.setVersion(1);
				conts.add(cnt);
			}

		}
		
		entity.setContacts(conts);
	}

	private void writeServices(List<SERVICES> services) {

		Integer cntDatid = manager.getNextSrvDtaid();
		usrd = (UserDetails) getSession().get(VedaConstants.USER_KEY);
		current = new Date();
		List<BizEntSrv> srvs = new ArrayList<BizEntSrv>();
		for (int i = 0; i < services.size(); i++) {

			List<SERVICE> service = (List<SERVICE>) services.get(i).getSERVICE();
			BizEntSrv srv = new BizEntSrv();
			for (int j = 0; j < service.size(); j++) {
				System.out.println(service.get(j).getSRVNAME());
				srv.setEntity(entid);
				srv.setDatid(cntDatid++);
				srv.setCrtDate(current);
				srv.setCrtByUser(usrd.getUsername());
				srv.setSrvName(service.get(j).getSRVNAME());
				srv.setVersion(1);
				srvs.add(srv);
				
			}

		}
		
		entity.setSrvNames(srvs);
	}

	private void writeNames(List<NAMES> names) {

		Integer innDatid = manager.getNextInnDtaid();
		usrd = (UserDetails) getSession().get(VedaConstants.USER_KEY);
		current = new Date();
		List<BizEntInn> inns = new ArrayList<BizEntInn>();
		for (int i = 0; i < names.size(); i++) {

			List<NAME> name = (List<NAME>) names.get(i).getNAME();
			BizEntInn nam = new BizEntInn();
			for (int j = 0; j < name.size(); j++) {
				System.out.println(name.get(j).getINNBNAME());
				nam.setEntity(entid);
				nam.setDatid(innDatid++);
				nam.setCrtDate(current);
				nam.setCrtByUser(usrd.getUsername());
				nam.setBizName(name.get(j).getINNBNAME());
				nam.setType(name.get(j).getINNTYP());
				nam.setSurName(name.get(j).getINNSNAME());
				nam.setFstName(name.get(j).getINNFNAME());
				nam.setVersion(1);		
				inns.add(nam);
			}

		}
		
		entity.setNames(inns);
	}
	
	private void writeIds(List<IDS> ids) {

		Integer idDatid = manager.getNextIdDtaid();
		usrd = (UserDetails) getSession().get(VedaConstants.USER_KEY);
		current = new Date();
		List<BizEntId> idds = new ArrayList<BizEntId>();
		for (int i = 0; i < ids.size(); i++) {

			List<ID> id = (List<ID>) ids.get(i).getID();
			BizEntId idd = new BizEntId();
			for (int j = 0; j < id.size(); j++) {
				System.out.println(id.get(j).getIDIDCODE());
				idd.setEntity(entid);
				idd.setIdCtry(id.get(j).getIDCTRY());;
				idd.setDatid(idDatid++);
				idd.setCrtDate(current);
				idd.setCrtByUser(usrd.getUsername());
				idd.setIdCode(id.get(j).getIDIDCODE());
				idd.setIdTyp(id.get(j).getIDIDTYP());
				idd.setVersion(1);		
				idds.add(idd);
			}

		}
		
		entity.setIds(idds);
	}
	@Override
	public void setServletContext(ServletContext ctx) {
		this.context = ctx;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

}
