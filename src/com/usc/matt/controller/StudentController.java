package com.usc.matt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usc.matt.dao.StudentDao;
import com.usc.matt.model.StudentModel;

public class StudentController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;

	public void init() {
		studentDao = new StudentDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);

		resp.sendRedirect("register/register.jsp");
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

		StudentModel studentModel = new StudentModel();

		studentModel.setFirstName(firstName);
		studentModel.setLastName(lastName);
		studentModel.setUserName(username);
		studentModel.setPassword(password);

		try {
			int result = studentDao.registerStudent(studentModel);
			if (result == 1) {
				req.setAttribute("Notification:", "User successfully registered");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatch = req.getRequestDispatcher("register/register.jsp");
		dispatch.forward(req, resp);
	}
}
