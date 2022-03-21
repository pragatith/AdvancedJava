package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class DisplayProduct extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("List of All Available Product\n");
		ProductService pservice = new ProductServiceImpl();
		List<Product> plist = pservice.DisplayAllProduct();
		out.println("<table border='2'>");
		out.println("<tr><th>Product id</th><th>Prodcut Name</th><th>Price</th>");
		for (Product p : plist) {
			out.println("<tr>");
			out.println("<td>" + p.getId() + "</td><td>" + p.getName() + "</td><td>" + p.getPrice() + "</td>");
			out.println("<td><a href='DeleteProductServlet?id="+p.getId()+"'>delete</a></td>");
			out.println("<td><a href='EditProductServlet?id="+p.getId()+"'>Update</a></td>");
			
					out.println("</tr>");
		}
		out.println("</table>");
		out.println("<a href='AddProduct.html'>Add Product</a>");
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		}

}
