package cl.dao;


import java.util.List;

import cl.errors.IdNotFoundError;
import cl.model.ProductImage;

public interface ProductImageDAO {

	void insertImg(ProductImage img);

	ProductImage getImgByPrdId(int prdId) throws IdNotFoundError ;

	ProductImage getImgByName(String imgName) throws IdNotFoundError;

	List<ProductImage> getImagesByCategory(String category) throws IdNotFoundError;
	
	void deleteImg(int prdId);
}
