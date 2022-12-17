package com.jbk.product.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.product.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveProduct(Product product) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isAdded = false;

		// Product prd = session.get(Product.class, product.getProductId()); this is for
		// exceptions
		// if(prd==null){
		// try {
		// session.save(product);
		// transaction.commit();
		// isAdded = true;
		// }
		// }
		try {
			session.save(product);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isAdded;
	}

	@Override
	public Product getProductById(int productId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> sortProducts(String sortBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getMaxPriceProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double countSumOfProductPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCountOfProducts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int uploadProductList(List<Product> list) {

		Session session = null;
		Transaction transaction = null;
		int count = 0;
		try {

			for (Product product : list) {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				
				session.save(product);
				transaction.commit();
				count = count + 1;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		} 
		return 0;
	}

}
