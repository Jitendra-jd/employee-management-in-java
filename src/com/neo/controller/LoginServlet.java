package com.neo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("userName");
	String password=request.getParameter("password");
		if(userName.equals("jd")&& password.equals("bhatta")){
		out.print(".....welcome....." +userName);
		HttpSession session=request.getSession();
		session.setAttribute("suname",userName);
		RequestDispatcher rd=request.getRequestDispatcher("pages/menu.jsp");
		rd.forward(request, response);
		}else {
			request.setAttribute("msg", "Invalid login form servlet.......");
			RequestDispatcher rd=request.getRequestDispatcher("/");
			rd.forward(request, response);

		}
	}

}
