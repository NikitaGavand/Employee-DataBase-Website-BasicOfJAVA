package com.cg.empmaintenance.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cg.empmaintenance.dto.EmployeeBean;
import com.cg.empmaintenance.exception.EmployeeException;
import com.cg.empmaintenance.logger.MyLogger;
import com.cg.empmaintenance.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDAO {

	AdminDAOImpl dao1 = new AdminDAOImpl();
	Connection con;
	Logger logger = MyLogger.getLoggerInstance();

	public EmployeeDaoImpl() {

		con = DBUtil.getConnect();
	}

	/**
	 * Method name:searchById() Parameters: String Return
	 * type:ArrayList<EmployeeBean> Description:This method is used to search
	 * Employee by Id
	 */
	@Override
	public ArrayList<EmployeeBean> searchById(String idPattern)
			throws EmployeeException {

		int empid;
		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();

		try {

			String sql = "SELECT * FROM Employee WHERE Emp_ID LIKE ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idPattern);

			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				EmployeeBean obj = new EmployeeBean();
				empid = result.getInt(1);
				String firstname = result.getString(2);
				String lastname = result.getString(3);

				int deptid = result.getInt(6);
				String grade = result.getString(7);

				String designation = result.getString(8);
				int salary = result.getInt(9);
				String gender = result.getString(10);
				String maritalstatus = result.getString(11);
				String address = result.getString(12);
				String contactno = result.getString(13);

				obj.setEmpId(empid);
				obj.setFirstName(firstname);
				obj.setLastName(lastname);

				obj.setDeptId(deptid);
				obj.setGrade(grade);
				obj.setDesignation(designation);
				obj.setSalary(salary);
				obj.setGender(gender);
				obj.setMaritalStatus(maritalstatus);
				obj.setAddress(address);
				obj.setContactNo(contactno);

				list.add(obj);

			}
			logger.info("Below are the records fetched:");
			for (EmployeeBean obj : list) {
				logger.info(obj);
			}
		} catch (Exception e) {

			logger.error("No Details available for the id : " + idPattern);
			throw new EmployeeException("\nSorry No Details Found.");
		}
		return list;

	}

	/**
	 * Method name:searchByFName() Parameters: String Return
	 * type:ArrayList<EmployeeBean> Description:This method is used to search
	 * Employee by First Name
	 */
	@Override
	public ArrayList<EmployeeBean> searchByFName(String fnamePattern)
			throws EmployeeException {

		// String fname =fnamePattern+"%";
		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();

		try {

			String sql = "SELECT * FROM Employee WHERE Emp_First_Name LIKE ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fnamePattern);

			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				EmployeeBean obj = new EmployeeBean();
				int empid = result.getInt(1);
				String firstname = result.getString(2);
				String lastname = result.getString(3);

				int deptid = result.getInt(6);
				String grade = result.getString(7);

				String designation = result.getString(8);
				int salary = result.getInt(9);
				String gender = result.getString(10);
				String maritalstatus = result.getString(11);
				String address = result.getString(12);
				String contactno = result.getString(13);

				obj.setEmpId(empid);
				obj.setFirstName(firstname);
				obj.setLastName(lastname);

				obj.setDeptId(deptid);
				obj.setGrade(grade);
				obj.setDesignation(designation);
				obj.setSalary(salary);
				obj.setGender(gender);
				obj.setMaritalStatus(maritalstatus);
				obj.setAddress(address);
				obj.setContactNo(contactno);

				list.add(obj);

			}
			logger.info("Below are the records fetched:");
			for (EmployeeBean obj : list) {
				logger.info(obj);
			}
		} catch (Exception e) {

			logger.error("No Details available for the first name : "
					+ fnamePattern);
			throw new EmployeeException("\nSorry No Details Found.");
		}
		return list;

	}

	/**
	 * Method name:searchByLName() Parameters: String Return
	 * type:ArrayList<EmployeeBean> Description:This method is used to search
	 * Employee by Last Name
	 */
	@Override
	public ArrayList<EmployeeBean> searchByLName(String lnamePattern)
			throws EmployeeException {

		// String lname =lnamePattern+"%";
		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();

		try {

			String sql = "SELECT * FROM Employee WHERE Emp_Last_Name LIKE ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lnamePattern);

			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				EmployeeBean obj = new EmployeeBean();
				int empid = result.getInt(1);
				String firstname = result.getString(2);
				String lastname = result.getString(3);

				Date sqlDate = result.getDate(4);
				LocalDate empdob = sqlDate.toLocalDate();

				Date sqlDate1 = result.getDate(5);
				LocalDate empdoj = sqlDate1.toLocalDate();
				int deptid = result.getInt(6);
				String grade = result.getString(7);

				String designation = result.getString(8);
				int salary = result.getInt(9);
				String gender = result.getString(10);
				String maritalstatus = result.getString(11);
				String address = result.getString(12);
				String contactno = result.getString(13);

				obj.setEmpId(empid);
				obj.setFirstName(firstname);
				obj.setLastName(lastname);
				obj.setEmpDob(empdob);
				obj.setEmpDoj(empdoj);
				obj.setDeptId(deptid);
				obj.setGrade(grade);
				obj.setDesignation(designation);
				obj.setSalary(salary);
				obj.setGender(gender);
				obj.setMaritalStatus(maritalstatus);
				obj.setAddress(address);
				obj.setContactNo(contactno);

				list.add(obj);

			}
			logger.info("Below are the records fetched:");
			for (EmployeeBean obj1 : list) {
				logger.info(obj1);
			}
		} catch (Exception e) {

			logger.error("No Details available for the last name : "
					+ lnamePattern);
			throw new EmployeeException("\nSorry No Details Found.");
		}
		return list;

	}

	/**
	 * Method name:searchByDept() Parameters: String Return
	 * type:ArrayList<EmployeeBean> Description:This method is used to search
	 * Employee by Department Id
	 */
	@Override
	public ArrayList<EmployeeBean> searchByDept(String deptId)
			throws EmployeeException {

		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();

		try

		{

			String sql = "SELECT * FROM Employee WHERE Emp_Dept_ID  IN(?)";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, deptId);
			ResultSet result = pstmt.executeQuery();

			while (result.next()) {

				EmployeeBean obj = new EmployeeBean();
				int empid = result.getInt(1);
				String firstname = result.getString(2);
				String lastname = result.getString(3);

				int deptid = result.getInt(6);
				String grade = result.getString(7);

				String designation = result.getString(8);
				int salary = result.getInt(9);
				String gender = result.getString(10);
				String maritalstatus = result.getString(11);
				String address = result.getString(12);
				String contactno = result.getString(13);

				obj.setEmpId(empid);
				obj.setFirstName(firstname);
				obj.setLastName(lastname);

				obj.setDeptId(deptid);
				obj.setGrade(grade);
				obj.setDesignation(designation);
				obj.setSalary(salary);
				obj.setGender(gender);
				obj.setMaritalStatus(maritalstatus);
				obj.setAddress(address);
				obj.setContactNo(contactno);

				list.add(obj);

			}
			logger.info("Below are the records fetched:");
			for (EmployeeBean obj : list) {
				logger.info(obj);
			}
		}

		catch (Exception e) {

			logger.error("No Details available for Department Id : " + deptId);
			throw new EmployeeException("\nSorry No Details Found.");

		}

		return list;

	}

	/**
	 * Method name:searchByGrade() Parameters: String Return
	 * type:ArrayList<EmployeeBean> Description:This method is used to search
	 * Employee by Grade
	 */
	@Override
	public ArrayList<EmployeeBean> searchByGrade(String grade)
			throws EmployeeException {

		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();

		try

		{

			String sql = "SELECT * FROM Employee WHERE Emp_Grade IN (?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, grade);
			ResultSet result = pstmt.executeQuery();

			while (result.next()) {
				EmployeeBean obj = new EmployeeBean();
				int empid = result.getInt(1);
				String firstname = result.getString(2);
				String lastname = result.getString(3);

				Date sqlDate = result.getDate(4);
				LocalDate empdob = sqlDate.toLocalDate();

				Date sqlDate1 = result.getDate(5);
				LocalDate empdoj = sqlDate1.toLocalDate();
				int deptid = result.getInt(6);

				String designation = result.getString(8);
				int salary = result.getInt(9);
				String gender = result.getString(10);
				String maritalstatus = result.getString(11);
				String address = result.getString(12);
				String contactno = result.getString(13);

				obj.setEmpId(empid);
				obj.setFirstName(firstname);
				obj.setLastName(lastname);
				obj.setEmpDob(empdob);
				obj.setEmpDoj(empdoj);
				obj.setDeptId(deptid);
				obj.setGrade(grade);
				obj.setDesignation(designation);
				obj.setSalary(salary);
				obj.setGender(gender);
				obj.setMaritalStatus(maritalstatus);
				obj.setAddress(address);
				obj.setContactNo(contactno);

				list.add(obj);

			}
			logger.info("Below are the records fetched:");
			for (EmployeeBean obj : list) {
				logger.info(obj);
			}
		}

		catch (Exception e) {

			logger.error("No Details available for grade : " + grade);
			throw new EmployeeException("\nSorry No Details Found.");

		}

		return list;

	}

	/**
	 * Method name:searchByMaritalStatus() Parameters: String Return
	 * type:ArrayList<EmployeeBean> Description:This method is used to search
	 * Employee by Marital Status
	 */
	@Override
	public ArrayList<EmployeeBean> searchByMaritalStatus(String status)
			throws EmployeeException {

		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();

		try

		{

			String sql = "SELECT * FROM Employee WHERE Emp_Marital_Status=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, status);
			ResultSet result = pstmt.executeQuery();

			while (result.next()) {
				EmployeeBean obj = new EmployeeBean();
				int empid = result.getInt(1);
				String firstname = result.getString(2);
				String lastname = result.getString(3);

				Date sqlDate = result.getDate(4);
				LocalDate empdob = sqlDate.toLocalDate();

				Date sqlDate1 = result.getDate(5);
				LocalDate empdoj = sqlDate1.toLocalDate();
				int deptid = result.getInt(6);
				String grade = result.getString(7);
				String designation = result.getString(8);
				int salary = result.getInt(9);
				String gender = result.getString(10);
				String maritalstatus = result.getString(11);
				String address = result.getString(12);
				String contactno = result.getString(13);

				obj.setEmpId(empid);
				obj.setFirstName(firstname);
				obj.setLastName(lastname);
				obj.setEmpDob(empdob);
				obj.setEmpDoj(empdoj);
				obj.setDeptId(deptid);
				obj.setGrade(grade);
				obj.setDesignation(designation);
				obj.setSalary(salary);
				obj.setGender(gender);
				obj.setMaritalStatus(maritalstatus);
				obj.setAddress(address);
				obj.setContactNo(contactno);

				list.add(obj);

			}
			logger.info("Below are the records fetched:");
			for (EmployeeBean obj : list) {
				logger.info(obj);
			}
		}

		catch (Exception e) {

			logger.error("No Details available for status : " + status);
			throw new EmployeeException("\nSorry No Details Found.");

		}

		return list;

	}
}