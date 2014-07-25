package cl.actions;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;

import cl.errors.IdNotFoundError;
import cl.mainStream.AppConstants;
import cl.managers.ProductImageMgr;
import cl.model.ProductImage;

@ParentPackage(value = "default")
@Namespace("/Main")
@ResultPath(value = "/")
@InterceptorRefs({
	@InterceptorRef("loginStack"),
	
	 
})
@Action(value = "ProductUpload", results = {
		@Result(name = "success", location = "/User/MaintUser", type = "redirect"),
		@Result(name = "input", location = "../products/pages/prdImage_m.jsp"),
		@Result(name = "error", location = "pages/error.jsp")
})
public class ProductUploadAction extends BaseAction {
	ProductImage image;
	List<ProductImage> images;
	public static Logger logger = Logger.getLogger("cl.actions");
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private String destPath;

	
	@Override
	public String execute() throws Exception {
		logger.info("ProductAction");
		return INPUT;
	}
	
	
	public String productUpload() throws Exception {

		if (fileUpload != null) {
			try {
				logger.info("Src File name: " + fileUpload);

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
		return SUCCESS;
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
	/*@Override
	public String execute() throws Exception {

		System.out.println("ProductAction");
		UserDetails usrd = (UserDetails) getSession().get("USER_DETAILS");
		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");
		String contextPath = (String) getServletContex().getAttribute("TMP_FOLDER");
		String realPath = (String) getServletContex().getContextPath();
		String tempPath ="/Temp/images/";
		ProductImageMgr manager =
				(ProductImageMgr) ctx.getBean("productImageMgrImpl");

		// image = manager.getImgByPrdId(1);
		images = manager.getImagesByCategory("Travel");
		if (images != null && images.size() > 0) {
			for (ProductImage image : images) {
				byte[] rawData = image.getImage();
				ImageInputStream iis = ImageIO.createImageInputStream(new ByteArrayInputStream(rawData));
				BufferedImage img = ImageIO.read(iis);
				FileOutputStream outputfile = new FileOutputStream(contextPath.trim() + "\\" +image.getPrdId() + "_"
						+ image.getName() + ".png", false);
				ImageIO.write(img, "png", outputfile);
				image.setImagePath(realPath.trim()+ tempPath+image.getPrdId() + "_"+ image.getName() + ".png");
			}
		}
		return INPUT;
	}*/

	public ProductImage getImage() {
		return image;
	}

	public void setImage(ProductImage image) {
		this.image = image;
	}

	public List<ProductImage> getImages() {
		return images;
	}

	public void setImages(List<ProductImage> images) {
		this.images = images;
	}

}
