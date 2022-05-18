package com.ty.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCrudDynamic {

	MyHelper helper = new MyHelper();
	
	public void saveStudent(int id,String name,String email) {
		Connection connection = helper.getConnectionObj();
		String sql = "INSERT INTO student VALUES(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			
			preparedStatement.execute();
			connection.close();
			System.out.println("Data inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudentById(int id) {
		String sql = "DELETE FROM student WHERE id = ?";
		Connection connection = helper.getConnectionObj();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			System.out.println("Data deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateStudent(int id,String name,String email) {
		String sql = "UPDATE student SET name=?,email=? WHERE id=?";
		Connection connection = helper.getConnectionObj();
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setInt(3, id);
			
			
			preparedStatement.execute();
			System.out.println("Data Updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void printStudentById(int id) {
		String sql = "SELECT * FROM student WHERE id=?";
		Connection connection = helper.getConnectionObj();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery(sql);
			while(rs.next()) {
				int rid = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getNString(3);
				
				System.out.println("ID is "+rid);
				System.out.println("Name is "+name);
				System.out.println("Email is "+email);
				
				System.out.println("-----------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
