package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyHelper {
	private String url = "jdbc:mysql://localhost:3306/javabatch";
	private String userName = "root";
	private String password = "root";
	private Connection con = null;
	
	public Connection getConnectionObj() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,userName,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
