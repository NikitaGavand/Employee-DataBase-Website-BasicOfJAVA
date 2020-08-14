package com.cg.empmaintenance.dao;

import java.util.ArrayList;

import com.cg.empmaintenance.dto.EmployeeBean;
import com.cg.empmaintenance.exception.EmployeeException;

public interface EmployeeDAO {
	
	ArrayList<EmployeeBean> searchById(String id) throws EmployeeException;
	
	ArrayList<EmployeeBean> searchByFName(String fname) throws EmployeeException;

	ArrayList<EmployeeBean> searchByLName(String lname) throws EmployeeException;

	ArrayList<EmployeeBean> searchByDept(String deptId) throws EmployeeException;

	ArrayList<EmployeeBean> searchByGrade(String grade) throws EmployeeException;

	ArrayList<EmployeeBean> searchByMaritalStatus(String status)
			throws EmployeeException;

	
	
}
