package cl.managers;


import java.util.List;

import cl.errors.IdNotFoundError;
import cl.model.ProductImage;

public interface ProductImageMgr {

	void insertImg(ProductImage img);

	ProductImage getImgByPrdId(int prdId) throws IdNotFoundError;

	ProductImage getImgByName(String imgName) throws IdNotFoundError;

	List<ProductImage> getImagesByCategory(String category) throws IdNotFoundError;
	
	void deleteImg(int prdId);
}
