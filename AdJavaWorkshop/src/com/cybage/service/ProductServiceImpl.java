package com.cybage.service;

import java.util.List;
import java.util.Scanner;

import com.cybage.dao.ProductDaoImpl;
import com.cybage.dao.ProductDao;
import com.cybage.model.Product;

public class ProductServiceImpl implements ProductService {
	ProductDaoImpl productDao;
	
	public ProductServiceImpl() {
		productDao=new ProductDaoImpl();
	}
	
	@Override
	public void addProduct(Product p) 
	{
//		Scanner sc=new Scanner(System.in);
//		System.out.print("Enter Id: ");
//		int id=sc.nextInt();
//		System.out.print("Enter name: ");
//		String name=sc.next();
//		System.out.print("Enter price: ");
//		double price=sc.nextDouble();
//		Product p=new Product(id,name,price);
//		return productDao.saveProduct(p);
		productDao.saveProduct(p);
	}
	
	@Override
	public boolean DeleteProductbyId(int id)
	{
		return productDao.DeleteProductByid(id);
	}
	
	@Override
	public List<Product> DisplayAllProduct()
	{
		return productDao.findAllProduct();
	}
	
	@Override
	public Product getProductById(int id)
	{
		return productDao.getProductById(id);
	}
	@Override
	public void updateProduct(Product p) {
		productDao.updateById(p);
		
	}

}
