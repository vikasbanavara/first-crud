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

public class TestF {
	public static void main(String[] args) {
		
		
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream("chaipoint_db_info.properties");

			properties.load(inputStream);
			
			String url = properties.getProperty("url");
			String driver = properties.getProperty("driver");
			
			Class.forName(driver);

			Connection connection = DriverManager.getConnection(url, properties);
			Statement statement = connection.createStatement();
			
			statement.execute("INSERT INTO student VALUES(7,'Srini','sri@mail.com')");
			
			connection.close();
		
			System.out.println("Data  inserted");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
