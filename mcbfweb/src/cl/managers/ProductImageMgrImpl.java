package cl.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dao.AdmUsrDAO;
import cl.dao.ProductImageDAO;
import cl.dao.UserLoginDAO;
import cl.errors.IdNotFoundError;
import cl.errors.UserDoesNotExistError;
import cl.model.ProductImage;
import cl.model.User;

@Service
public class ProductImageMgrImpl implements ProductImageMgr {

	@Autowired
	private ProductImageDAO prdImgDAO;

	@Override
	@Transactional
	public void insertImg(ProductImage img) {
	
		prdImgDAO.insertImg(img);
	
	}
	
	@Override
	@Transactional
	public ProductImage getImgByPrdId(int prdId) throws IdNotFoundError{
	
		return prdImgDAO.getImgByPrdId(prdId) ;
	
	}
	
	@Override
	@Transactional
	public ProductImage getImgByName(String imgName) throws IdNotFoundError{
	
		return prdImgDAO.getImgByName(imgName) ;
	
	}
	
	@Override
	@Transactional
	public List<ProductImage> getImagesByCategory(String category) throws IdNotFoundError {
	
		return prdImgDAO.getImagesByCategory(category);
	
	}
	
	@Override
	@Transactional
	public void deleteImg(int prdId) {
	
		prdImgDAO.deleteImg(prdId);
	
	}
}
