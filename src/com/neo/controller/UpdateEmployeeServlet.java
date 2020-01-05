package com.neo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.model.Employee;
import com.neo.service.EmployeeService;
import com.neo.service.EmployeeSeviceImpl;


@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private EmployeeService empService = new EmployeeSeviceImpl();
	private static final long serialVersionUID = 1L;
	List<Employee> emplist = empService.allEmployees();
       
    
    public UpdateEmployeeServlet() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("eId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		Double salary = Double.parseDouble(request.getParameter("salary"));
		Integer age = Integer.parseInt(request.getParameter("age"));

		Employee e = new Employee();
		e.setId(id);
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setSalary(salary);
		e.setAge(age);
		e.setEmail(email);
		empService.updateEmployee(e);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/list.jsp");
		dispatcher.forward(request, response);
		
	}

}
