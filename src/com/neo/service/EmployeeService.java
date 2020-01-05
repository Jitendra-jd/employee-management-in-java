package com.neo.service;

import java.util.List;

import com.neo.model.Employee;

public interface EmployeeService {
	public void saveEmployee(Employee emp);
	public List<Employee> allEmployees();
	public void deleteEmployee(Integer id);
	public  Employee employeeById(Integer id);
	public void updateEmployee(Employee emp);
	public List<Employee> empByFirstName(String firstName );

}
