package com.cg.empmaintenance.controller;

import java.io.IOException;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.empmaintenance.exception.EmployeeException;
import com.cg.empmaintenance.service.AdminService;
import com.cg.empmaintenance.service.AdminServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		service = new AdminServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String para = request.getParameter("action");

		if ("loginuser".equalsIgnoreCase(para)) {
			RequestDispatcher dispatch = request
					.getRequestDispatcher("/pages/loginuser.jsp");
			dispatch.forward(request, response);
		}

		if ("logout".equalsIgnoreCase(para)) {
			session.removeAttribute("loginSession");
			RequestDispatcher dispatch = request
					.getRequestDispatcher("/index.jsp");
			dispatch.forward(request, response);
		//	response.sendRedirect("index.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String para = request.getParameter("action");

		if ("login".equalsIgnoreCase(para)) {
			String userName = request.getParameter("username");
			String password = request.getParameter("pwd");

			String type = null;
			try {
				type = service.validateLogin(userName, password);
				if (type == "Admin") {
					session.setAttribute("loginSession", userName);
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/loginAdmin.jsp");
					dispatch.forward(request, response);
				} else if (type == "Employee") {

					session.setAttribute("loginSession", userName);
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/loginemp.jsp");
					dispatch.forward(request, response);

				} else if (type == null) {
					request.setAttribute("loginMsg",
							"Username or Password is incorrect");
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/loginuser.jsp");
					dispatch.forward(request, response);
				}

			} catch (EmployeeException e) {

				request.setAttribute("error", e.getMessage());
				RequestDispatcher dispatch = request
						.getRequestDispatcher("/pages/error.jsp");
				dispatch.forward(request, response);
			}
		}
	}

}
