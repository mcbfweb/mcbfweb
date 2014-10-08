package cl.actions;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
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

import cl.mainStream.VedaConstants;
import cl.managers.ProductImageMgr;
import cl.model.BizEntPrd;
import cl.model.EntityDetail;
import cl.model.ProductImage;

@ParentPackage(value = "default")
@Namespace("/Main")
@ResultPath(value = "/")
@InterceptorRefs({ @InterceptorRef("defaultStack"),

@InterceptorRef("mobileType") })
@Action(value = "ProductList", results = { @Result(name = "success", location = "/products/pages/prdList_m.jsp"),
		@Result(name = "input", location = "/products/pages/prdList_m.jsp"),
		@Result(name = "error", location = "pages/error.jsp") })
public class ProductListAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	static Logger logger = Logger.getLogger(ProductListAction.class);

	public String mode;

	public EntityDetail entity;

	private List<ProductImage> prdImages = new ArrayList<ProductImage>();
	private List<BizEntPrd> products = new ArrayList<BizEntPrd>();

	@Override
	public String execute() throws Exception {

		logger.info("ProductListAction Success");

		UserDetails usrd = (UserDetails) getSession().get(VedaConstants.USER_KEY);
		ApplicationContext ctx = (ApplicationContext) getServletContex().getAttribute("SPRING_CTX");
		String contextPath = (String) getServletContex().getAttribute("TMP_FOLDER");
		String realPath = (String) getServletContex().getContextPath();
		String tempPath = (String) getServletContex().getAttribute("IMG_TMP_FOLDER");
		;

		ProductImageMgr manager = (ProductImageMgr) ctx.getBean("productImageMgrImpl");

		this.entity = (EntityDetail) getServletContex().getAttribute("ENTITY_DETAIL");
		products = entity.getProducts();
		for (BizEntPrd p : products) {

			try {
				ProductImage prdImg = manager.getImgByPrdId(p.getDatid());
				File f = new File(tempPath.trim() + "\\" + prdImg.getPrdId() + "_" + prdImg.getName() + ".png");
				if (f.exists() && !f.isDirectory()) {
					ImageInputStream iis = ImageIO.createImageInputStream(new ByteArrayInputStream(prdImg.getImage()));
					BufferedImage img = ImageIO.read(iis);
					FileOutputStream outputfile = new FileOutputStream(contextPath.trim() + "\\" + prdImg.getPrdId() + "_"
							+ prdImg.getName() + ".png", false);
					ImageIO.write(img, "png", outputfile);
					
					prdImg.setImagePath(tempPath.trim() + "\\" + prdImg.getPrdId() + "_" + prdImg.getName() + ".png");
					prdImages.add(prdImg);
				} else{
					prdImg.setImagePath(tempPath.trim() + "\\" + prdImg.getPrdId() + "_" + prdImg.getName() + ".png");
					prdImages.add(prdImg);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return INPUT;

	}

	public EntityDetail getEntity() {
		return entity;
	}

	public void setEntity(EntityDetail entity) {
		this.entity = entity;
	}

	public List<ProductImage> getPrdImages() {
		return prdImages;
	}

	public void setPrdImages(List<ProductImage> prdImages) {
		this.prdImages = prdImages;
	}

}