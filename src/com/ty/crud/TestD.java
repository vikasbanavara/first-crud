package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class TestD {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/javabatch?user=root&password=root";
		
		
		String sql = "INSERT INTO student VALUES(5,'Deepika','deep@mail.com')";
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			Connection con =  DriverManager.getConnection(url);
				
			Statement stm = con.createStatement();
			
			stm.execute(sql);
			
			con.close();
			
			System.out.println("Data inserted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
