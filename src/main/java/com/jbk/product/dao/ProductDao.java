package com.jbk.product.dao;

import java.util.List;

import com.jbk.product.entity.Product;

public interface ProductDao {

	public boolean saveProduct(Product product);

	public Product getProductById(int productId);

	public List<Product> getAllProducts();

	public boolean deleteProduct(int productId);

	public boolean updateProduct(Product product);

	public List<Product> sortProducts(String sortBy);

	public Product getMaxPriceProduct();

	public double countSumOfProductPrice();

	public int getTotalCountOfProducts();
	
	public int uploadProductList(List<Product> list);

}
