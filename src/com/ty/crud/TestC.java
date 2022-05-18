package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class TestC {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String userName = "root";
		String password = "root";
		
		String sql = "INSERT INTO student VALUES(4,'Anjali','anju@mail.com')";
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			Connection con =  DriverManager.getConnection(url, userName, password);
				
			Statement stm = con.createStatement();
			
			stm.execute(sql);
			
			con.close();
			
			System.out.println("Data inserted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
