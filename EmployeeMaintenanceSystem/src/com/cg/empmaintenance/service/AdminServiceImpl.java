package com.cg.empmaintenance.service;

import java.util.ArrayList;

import com.cg.empmaintenance.dao.AdminDAOImpl;
import com.cg.empmaintenance.dao.AdminDAO;
import com.cg.empmaintenance.dto.EmployeeBean;
import com.cg.empmaintenance.dto.UserMasterBean;
import com.cg.empmaintenance.exception.EmployeeException;

public class AdminServiceImpl implements AdminService {

	private AdminDAO dao;

	public AdminDAO getDao() {
		return dao;
	}

	public void setDao(AdminDAO dao) {
		this.dao = dao;
	}

	public AdminServiceImpl() {
		dao = new AdminDAOImpl();

	}

	@Override
	public void insertDetails(EmployeeBean bean, String dept)
			throws EmployeeException {

		dao.insertDetails(bean, dept);
	}

	@Override
	public void modifyDetails(EmployeeBean bean, String deptname)
			throws EmployeeException {

		dao.modifyDetails(bean, deptname);
	}

	@Override
	public void deleteDetails(int empid) throws EmployeeException {

		dao.deleteDetails(empid);
	}

	@Override
	public ArrayList<EmployeeBean> displayAll() throws EmployeeException {
		return dao.displayAll();
	}

	@Override
	public String validateLogin(String userName, String password)
			throws EmployeeException {

		return dao.validateLogin(userName, password);
	}

	@Override
	public ArrayList<String> getDeptName() throws EmployeeException {

		return dao.getDeptName();
	}

	@Override
	public EmployeeBean getEmpById(int id) throws EmployeeException {

		return dao.getEmpById(id);
	}

	@Override
	public boolean validateSalary(EmployeeBean emp) throws EmployeeException {

		int salary = emp.getSalary();
		if (emp.getGrade().equalsIgnoreCase("M1")
				&& (salary >= 5000 && salary <= 9999)) {
			return true;

		}
		if (emp.getGrade().equalsIgnoreCase("M2")
				&& (salary >= 10000 && salary <= 19999)) {
			return true;

		}
		if (emp.getGrade().equalsIgnoreCase("M3")
				&& (salary >= 20000 && salary <= 39999)) {
			return true;

		}
		if (emp.getGrade().equalsIgnoreCase("M4")
				&& (salary >= 40000 && salary <= 59999)) {
			return true;

		}
		if (emp.getGrade().equalsIgnoreCase("M5")
				&& (salary >= 60000 && salary <= 79999)) {
			return true;

		}
		if (emp.getGrade().equalsIgnoreCase("M6")
				&& (salary >= 80000 && salary <= 99999)) {
			return true;

		}
		if (emp.getGrade().equalsIgnoreCase("M7")
				&& (salary >= 100000 && salary <= 500000)) {
			return true;

		} else
			return false;
	}

	@Override
	public int insertLogin(UserMasterBean bean) throws EmployeeException {

		return dao.insertLogin(bean);
	}

	@Override
	public String findDeptName(int deptId) throws EmployeeException {
		
		return dao.findDeptName(deptId);
	}

	@Override
	public ArrayList<String> getGrades() throws EmployeeException {
		
		return dao.getGrades();
	}

}
