package com.cg.empmaintenance.service;

import java.util.ArrayList;

import com.cg.empmaintenance.dto.EmployeeBean;
import com.cg.empmaintenance.dto.UserMasterBean;
import com.cg.empmaintenance.exception.EmployeeException;

public interface AdminService {
	public void insertDetails(EmployeeBean bean, String dept)
			throws EmployeeException;

	public void modifyDetails(EmployeeBean bean, String deptname)
			throws EmployeeException;

	public void deleteDetails(int empid) throws EmployeeException;

	public ArrayList<EmployeeBean> displayAll() throws EmployeeException;

	public String validateLogin(String userName, String password)
			throws EmployeeException;

	public ArrayList<String> getDeptName() throws EmployeeException;

	public EmployeeBean getEmpById(int id) throws EmployeeException;

	public boolean validateSalary(EmployeeBean emp) throws EmployeeException;

	public int insertLogin(UserMasterBean bean) throws EmployeeException;

	public String findDeptName(int deptId) throws EmployeeException;

	public ArrayList<String> getGrades() throws EmployeeException;
}
