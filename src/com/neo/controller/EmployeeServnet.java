package com.neo.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/EmployeeServnet")
public class EmployeeServnet extends HttpServlet {
	private EmployeeService empService = new EmployeeSeviceImpl();
	private static final long serialVersionUID = 1L;
	List<Employee> emplist = empService.allEmployees();

	public EmployeeServnet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String action="";
		Integer id=0;
		if(request.getParameter("eId")!=null) {
			id=Integer.parseInt(request.getParameter("eId"));
			
		}
		if(request.getParameter("action")!=null) {
			action=request.getParameter("action");
			if(action.equals("delete")) {
				empService.deleteEmployee(id);
				request.setAttribute("msg", "Data deleted successfully");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/list.jsp");
				dispatcher.forward(request, response);
				
			}else if(action.equals("edit")) {
				out.print("....edit action" +id);
				Employee emp=empService.employeeById(id);
				request.setAttribute("empDetail", emp);
				RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/edit.jsp");
						dispatcher.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		Double salary = Double.parseDouble(request.getParameter("salary"));
		Integer age = Integer.parseInt(request.getParameter("age"));

		Employee e = new Employee();
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setSalary(salary);
		e.setAge(age);
		e.setEmail(email);

		empService.saveEmployee(e);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/list.jsp");
		dispatcher.forward(request, response);
		request.setAttribute("employeeList", emplist);
	}

}
