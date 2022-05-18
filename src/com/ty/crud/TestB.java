package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestB {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String userName = "root";
		String password = "root";
		
		String res = "DELETE FROM student WHERE id = 1"; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con =  DriverManager.getConnection(url, userName, password);
		
			Statement stm  = con.createStatement();
			
			stm.execute(res);
			
			con.close();
			System.out.println("Record deleted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
