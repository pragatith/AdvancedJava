package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cybage.model.Product;

import com.cybage.utility.JDBCUtility;

public class ProductDaoImpl {
	private static Connection connection;
	private static PreparedStatement pinsert,pselect,pgetProductByid,pdeleteProductByid,pupdateById;
	
	static 
	{
		try
		{
			connection=JDBCUtility.getMyConnection();
			pinsert=connection.prepareStatement("insert into product values(?,?,?)");
			pselect=connection.prepareStatement("select * from product");
			pgetProductByid=connection.prepareStatement("select * from product where id=?");
			pdeleteProductByid=connection.prepareStatement("delete from product where id=?");
			pupdateById=connection.prepareStatement("update products set name=?, price=? where id=?");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void saveProduct(Product p) {
		try 
		{
			pinsert.setInt(1, p.getId());
			pinsert.setString(2, p.getName());
			pinsert.setDouble(3, p.getPrice());
			int n=pinsert.executeUpdate();
		} catch(SQLException e) 
		{
			e.printStackTrace();
		}
		//return 1;
	}
	public List<Product> findAllProduct() {
		List<Product> plist=new ArrayList<>();
		try 
		{
			ResultSet rs=pselect.executeQuery();
			while(rs.next())
			{
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				plist.add(p);
			}
			return plist;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Product getProductById(int id)
	{
		try 
		{
			pgetProductByid.setInt(1, id);
			ResultSet rs=pgetProductByid.executeQuery();
			if(rs.next())
			{
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				return p;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean DeleteProductByid(int id)
	{
		try
		{
			pdeleteProductByid.setInt(1, id);
			int n=pdeleteProductByid.executeUpdate();
			if(n>0)
			{
				return true;
			}
		}  catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void updateById(Product p) {
		
		try {
			pupdateById.setInt(1, p.getId());
			pupdateById.setString(2, p.getName());
			pupdateById.setDouble(3, p.getPrice());
			
			pupdateById.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
