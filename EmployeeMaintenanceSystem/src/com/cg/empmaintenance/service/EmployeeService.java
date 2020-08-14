package com.cg.empmaintenance.service;

import java.util.ArrayList;

import com.cg.empmaintenance.dto.EmployeeBean;
import com.cg.empmaintenance.exception.EmployeeException;

public interface EmployeeService {
ArrayList<EmployeeBean> searchById(String eid) throws EmployeeException;
	
	ArrayList<EmployeeBean> searchByFName(String fname) throws EmployeeException;

	ArrayList<EmployeeBean> searchByLName(String lname) throws EmployeeException;

	ArrayList<EmployeeBean> searchByDept(String deptId) throws EmployeeException;

	ArrayList<EmployeeBean> searchByGrade(String grade) throws EmployeeException;

	ArrayList<EmployeeBean> searchByMaritalStatus(String status)
			throws EmployeeException;
}
