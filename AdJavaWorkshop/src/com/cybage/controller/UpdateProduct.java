package com.cybage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.model.Product;
import com.cybage.service.ProductService;
import com.cybage.service.ProductServiceImpl;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String pname=request.getParameter("name");
		double price=Double.parseDouble(request.getParameter("price"));
		
		Product p=new Product();
		p.setId(id);
		p.setName(pname);
		p.setPrice(price);
		
	
		ProductService pservice=new ProductServiceImpl();
		pservice.updateProduct(p);
		//forward control to view products
		RequestDispatcher rd=request.getRequestDispatcher("DisplayProductServlet");
		rd.forward(request, response);
		
	}
}
