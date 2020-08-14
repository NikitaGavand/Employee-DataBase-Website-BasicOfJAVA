package com.cg.empmaintenance.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.cg.empmaintenance.dto.EmployeeBean;
import com.cg.empmaintenance.exception.EmployeeException;
import com.cg.empmaintenance.service.EmployeeServiceImpl;
import com.cg.empmaintenance.service.EmployeeService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       EmployeeService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        service = new EmployeeServiceImpl();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("loginSession") != null) {
		String para = request.getParameter("action");
		if ("EmpBack".equalsIgnoreCase(para)) {
			RequestDispatcher dispatch = request
					.getRequestDispatcher("/pages/loginemp.jsp");
			dispatch.forward(request, response);
		}	
		}
		else{
			String msg="please login again";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatch = request
					.getRequestDispatcher("/pages/loginuser.jsp");
			dispatch.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("loginSession") != null) {
		String para = request.getParameter("action");
		ArrayList<EmployeeBean> list=new ArrayList<EmployeeBean>();
		EmployeeBean emp = new EmployeeBean();
		//System.out.println("in do post");
		if("search".equalsIgnoreCase(para)){
			
			String category=request.getParameter("search");
		  //printing type of input
			if("id".equalsIgnoreCase(category)){
			
			try {
				
				String eid = request.getParameter("srch");
				
				list =service.searchById(eid);	
				
			if(list==null){
				
				request.setAttribute("error", "NO Records Found");
				RequestDispatcher dispatch = request
						.getRequestDispatcher("/pages/error.jsp");
				dispatch.forward(request, response);
				
			}
			else{
				request.setAttribute("empList", list);
				
				RequestDispatcher dispatch = request.getRequestDispatcher("/pages/viewByEmp.jsp");
				dispatch.forward(request, response);
			}
				
			}catch (EmployeeException e) {

				request.setAttribute("error", e.getMessage());
				RequestDispatcher dispatch = request
						.getRequestDispatcher("/pages/error.jsp");
				dispatch.forward(request, response);
				}
			catch (Exception e) {
			
				request.setAttribute("error", "Sql Error: Something went wrong-searchById(eid)");
				RequestDispatcher dispatch = request
						.getRequestDispatcher("/pages/error.jsp");
				dispatch.forward(request, response);
			}
			
		}
		
			if(category.equalsIgnoreCase("fname")){
					
					
					try {
						String fName = request.getParameter("srch");
											
						list =service.searchByFName(fName);
					
								
						request.setAttribute("empList", list);
						///Page name....
						RequestDispatcher dispatch = request.getRequestDispatcher("/pages/viewByEmp.jsp");
						dispatch.forward(request, response);
						
						
					} catch (EmployeeException e) {

						request.setAttribute("error", e.getMessage());
						RequestDispatcher dispatch = request
								.getRequestDispatcher("/pages/error.jsp");
						dispatch.forward(request, response);
						}
					catch (Exception e) {
						
						request.setAttribute("error", "Sql Error: Something went wrong-searchByName(fname)");
						RequestDispatcher dispatch = request
								.getRequestDispatcher("/pages/error.jsp");
						dispatch.forward(request, response);
					}
					
				}

			if(category.equalsIgnoreCase("lname")){
			
			
			try {
				String lName = request.getParameter("srch");
				
				
				
				list =service.searchByLName(lName);
						
						
				request.setAttribute("empList", list);
				RequestDispatcher dispatch = request.getRequestDispatcher("/pages/viewByEmp.jsp");
				dispatch.forward(request, response);
				
				
			} catch (EmployeeException e) {

				request.setAttribute("error", e.getMessage());
				RequestDispatcher dispatch = request
						.getRequestDispatcher("/pages/error.jsp");
				dispatch.forward(request, response);
				}
			catch (Exception e) {
				
				request.setAttribute("error", "Sql Error: Something went wrong-searchByLName(lname)");
				RequestDispatcher dispatch = request
						.getRequestDispatcher("/pages/error.jsp");
				dispatch.forward(request, response);
			}
			
		}

			if(category.equalsIgnoreCase("department")){
				
				
				try {
					String dept = request.getParameter("srch");
					
					list =service.searchByDept(dept);		
							
					request.setAttribute("empList", list);
					RequestDispatcher dispatch = request.getRequestDispatcher("/pages/viewByEmp.jsp");
					dispatch.forward(request, response);
					
					
				}catch (EmployeeException e) {

					request.setAttribute("error", e.getMessage());
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/error.jsp");
					dispatch.forward(request, response);
					}
				catch (Exception e) {
					
					request.setAttribute("error", "Sql Error: Something went wrong-searchByDept(dept)");
					RequestDispatcher dispatch = request
							.getRequestDispatcher("/pages/error.jsp");
					dispatch.forward(request, response);
				}
				
			}

			if(category.equalsIgnoreCase("grade")){
			
			
			try {
				String grade = request.getParameter("srch");
				
				list =service.searchByGrade(grade);
			
				request.setAttribute("empList", list);
				
				RequestDispatcher dispatch = request.getRequestDispatcher("/pages/viewByEmp.jsp");
				dispatch.forward(request, response);
				
				
			} catch (EmployeeException e) {

				request.setAttribute("error", e.getMessage());
				RequestDispatcher dispatch = request
						.getRequestDispatcher("/pages/error.jsp");
				dispatch.forward(request, response);
				}
			catch (Exception e) {
				
				request.setAttribute("error", "Sql Error: Something went wrong-searchByGrade(grade)");
				RequestDispatcher dispatch = request
						.getRequestDispatcher("/pages/error.jsp");
				dispatch.forward(request, response);
			}
			
		}

		
			if(category.equalsIgnoreCase("status")){
			
			try {
				String status = request.getParameter("srch");
			
				list =service.searchByMaritalStatus(status);
							
				request.setAttribute("empList", list);
				///Page name....
				RequestDispatcher dispatch = request.getRequestDispatcher("/pages/viewByEmp.jsp");
				dispatch.forward(request, response);
				
				
			} catch (EmployeeException e) {

				request.setAttribute("error", e.getMessage());
			RequestDispatcher dispatch = request
						.getRequestDispatcher("/pages/error.jsp");
				dispatch.forward(request, response);
				}
			catch (Exception e) {
			
				request.setAttribute("error", "Sql Error: Something went wrong-searchByMaritalStatus(status)");
				RequestDispatcher dispatch = request
						.getRequestDispatcher("/pages/error.jsp");
				dispatch.forward(request, response);
			}
			
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
