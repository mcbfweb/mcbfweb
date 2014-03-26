package cl.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.errors.IdNotFoundError;
import cl.model.ProductImage;

@Service
public class ProductImageDAOImpl implements ProductImageDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertImg(ProductImage img) {
		sessionFactory.getCurrentSession().save(img);

	}

	@Override
	public ProductImage getImgByName(String imgName) throws IdNotFoundError {
		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from PRDIMGM0 where IMGNAME = :imgName");
		query.setParameter("prdName", imgName);
		return (ProductImage) query.list().get(0);
	}

	@Override
	public ProductImage getImgByPrdId(int prdId) throws IdNotFoundError{
		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from PRDIMGM0 where IMGPRDID = :prdId");
		query.setParameter("prdId", prdId);
		
		if (query.list().size() > 0)
			return (ProductImage) query.list().get(0);

		throw new IdNotFoundError("Did not find Product Id");
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductImage> getImagesByCategory(String category) throws IdNotFoundError{
		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from PRDIMGM0 where IMGCTGY = :category");
		query.setParameter("category", category);
		return query.list();
	}

	@Override
	public void deleteImg(int prdId) {
		ProductImage code = (ProductImage) sessionFactory.getCurrentSession().load(
				ProductImage.class, prdId);
		if (null != code) {
			this.sessionFactory.getCurrentSession().delete(code);
		}

	}
	
}
