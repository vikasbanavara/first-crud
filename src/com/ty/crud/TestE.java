package com.ty.crud;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class TestE {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/javabatch";
		
		
		String sql = "INSERT INTO student VALUES(7,'Asha','asha@mail.com')";
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			Properties properties = new Properties();
			InputStream inputStream = new FileInputStream("mydbinfo.properties");
			properties.load(inputStream);
			
			
			Connection con =  DriverManager.getConnection(url,properties);
				
			Statement stm = con.createStatement();
			
			stm.execute(sql);
			
			con.close();
			
			System.out.println("Data inserted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
