package com.usc.matt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usc.matt.dao.EmployeeDao;
import com.usc.matt.model.EmployeeModel;

public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao eDao;

	public void init() {
		eDao = new EmployeeDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);

		resp.sendRedirect("employee/employee.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);

		register(req, resp);
	}

	private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String firstName = req.getParameter("first_name");
		String lastName = req.getParameter("last_name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String position = req.getParameter("position");
		String department = req.getParameter("department");

		EmployeeModel eModel = new EmployeeModel();

		eModel.setFirstName(firstName);
		eModel.setLastName(lastName);
		eModel.setUsername(username);
		eModel.setPassword(password);
		eModel.setPosition(position);
		eModel.setDepartment(department);

		try {
			int result = eDao.registerEmployee(eModel);
			if (result == 1) {
				req.setAttribute("Notification:", "User successfully registered");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatch = req.getRequestDispatcher("employee/employee.jsp");
		dispatch.forward(req, resp);
	}

	protected void viewEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");

		EmployeeModel employee = null;
		try {
			employee = eDao.getEmployee(username);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		req.setAttribute("employee", employee);

		RequestDispatcher dispatcher = req.getRequestDispatcher("employee/viewEmployee.jsp");
		dispatcher.forward(req, resp);
	}

}
