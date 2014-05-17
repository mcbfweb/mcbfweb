package cl.actions;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.context.ApplicationContext;

import cl.managers.BizEntityMgr;
import cl.model.EntityDetail;

import com.mcbf.REQUEST;
import com.mcbf.REQUEST.MESSAGE.ENTITIES;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.ADDRESSES;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.ADDRESSES.ADDRESS;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.CONTACTS;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.IDS;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.NAMES;
import com.mcbf.REQUEST.MESSAGE.ENTITIES.ENTITY.SERVICES;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport implements ServletContextAware {

	private static final long serialVersionUID = 1L;
	private BizEntityMgr manager;
	//private ApplicationContext ctx;
	private EntityDetail entity;

	private File fileUpload;
	private String fileUploadFileName;
	private String fileUploadContentType;
	private ServletContext context;

	public String doUpload() {
		File saveFilePath = new File("C:/Upload/" + fileUploadFileName);
		
		try {
			FileUtils.copyFile(fileUpload, saveFilePath);
		} catch (IOException ex) {
			System.out.println("Couldn't save file: " + ex.getMessage());
		}
		return SUCCESS;
	}

	@SkipValidation
	@Override
	public String execute() {
		File saveFilePath = new File("C:/Upload/" + fileUploadFileName);
		MultiPartRequestWrapper multiWrapper =
			    (MultiPartRequestWrapper) ServletActionContext.getRequest();
			Enumeration fileParameterNames = multiWrapper.getFileParameterNames();
		System.out.println("File Name is:"+getFileUploadFileName());
		System.out.println("File ContentType is:"+getFileUploadContentType());
		System.out.println("Files Directory is:"+saveFilePath);
		
		try {
			FileUtils.copyFile(fileUpload, saveFilePath);
		} catch (IOException ex) {
			System.out.println("Couldn't save file: " + ex.getMessage());
		}
		return SUCCESS;
	}

	@Override
	public void setServletContext(ServletContext ctx) {
		this.context=ctx;
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

	public String execute222() throws Exception {

		try {
			// ctx = (ApplicationContext)
			// getServletContex().getAttribute("SPRING_CTX");
			//manager = (BizEntityMgr) ctx.getBean("bizEntityMgrImpl");
			// this.ctx = (ApplicationContext)
			// getServletContex().getAttribute("SPRING_CTX");
			//this.manager = (BizEntityMgr) ctx.getBean("bizEntityMgrImpl");
			//this.entity = (EntityDetail) ctx.getBean("entityDetail");

			File file = new File("xml/clientUpload.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(REQUEST.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			REQUEST request = (REQUEST) jaxbUnmarshaller.unmarshal(file);
			REQUEST.HEADER header = (REQUEST.HEADER) request.headerOrMESSAGE.get(0);
			REQUEST.MESSAGE message = (REQUEST.MESSAGE) request.headerOrMESSAGE.get(1);

			if (header.getACTION().equalsIgnoreCase("A") && header.getSERVICE().equalsIgnoreCase("CLIENT")) {

				List<ENTITIES> entities = message.getENTITIES();

				for (int i = 0; i < entities.size(); i++) {
					@SuppressWarnings("unchecked")
					List<ENTITY> ent = (List<ENTITY>) entities.get(i);
					// writeEntity();
					for (int j = 0; j < ent.size(); j++) {
						List<ADDRESSES> addresses = ent.get(j).getADDRESSES();
						writeAddress(addresses);
						List<CONTACTS> contacts = ent.get(j).getCONTACTS();
						// writeContact(contacts);
						List<SERVICES> services = ent.get(j).getSERVICES();
						// writeServices(services);
						List<NAMES> names = ent.get(j).getNAMES();
						// writeNames(names);
						List<IDS> ids = ent.get(j).getIDS();
						// writeIds(ids)
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

	private void writeEntity(List<ADDRESSES> addresses) {
	}

	private void writeAddress(List<ADDRESSES> addresses) {

		for (int i = 0; i < addresses.size(); i++) {

			ADDRESS address = (ADDRESS) addresses.get(0).getADDRESS();
			System.out.println(address.adrpstcde);

		}
	}

}
