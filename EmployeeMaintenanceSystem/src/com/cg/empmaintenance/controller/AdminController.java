package com.cg.empmaintenance.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.empmaintenance.dao.AdminDAOImpl;
import com.cg.empmaintenance.dto.EmployeeBean;
import com.cg.empmaintenance.dto.UserMasterBean;
import com.cg.empmaintenance.exception.EmployeeException;
import com.cg.empmaintenance.service.AdminServiceImpl;
import com.cg.empmaintenance.service.AdminService;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AdminService service;
	AdminDAOImpl dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		service = new AdminServiceImpl();
		dao = new AdminDAOImpl();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String para = request.getParameter("action");
		if ("AdminBack".equalsIgnoreCase(para)) {
			RequestDispatcher dispatch = request
					.getRequestDispatcher("/pages/loginAdmin.jsp");
			dispatch.forward(request, response);
		}
		
		
		if ("about".equalsIgnoreCase(para)) {

			RequestDispatcher dispatch = request
					.getRequestDispatcher("/pages/about.jsp");
			dispatch.forward(request, response);
		}
		if ("contact".equalsIgnoreCase(para)) {

			RequestDispatcher dispatch = request
					.getRequestDispatcher("/pages/contact.jsp");
			dispatch.forward(request, response);
		}
		
		
		if (session.getAttribute("loginSession") != null) {
			// Checks the action from login admin page
			

			// if add, returns employee details form
			if ("add".equalsIgnoreCase(para)) {
				try {

					ArrayList<String> list = new ArrayList<String>();

					list = service.getDeptName();

					session.setAttribute("departmentNames", list);

					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/addEmployee.jsp");
					dispatch.forward(request, response);

				} catch (EmployeeException e) {

					request.setAttribute("error", e.getMessage());
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/error.jsp");
					dispatch.forward(request, response);
				}

			}

			// if modify, returns table of all employee with update and delete
			// function
			if ("modify".equalsIgnoreCase(para)) {
				ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();
				try {
					list = service.displayAll();
				} catch (EmployeeException e) {

					request.setAttribute("error",
							"Sql Error: Something went wrong-displayAll()");
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/error.jsp");
					dispatch.forward(request, response);
				}
				request.setAttribute("listEmp", list);
				RequestDispatcher dispatch = request
						.getRequestDispatcher("/pages/ModifyAll.jsp");
				dispatch.forward(request, response);
			}

			// if update, returns editable form already populated with employee
			// details
			if ("update".equalsIgnoreCase(para)) {

				String empId = request.getParameter("userId");

				int id = Integer.parseInt(empId);
				request.setAttribute("empId", empId);
				try {
					ArrayList<String> list = new ArrayList<String>();
					ArrayList<String> listofGrades = new ArrayList<String>();
					list = service.getDeptName();
					request.setAttribute("deptNames", list);

					EmployeeBean bean = new EmployeeBean();

					bean = service.getEmpById(id);
					String deptname = service.findDeptName(bean.getDeptId());

					listofGrades = service.getGrades();
					request.setAttribute("grades", listofGrades);
					request.setAttribute("currdept", deptname);
					request.setAttribute("CurrentUser", bean);
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/modify.jsp");
					dispatch.forward(request, response);
				} catch (EmployeeException e) {

					request.setAttribute("error",
							"Sql Error: Something went wrong-getEmpById()");
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/error.jsp");
					dispatch.forward(request, response);
				}

			}

			/** delete the corresponding employee */
			if ("delete".equalsIgnoreCase(para)) {
				int id = Integer.parseInt(request.getParameter("userId"));
				try {
					service.deleteDetails(id);
					ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();

					list = service.displayAll();
					request.setAttribute("listEmp", list);
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/ModifyAll.jsp");
					dispatch.forward(request, response);

				} catch (EmployeeException e) {

					request.setAttribute("error", e.getMessage());
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/error.jsp");
					dispatch.forward(request, response);
				} catch (Exception e) {

					request.setAttribute("error",
							"Sql Error: Something went wrong-displayAll()");
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/error.jsp");
					dispatch.forward(request, response);
				}

			}
			/** view all employee details */
			if ("view".equalsIgnoreCase(para)) {

				ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();
				try {
					list = service.displayAll();
				} catch (EmployeeException e) {

					request.setAttribute("error",
							"Sql Error: Something went wrong-displayAll()");
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/error.jsp");
					dispatch.forward(request, response);
				}
				request.setAttribute("listEmp", list);
				// DepartmentBean
				// dept=(DepartmentBean)session.getAttribute("deptname");
				// String deptname=dept.getDeptName();
				// session.setAttribute("deptname", dept);
				RequestDispatcher dispatch = request
						.getRequestDispatcher("/pages/viewByAdmin.jsp");
				dispatch.forward(request, response);
			}

		
			
		}else{
			String msg="please login again";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatch = request
					.getRequestDispatcher("/pages/loginuser.jsp");
			dispatch.forward(request, response);
		}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session.getAttribute("loginSession") != null) {
			String para = request.getParameter("action");

			/** updates an employee details */
			if ("updateValues".equalsIgnoreCase(para)) {
				// Parameter names need to check.....

				EmployeeBean emp = new EmployeeBean();
				String id = request.getParameter("userId");
				emp.setEmpId(Integer.parseInt(request.getParameter("userId")));
				emp.setFirstName(request.getParameter("fName"));
				emp.setLastName(request.getParameter("lName"));
				emp.setAddress(request.getParameter("addr"));
				emp.setContactNo(request.getParameter("number"));
				String deptname = request.getParameter("DepartmentName");

				emp.setDesignation(request.getParameter("design"));

				LocalDate dt = LocalDate.parse(request.getParameter("eDob"));
				emp.setEmpDob(dt);
				LocalDate dt1 = LocalDate.parse(request.getParameter("eDoj"));
				emp.setEmpDoj(dt1);
				emp.setGrade(request.getParameter("Grade"));
				emp.setGender(request.getParameter("gender"));
				emp.setMaritalStatus(request.getParameter("status"));
				emp.setSalary(Integer.parseInt(request.getParameter("sal")));

				try {

					boolean validateSal = service.validateSalary(emp);
					if (validateSal) {

						service.modifyDetails(emp, deptname);
						request.setAttribute("empid", id);
						RequestDispatcher dispatch = request
								.getRequestDispatcher("/pages/successupdate.jsp");
						dispatch.forward(request, response);
					}

					else {
						RequestDispatcher dispatch = request
								.getRequestDispatcher("/pages/modify.jsp");
						dispatch.forward(request, response);
					}

				} catch (EmployeeException e) {

					request.setAttribute("error", e.getMessage());
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/error.jsp");
					dispatch.forward(request, response);
				} catch (Exception e) {
					// Error message............
					request.setAttribute("error",
							"Sql Error: Something went wrong-modifyDetails()");
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/error.jsp");
					dispatch.forward(request, response);
				}

			}
			/** inserting new employee details to the application */

			if ("insert".equalsIgnoreCase(para)) {
				LocalDate bdt = LocalDate.parse(request.getParameter("dob"));
				LocalDate jdt = LocalDate.parse(request.getParameter("doj"));
				LocalDate dt = LocalDate.now();
				int age = dt.getYear() - bdt.getYear();
				if (age >= 18 && age <= 58) {
					if (bdt.isBefore(jdt)) {

						EmployeeBean emp = new EmployeeBean();

						emp.setFirstName(request.getParameter("fName"));
						emp.setLastName(request.getParameter("lName"));
						emp.setAddress(request.getParameter("address"));
						emp.setContactNo(request.getParameter("number"));

						emp.setDesignation(request.getParameter("designation"));

						emp.setEmpDob(bdt);

						emp.setEmpDoj(jdt);
						emp.setGrade(request.getParameter("Grade"));
						emp.setGender(request.getParameter("gender"));
						emp.setMaritalStatus(request
								.getParameter("maritalstatus"));
						emp.setSalary(Integer.parseInt(request
								.getParameter("basic")));
						String deptName = request
								.getParameter("DepartmentName");

						try {

							boolean validateSal = service.validateSalary(emp);
							if (validateSal) {

								service.insertDetails(emp, deptName);
								int empid = emp.getEmpId();
								session.setAttribute("emp", emp);
								session.setAttribute("empid", empid);
								RequestDispatcher dispatch = request
										.getRequestDispatcher("/pages/userNameGeneration.jsp");
								dispatch.forward(request, response);
							} else {

								request.setAttribute("msg3",
										"Salary should be mapped with Grade");
								RequestDispatcher dispatch = request
										.getRequestDispatcher("/pages/addEmployee.jsp");
								dispatch.forward(request, response);
							}

						} catch (EmployeeException e) {

							request.setAttribute("error", e.getMessage());
							RequestDispatcher dispatch = request
									.getRequestDispatcher("/pages/error.jsp");
							dispatch.forward(request, response);
						} catch (Exception exp) {

							session.setAttribute("noinsert", exp.getMessage());
							RequestDispatcher dispatch = request
									.getRequestDispatcher("/pages/insertFailure.jsp");
							dispatch.forward(request, response);

						}
					} else {
						request.setAttribute("msg", "Date should be proper");
						RequestDispatcher dispatch = request
								.getRequestDispatcher("/pages/addEmployee.jsp");
						dispatch.forward(request, response);
					}
				} else {
					request.setAttribute("msg1",
							"Your age should be greater than 18 and less than 58");
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/addEmployee.jsp");
					dispatch.forward(request, response);
				}
			}

			if ("display".equalsIgnoreCase(para)) {

				try {
					ArrayList<EmployeeBean> empList = service.displayAll();
					request.setAttribute("empList", empList);
					// /Page name....
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/viewEmployee.jsp");
					dispatch.forward(request, response);

				} catch (EmployeeException e) {

					request.setAttribute("error", e.getMessage());
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/error.jsp");
					dispatch.forward(request, response);
				} catch (Exception e) {
					// Error message.......
					request.setAttribute("error",
							"Sql Error: Something went wrong-displayAll()");
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/error.jsp");
					dispatch.forward(request, response);
				}

			}
			if ("insertlogin".equalsIgnoreCase(para)) {

				UserMasterBean user = new UserMasterBean();

				user.setUsername(request.getParameter("userName"));
				user.setPassword(request.getParameter("password"));
				user.setType(request.getParameter("userType"));

				try {
					int id = service.insertLogin(user);
					// Name of the page.....
					String userName = user.getUsername();
					String pass = user.getPassword();
					session.setAttribute("id", id);
					session.setAttribute("password", pass);
					session.setAttribute("username", userName);
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/success.jsp");
					dispatch.forward(request, response);

				} catch (EmployeeException e) {

					request.setAttribute("error", e.getMessage());
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/error.jsp");
					dispatch.forward(request, response);
				} catch (Exception e) {
					// Error message............
					request.setAttribute("error",
							"Sql Error: Something went wrong-insertLogin(user)");
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/error.jsp");
					dispatch.forward(request, response);
				}
			}

		}else{
			String msg="please login again";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatch = request
					.getRequestDispatcher("/pages/loginuser.jsp");
			dispatch.forward(request, response);
		}
	}
}