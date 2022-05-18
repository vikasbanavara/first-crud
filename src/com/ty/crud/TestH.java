package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestH {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String userName = "root";
		String password = "root";
		
		String sql = "SELECT * FROM student";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =  DriverManager.getConnection(url, userName, password);
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getNString(3);
				
				System.out.println("ID is "+id);
				System.out.println("Name is "+name);
				System.out.println("Email is "+email);
				
				System.out.println("-----------------------------------------------");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
