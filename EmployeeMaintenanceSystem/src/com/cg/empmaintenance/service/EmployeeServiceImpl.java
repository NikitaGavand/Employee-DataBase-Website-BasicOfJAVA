package com.cg.empmaintenance.service;

import java.util.ArrayList;




import com.cg.empmaintenance.dao.AdminDAO;
import com.cg.empmaintenance.dao.EmployeeDAO;
import com.cg.empmaintenance.dao.EmployeeDaoImpl;
import com.cg.empmaintenance.dto.EmployeeBean;
import com.cg.empmaintenance.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO dao;
	
	

	public EmployeeServiceImpl()
	{
		dao = new EmployeeDaoImpl();
		}
	
	@Override
	public ArrayList<EmployeeBean> searchByLName(String lname)
			throws EmployeeException {
		
		return dao.searchByLName(lname);
	}
	@Override
	public ArrayList<EmployeeBean> searchByDept(String deptId)
			throws EmployeeException {
		
		return dao.searchByDept(deptId);
	}
	@Override
	public ArrayList<EmployeeBean> searchByGrade(String grade)
			throws EmployeeException {
	
		return dao.searchByGrade(grade);
	}
	@Override
	public ArrayList<EmployeeBean> searchByMaritalStatus(String status)
			throws EmployeeException {
		
		return dao.searchByMaritalStatus(status);
	}


	@Override
	public ArrayList<EmployeeBean> searchById(String eid)
			throws EmployeeException {
		
		return dao.searchById(eid);
	}




	@Override
	public ArrayList<EmployeeBean> searchByFName(String fname)
			throws EmployeeException {
		
		return dao.searchByFName(fname);
	}


}
