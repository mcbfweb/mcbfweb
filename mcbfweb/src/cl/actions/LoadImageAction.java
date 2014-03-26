package cl.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cl.errors.IdNotFoundError;
import cl.errors.UserDoesNotExistError;
import cl.mainStream.AppConstants;
import cl.mainStream.BSOption;
import cl.mainStream.BSTables;
import cl.managers.AdmUsrMgr;
import cl.managers.ProductImageMgr;
import cl.model.ProductImage;
import cl.model.User;

@ParentPackage(value = "default")
@Namespace("/Main")
@ResultPath(value = "/")
@InterceptorRefs({
	@InterceptorRef("loginStack"),
	 
})
@Action(value = "LoadImage", results = {
		@Result(name = "success", location = "/User/MaintUser", type = "redirect"),
		@Result(name = "input", location = "/products/pages/prdImage_m.jsp"),
		@Result(name = "error", location = "pages/error.jsp")
})
public class LoadImageAction extends BaseAction {

	// static Logger logger = Logger.getLogger(PublicUserMenuAction.class);

	// static Logger log = Logger.getLogger(ServerProperty.class.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private String destPath;

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

	@Override
	public String execute() throws Exception {

		if (fileUpload != null) {
			try {
				System.out.println("Src File name: " + fileUpload);

				FileInputStream inputStream = new FileInputStream(fileUpload);
				byte[] imageData = new byte[(int) fileUpload.length()];
				inputStream.read(imageData);
				addUpdateImage(imageData, (int) fileUpload.length());
				inputStream.close();

			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
		return INPUT;
	}

	public String display() {
		return NONE;
	}

	public String addUpdateImage(byte[] imageData, int size) {
		ProductImage image = null;
		boolean doUpdate = false;
		UserDetails usrd = (UserDetails) getSession().get("USER_DETAILS");
		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");

		ProductImageMgr manager =
				(ProductImageMgr) ctx.getBean("productImageMgrImpl");

		int prdId = 3;

		try {
			image = manager.getImgByPrdId(prdId);
		} catch (IdNotFoundError e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			addActionError("New Product Added!");
		}

		if (image == null) {
			doUpdate = false;
			image = (ProductImage) ctx.getBean("productImage");
			image.setImage(imageData);
			image.setPrdId(prdId);
			image.setName("Merlion2");
			image.setCategory("Travel");
			image.setSize(size);
			image.setTitle("Merlion2 Singapore ");
			image.setVersion(1);
		}
		else {
			image.setVersion(image.getVersion() + 1);
			image.setImage(imageData);
			image.setPrdId(prdId);
			image.setName("Pen");
			image.setCategory("Stationery");
			image.setSize(size);
			image.setTitle("BIC Pen");
		}
		
		if (!doUpdate)
			manager.insertImg(image);
		//else
		//	manager.updatUser(user);
		
		// return INPUT;
		return AppConstants.INPUT_MOBILE_VIEW;
	}

}
