package com.cybage.service;

import java.util.List;

import com.cybage.model.Product;

public interface ProductService {

    void addProduct(Product p);
    
    boolean DeleteProductbyId(int id);
	
	List<Product> DisplayAllProduct();
	
	Product getProductById(int id);
	void updateProduct(Product p);
	
}
