package com.cg.empmaintenance.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cg.empmaintenance.exception.EmployeeException;
import com.cg.empmaintenance.service.AdminService;
import com.cg.empmaintenance.service.AdminServiceImpl;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter(urlPatterns={"/LoginController"})
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
	AdminService service;
    public AuthFilter() {
        
    	service=new AdminServiceImpl();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		System.out.println(session.getId());
		
		
		String para = request.getParameter("action");

		if ("loginuser".equalsIgnoreCase(para)||"logout".equalsIgnoreCase(para)) 
		{
			chain.doFilter(request, response);
		} 
	
		else if ("login".equalsIgnoreCase(para))
		{
			String userName = request.getParameter("username");
			String password = request.getParameter("pwd");

			String type = null;
			try {
						type = service.validateLogin(userName, password);
					
						if (type == "Admin") 
						{
							System.out.println(session.isNew());
						
							session.setAttribute("login", userName);
							chain.doFilter(request, response);
						} 
						else if (type == "Employee") 
						{
							System.out.println(session.isNew());
							
							session.setAttribute("login", userName);
							chain.doFilter(request, response);
						} 
				        // pass the request along the filter chain
						else 
						{
							request.setAttribute("loginMsg",
									"Username or Password is incorrect");
							RequestDispatcher dispatch = request
									.getRequestDispatcher("/pages/loginuser.jsp");
							dispatch.forward(request, response);
						}
				}
				catch (EmployeeException e) 
				{
				
					request.setAttribute("err", e.getMessage());
					RequestDispatcher dis = request.getRequestDispatcher("/pages/loginuser.jsp");
					dis.forward(request, response);
				}
		  }	
		
		else if ("add".equalsIgnoreCase(para)) 
		{
			if (session.isNew() == false)
			{
				System.out.println(session.getId());
				chain.doFilter(request, response);
			}
			else 
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/loginuser.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if ("modify".equalsIgnoreCase(para)) 
		{
			if (session.isNew() == false)
			{
				System.out.println(session.getId());
				chain.doFilter(request, response);
			}
			else 
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/loginuser.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if ("update".equalsIgnoreCase(para)) 
		{
			if (session.isNew() == false)
			{
				System.out.println(session.getId());
				chain.doFilter(request, response);
			}
			else 
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/loginuser.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if ("delete".equalsIgnoreCase(para)) 
		{
			if (session.isNew() == false)
			{
				System.out.println(session.getId());
				chain.doFilter(request, response);
			}
			else 
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/loginuser.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		else if ("view".equalsIgnoreCase(para)) 
		{
			if (session.isNew() == false)
			{
				System.out.println(session.getId());
				chain.doFilter(request, response);
			}
			else 
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/loginuser.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		else if ("updateValues".equalsIgnoreCase(para)) 
		{
			if (session.isNew() == false)
			{
				System.out.println(session.getId());
				chain.doFilter(request, response);
			}
			else 
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/loginuser.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if ("insert".equalsIgnoreCase(para)) 
		{
			if (session.isNew() == false)
			{
				System.out.println(session.getId());
				chain.doFilter(request, response);
			}
			else 
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/loginuser.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		else if ("display".equalsIgnoreCase(para)) 
		{
			if (session.isNew() == false)
			{
				System.out.println(session.getId());
				chain.doFilter(request, response);
			}
			else 
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/loginuser.jsp");
				dispatcher.forward(request, response);
			}
		}
	
		
	  }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
