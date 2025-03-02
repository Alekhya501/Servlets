package com.Alekhyagrandhi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ale", "root", "1234");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int saveEmp(EmployeeDto e) {
		int status = 0;
		try {
			Connection con = EmployeeDao.getConnection();
			String query = "INSERT INTO Employee1 (name, password, email, country) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e1) {
			System.out.println(e1);
		}
		return status;
	}

	public static int updateEmp(EmployeeDto e) {
		int status = 0;
		try {
			Connection con = EmployeeDao.getConnection();
			String query = "UPDATE Employee1 SET name=?, password=?, email=?, country=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			ps.setInt(5, e.getId());
			status = ps.executeUpdate();
		} catch (Exception e1) {
			System.out.println(e1);
		}
		return status;
	}

	public static int deleteEmp(int id) {
		int status = 0;
		try {
			Connection con = EmployeeDao.getConnection();
			String query = "delete from Employee1  Where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			status = ps.executeUpdate();
		} catch (Exception e1) {
			System.out.println(e1);
		}
		return status;
	}

	public static EmployeeDto getEmployeeById(int id) {
		EmployeeDto e = new EmployeeDto();

		try {
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Employee1 where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<EmployeeDto> getAllEmployees() {
		List<EmployeeDto> list = new ArrayList<EmployeeDto>();

		try {
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Employee1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmployeeDto e = new EmployeeDto();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
