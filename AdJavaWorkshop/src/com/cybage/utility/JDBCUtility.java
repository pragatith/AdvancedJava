package com.cybage.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtility {
//	public static void main(String[] args) {
		private static Connection con;
		public static Connection getMyConnection() {
			if(con==null) {
				try {
					DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
					String url="jdbc:mysql://localhost:3306/test";
					con=DriverManager.getConnection(url,"root","root");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return con;
		}
		
		public static void closeMyConnection()
		{
			try {
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}


