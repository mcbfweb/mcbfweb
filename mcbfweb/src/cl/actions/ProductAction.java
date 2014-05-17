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

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;

import cl.managers.ProductImageMgr;
import cl.model.ProductImage;

@ParentPackage(value = "default")
@Namespace("/Main")
@ResultPath(value = "/")
@InterceptorRefs({
	@InterceptorRef("loginStack"),
	
	 
})
@Action(value = "Product", results = {
		@Result(name = "success", location = "/User/MaintUser", type = "redirect"),
		@Result(name = "input", location = "/products/pages/testImg.jsp"),
		@Result(name = "error", location = "pages/error.jsp")
})
public class ProductAction extends BaseAction {
	ProductImage image;
	List<ProductImage> images;

	@Override
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
	}

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
