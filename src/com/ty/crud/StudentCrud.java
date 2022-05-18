package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentCrud {
	
	MyHelper helper = new MyHelper();
	
	public void saveStudent(int id, String name,String email) {
		try {
			Connection con = helper.getConnectionObj();
			Statement stm = con.createStatement();
			String sql = "INSERT INTO student VALUES("+id+",'"+name+"','"+email+"')";
			stm.execute(sql);
			con.close();
			System.out.println("Data saved");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void deleteStudentById(int id) {
		try {
			Connection con = helper.getConnectionObj();
			Statement stm = con.createStatement();
			String sql = "DELETE FROM student WHERE id="+id;
			stm.execute(sql);
			con.close();
			System.out.println("Data deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void printAllStudent() {
		Connection con = helper.getConnectionObj();
		try {
			Statement stm = con.createStatement();
			String sql = "SELECT * FROM student";
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
		}
	}
	
	void printStudentById(int id) {
		Connection con = helper.getConnectionObj();
		try {
			Statement stm = con.createStatement();
			String sql = "SELECT * FROM student WHERE id="+id;
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				int rid = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getNString(3);
				
				System.out.println("ID is "+rid);
				System.out.println("Name is "+name);
				System.out.println("Email is "+email);
				
				System.out.println("-----------------------------------------------");
			} else {
				System.out.println("No data for given ID: "+id);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudentName(int id, String name) {
		try {
			Connection con = helper.getConnectionObj();
			Statement stm = con.createStatement();
			String sql = "UPDATE student SET name='"+name+"' WHERE id="+id;
			stm.execute(sql);
			con.close();
			System.out.println("Data updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudentEmail(int id, String email) {
		try {
			Connection con = helper.getConnectionObj();
			Statement stm = con.createStatement();
			String sql = "UPDATE student SET email='"+email+"' WHERE id="+id;
			stm.execute(sql);
			con.close();
			System.out.println("Data updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(int id, String name,String email) {
		try {
			Connection con = helper.getConnectionObj();
			Statement stm = con.createStatement();
			String sql = "UPDATE student SET name='"+name+"',email='"+email+"' WHERE id="+id;
			stm.execute(sql);
			con.close();
			System.out.println("Data updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
