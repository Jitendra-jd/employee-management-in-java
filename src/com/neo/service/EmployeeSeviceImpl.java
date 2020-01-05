package com.neo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSet;
import com.neo.model.Employee;
import com.neo.util.DbConnection;

public class EmployeeSeviceImpl implements EmployeeService {

	Connection con = null;
	java.sql.PreparedStatement ps = null;

	public void saveEmployee(Employee emp) {
		try {
			con = DbConnection.getDbConnection();
			String sql = "INSERT INTO employee(firstName,lastName,salary,age,email)" + "VALUES(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getAge());
			ps.setString(5, emp.getEmail());
			int i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("exxx..." + e.getMessage());
		}

	}

	@Override
	public List<Employee> allEmployees() {
		List<Employee> emplist = new ArrayList<Employee>();// null
		try {
			con = DbConnection.getDbConnection();
			String sql = "SELECT * FROM employee";
			ps = con.prepareStatement(sql);
			ResultSet rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("firstName"));
				e.setLastName(rs.getString("lastName"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
				e.setEmail(rs.getString("email"));
				emplist.add(e);

			}
		} catch (Exception e) {
			System.out.println("exxx..." + e.getMessage());
		}
		return emplist;

	}

	@Override
	public void deleteEmployee(Integer id) {
		try {
			con = DbConnection.getDbConnection();
			String sql = "DELETE FROM employee WHERE id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Data deleted Successfully of id::" + id);

		} catch (ClassNotFoundException e) {
			e.getMessage();

		} catch (SQLException e) {
			e.getMessage();

		} finally {
			try {
				ps.close();
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Employee employeeById(Integer id) {
		Employee e = null;
		try {
			con = DbConnection.getDbConnection();
			String sql = "SELECT * FROM employee WHERE id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("firstName"));
				e.setLastName(rs.getString("lastName"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
				e.setEmail(rs.getString("email"));

			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return e;

	}

	public void updateEmployee(Employee emp) {
		try {
			con = DbConnection.getDbConnection();
			String sql = "UPDATE employee SET firstName=?, lastName=?, salary=?, age=?, email=? WHERE id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getAge());
			ps.setString(5, emp.getEmail());
			ps.setInt(6, emp.getId());
			Integer id = ps.executeUpdate();
			System.out.println("updatedId......" + emp.getId());

		} catch (SQLException ex) {
			System.out.println("...SQLEX..."+ex.getMessage());
		}
		 catch (Exception ex) {
			 System.out.println("...Exception..."+ex.getMessage());
			}

	}

	public List<Employee> empByFirstName(String firstName) {
		List<Employee> emplist = new ArrayList<Employee>();
		List<Employee> empList = null;
		try {
			con = DbConnection.getDbConnection();
			String sql = "SELECT * FROM employee WHERE firstName=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, firstName);
			ResultSet rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("firstName"));
				e.setLastName(rs.getString("lastName"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
				e.setEmail(rs.getString("email"));
				empList.add(e);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("....empListSearch...." + emplist.size());
		return empList;

	}
}
