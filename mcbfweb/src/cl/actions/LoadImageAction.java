package cl.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
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

import cl.errors.IdNotFoundError;
import cl.mainStream.AppConstants;
import cl.mainStream.VedaConstants;
import cl.managers.BizEntPrdMgr;
import cl.managers.ProductImageMgr;
import cl.model.BizEntPrd;
import cl.model.BizEntPrd2;
import cl.model.ProductImage;

@ParentPackage(value = "default")
@Namespace("/Data")
@ResultPath(value = "/")
@InterceptorRefs({ @InterceptorRef("loginStack"),

})
public class LoadImageAction extends BaseAction {

	 static Logger logger = Logger.getLogger(LoadImageAction.class);

	// static Logger log = Logger.getLogger(ServerProperty.class.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private String clientId;
	private String productId;
	private String destPath;

	@SkipValidation
	@Override
	@Action(value = "LoadImage", results = { @Result(name = "success", location = "/user/pages/login_m.jsp", type = "redirect"),
			@Result(name = "input", location = "/products/pages/prdImage_m.jsp"),
			@Result(name = "error", location = "pages/error.jsp") })
	public String execute() throws Exception {

		return INPUT;
	}

	public String display() {
		return NONE;
	}

	public String uploadImageFile() {
		UserDetails usrd = (UserDetails) getSession().get(VedaConstants.USER_KEY);
		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");
		BizEntPrdMgr manager = (BizEntPrdMgr) ctx.getBean("bizEntPrdMgrImpl");
		
		logger.info("Src File name: " + fileUpload);
		logger.info("product: " + productId);
		
		if (fileUpload != null) 
			try {
				BizEntPrd2  product = manager.getPrdById( clientId.trim(),  productId.trim());
				if (product != null) {					
					FileInputStream inputStream = new FileInputStream(fileUpload);
					byte[] imageData = new byte[(int) fileUpload.length()];
					inputStream.read(imageData);
					addUpdateImage(imageData, (int) fileUpload.length(), product);
					inputStream.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		

		return SUCCESS;
	}

	public String addUpdateImage(byte[] imageData, int size,  BizEntPrd2 product) {
		ProductImage image = null;
		boolean doUpdate = false;
		UserDetails usrd = (UserDetails) getSession().get("USER_DETAILS");
		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");

		ProductImageMgr manager = (ProductImageMgr) ctx.getBean("productImageMgrImpl");

		int prdId = product.getDatid();

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
			image.setName(product.getPrdTitle());
			image.setCategory(product.getPrdCtgy());
			image.setSize(size);
			image.setTitle(product.getPrdDesc());
			image.setVersion(1);
		} else {
			image.setVersion(image.getVersion() + 1);
			image.setImage(imageData);
			image.setPrdId(prdId);
			image.setName(product.getPrdTitle());
			image.setCategory(product.getPrdCtgy());
			image.setSize(size);
			image.setTitle(product.getPrdDesc());
		}

		if (!doUpdate)
			manager.insertImg(image);
		// else
		// manager.updatUser(user);

		// return INPUT;
		return AppConstants.INPUT_MOBILE_VIEW;
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

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

}
