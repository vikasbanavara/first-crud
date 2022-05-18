package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJ {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String userName = "root";
		String password = "root";
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String sql = "INSERT INTO student VALUES(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 22);
			preparedStatement.setString(2, "Ramya MD");
			preparedStatement.setString(3, "ramya@mail.com");
			preparedStatement.execute();
			System.out.println("Data inserted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
