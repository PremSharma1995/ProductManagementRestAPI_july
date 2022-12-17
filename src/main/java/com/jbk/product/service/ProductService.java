package com.jbk.product.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.product.entity.Product;

public interface ProductService {

	public boolean saveProduct(Product product);

	public Product getProductById(int productId);

	public List<Product> getAllProducts();

	public boolean deleteProduct(int productId);

	public boolean updateProduct(Product product);

	public List<Product> sortProducts(String sortBy);

	public Product getMaxPriceProduct();

	public double countSumOfProductPrice();

	public int getTotalCountOfProducts();
	
	public int uploadSheet(CommonsMultipartFile file , HttpSession session);

}
