package com.cybage.dao;

import java.util.List;

import com.cybage.model.Product;

public interface ProductDao {
	void saveProduct(Product p);
	
	List<Product> findAllProduct();
	
	Product getProductById(int id);
	
	boolean DeleteProductByid(int id);
	void updateById(Product p);

}
