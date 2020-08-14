package com.cg.empmaintenance.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cg.empmaintenance.dto.DepartmentBean;
import com.cg.empmaintenance.dto.EmployeeBean;
import com.cg.empmaintenance.dto.UserMasterBean;
import com.cg.empmaintenance.exception.EmployeeException;
import com.cg.empmaintenance.util.DBUtil;
import com.cg.empmaintenance.logger.MyLogger;

public class AdminDAOImpl implements AdminDAO {
	Connection con;
	Logger logger = MyLogger.getLoggerInstance();

	public AdminDAOImpl() {

		con = DBUtil.getConnect();
	}

	/**
	 * Method name: validateLogin() Parameters: String, String Return type:
	 * String Description:This method is used to validate login credentials
	 */
	@Override
	public String validateLogin(String userName, String password)
			throws EmployeeException {

		String etype = null;
		String query = "SELECT UserType FROM User_Master WHERE UserName  = ? AND UserPassword =?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			ResultSet res = pstmt.executeQuery();

			if (res.next()) {
				if (res.getString(1).equalsIgnoreCase("Admin")) {
					etype = "Admin";
					logger.info("Logged into Admin");
				} else if (res.getString(1).equalsIgnoreCase("Employee")) {
					etype = "Employee";
					logger.info("Logged into Employee");
				}
			} else {

				logger.error("wrong login credentials");
				return null;
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return etype;

	}

	/**
	 * Method name: insertDetails() Parameters: EmployeeBean, String Return
	 * type: void Description:This method is used to add details
	 */

	@Override
	public void insertDetails(EmployeeBean bean, String dept)
			throws EmployeeException {

		try {
			String sql = "INSERT INTO Employee VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			int empid = getEmpId();
			bean.setEmpId(empid);
			pstmt.setInt(1, empid);
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			LocalDate dob = bean.getEmpDob();
			Date sqlDate = Date.valueOf(dob);
			pstmt.setDate(4, sqlDate);
			LocalDate doj = bean.getEmpDoj();
			Date sqlDate1 = Date.valueOf(doj);
			pstmt.setDate(5, sqlDate1);
			pstmt.setInt(6, findDeptid(dept));
			pstmt.setString(7, bean.getGrade());
			pstmt.setString(8, bean.getDesignation());
			pstmt.setLong(9, bean.getSalary());
			pstmt.setString(10, bean.getGender());
			pstmt.setString(11, bean.getMaritalStatus());
			pstmt.setString(12, bean.getAddress());
			pstmt.setString(13, bean.getContactNo());
			int row = pstmt.executeUpdate();
			if (row == 0) {
				EmployeeException e = new EmployeeException(
						"not able to insert");

				throw e;
			}

			else {

				logger.info("inserted below record");
				logger.info(bean);
			}
		} catch (SQLException e) {

			logger.error(e.getMessage());
		}

	}

	// Modifying details
	/**
	 * Method name: modifyDetails() Parameters: EmployeeBean, String Return
	 * type: void Description:This method is used to update details
	 */
	@Override
	public void modifyDetails(EmployeeBean bean, String deptname)
			throws EmployeeException {

		int empId = bean.getEmpId();
		try {
			if (validateEmpId(empId)) {

				String query = "UPDATE Employee SET Emp_First_Name =?,Emp_Last_Name =?,Emp_Date_of_Birth =?,Emp_Date_of_Joining =?,Emp_Dept_ID =?,Emp_Grade =?,Emp_Designation =?,Emp_Basic =?,Emp_Gender =?,Emp_Marital_Status =?,Emp_Home_Address =?,Emp_Contact_Num =? WHERE Emp_ID  = ?";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bean.getFirstName());
				pstmt.setString(2, bean.getLastName());

				LocalDate dob = bean.getEmpDob();
				Date sqlDate = Date.valueOf(dob);
				pstmt.setDate(3, sqlDate);
				LocalDate doj = bean.getEmpDoj();
				Date sqlDate1 = Date.valueOf(doj);
				pstmt.setDate(4, sqlDate1);
				pstmt.setInt(5, findDeptid(deptname));
				pstmt.setString(6, bean.getGrade());
				pstmt.setString(7, bean.getDesignation());
				pstmt.setLong(8, bean.getSalary());
				pstmt.setString(9, bean.getGender());
				pstmt.setString(10, bean.getMaritalStatus());
				pstmt.setString(11, bean.getAddress());
				pstmt.setString(12, bean.getContactNo());
				pstmt.setInt(13, empId);
				int row = pstmt.executeUpdate();
				if (row == 0) {
					EmployeeException e = new EmployeeException(
							"not able to update");
					logger.error(e.getMessage());
					throw e;

				} else {

					logger.info("updated record with id=" + bean.getEmpId());

				}
			} else {
				EmployeeException e = new EmployeeException(
						"invalid Employee id");
				logger.error(e.getMessage());
				throw e;
			}
		} catch (SQLException e) {

			logger.error(e.getMessage());
		}
	}

	// deleting details
	/**
	 * Method name:deleteDetails() Parameters: int Return type: void
	 * Description:This method is used to delete details
	 */
	@Override
	public void deleteDetails(int empid) throws EmployeeException {

		try {
			if (validateEmpId(empid)) {
				String sql = "DELETE FROM Employee WHERE Emp_ID  =?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, empid);
				pstmt.executeUpdate();
				logger.info("deleted recored with id=" + empid);

			} else {

				EmployeeException e = new EmployeeException(
						"not able to delete");
				logger.error(e.getMessage());
				throw e;
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());

		}

	}

	// display details
	/**
	 * Method name:displayAll() Parameters: Return type: ArrayList<EmployeeBean>
	 * Description:This method is used to delete details
	 */
	@Override
	public ArrayList<EmployeeBean> displayAll() throws EmployeeException {
		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();

		ArrayList<DepartmentBean> list2 = new ArrayList<DepartmentBean>();
		try {
			String sql = "SELECT Emp_ID,Emp_First_Name,Emp_Last_Name,Emp_Dept_ID,Emp_Grade,Emp_Designation FROM Employee";
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			while (result.next()) {
				EmployeeBean obj = new EmployeeBean();

				int empid = result.getInt(1);
				String firstname = result.getString(2);
				String lastname = result.getString(3);

				int deptid = result.getInt(4);

				String grade = result.getString(5);
				String designation = result.getString(6);

				obj.setEmpId(empid);
				obj.setFirstName(firstname);
				obj.setLastName(lastname);

				obj.setDeptId(deptid);
				obj.setGrade(grade);
				obj.setDesignation(designation);

				list.add(obj);

			}
			if (list.size() != 0) {
				logger.info("Below are the records fetched:");
				for (EmployeeBean obj : list) {
					logger.info(obj);
				}

			} else

				logger.error("list is empty");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return list;

	}

	// generating employee id
	/**
	 * Method name:getEmpId() Parameters: Return type: int Description:This
	 * method is used to generate empid sequence
	 */
	public int getEmpId() {
		int empId = 0;
		try {
			String sql = "SELECT emp_id_seq.nextval FROM DUAL";
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			if (result.next()) {
				empId = result.getInt(1);
			}
			logger.info("Employee generated:" + empId);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return empId;

	}

	// generating userId
	/**
	 * Method name:getUserId() Parameters: Return type: int Description:This
	 * method is used to generate userId sequence
	 */
	public int getUserId() {
		int userId = 0;
		try {
			String sql = "SELECT user_id_seq.nextval FROM DUAL";
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			if (result.next()) {
				userId = result.getInt(1);
			}
			logger.info("UserId generated:" + userId);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return userId;

	}

	// finding dept id from department name
	/**
	 * Method name:findDeptid() Parameters: String Return type: int
	 * Description:This method is used to find deptid from dept name
	 */
	public int findDeptid(String dept) {
		int deptId = 0;

		String sql = "SELECT Dept_ID FROM Department where Dept_Name =?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dept);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				if (res.getInt(1) > 0)
					deptId = res.getInt(1);
				logger.info("Dept Id:" + deptId);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

		return deptId;
	}

	// validating empid
	/**
	 * Method name:validateEmpId() Parameters: int Return type: boolean
	 * Description:This method is used to validate EmpId
	 */
	public boolean validateEmpId(int empid) {

		boolean flag = false;

		String query = "SELECT * FROM Employee WHERE Emp_ID  = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, empid);
			ResultSet res = pstmt.executeQuery();
			if (res.next())
				flag = true;
			logger.info("Valid Employee Id");
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return flag;

	}

	/**
	 * Method name:getDeptName() Parameters: Return type:ArrayList<String>
	 * Description:This method is used to get Department Name
	 */
	@Override
	public ArrayList<String> getDeptName() {
		ArrayList<String> list = new ArrayList<String>();

		String sql = "SELECT Dept_Name  FROM Department ";

		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {

				list.add(res.getString("Dept_Name"));

			}
			logger.info("Department Names");
			logger.info(list);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

		return list;
	}

	/**
	 * Method name:getEmpById() Parameters: int Return type:EmployeeBean
	 * Description:This method is used to get Employee by empId
	 */
	@Override
	public EmployeeBean getEmpById(int id) throws EmployeeException {

		EmployeeBean obj = new EmployeeBean();
		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();

		try {

			String sql = "SELECT * FROM Employee WHERE Emp_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			ResultSet result = pstmt.executeQuery();
			while (result.next()) {

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
				logger.info("Employee with employee id" + id);
				logger.info(obj);
			}

		} catch (Exception e) {

			logger.error("No Details available for the id : " + id);
			throw new EmployeeException("\nSorry No Details Found.");
		}
		return obj;

	}

	/**
	 * Method name:insertLogin() Parameters: UserMasterBean bean Return type:int
	 * Description:This method is used to insert into User_master
	 */
	@Override
	public int insertLogin(UserMasterBean bean) throws EmployeeException {

		int userid = 0;
		try {
			String sql = "INSERT INTO User_master VALUES(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);

			userid = getUserId();
			pstmt.setInt(1, userid);
			pstmt.setString(2, bean.getUsername());
			pstmt.setString(3, bean.getPassword());
			pstmt.setString(4, bean.getType());

			int row = pstmt.executeUpdate();
			if (row == 0) {
				EmployeeException e = new EmployeeException(
						"not able to insert");
				logger.error(e.getMessage());
				throw e;
			}

			else {

				logger.info("Username and Password generated");
				logger.info(bean);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

		return userid;
	}

	@Override
	public String findDeptName(int deptId) throws EmployeeException {

		String sql = "SELECT Dept_Name FROM Department where Dept_ID =?";
		String dName = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptId);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				if (res.getString(1) != null)
					dName = res.getString(1);
			}
			logger.info("Departname found :" + dName);

		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

		return dName;
	}

	@Override
	public ArrayList<String> getGrades() throws EmployeeException {
		ArrayList<String> list = new ArrayList<String>();

		String sql = "SELECT Grade_Code  FROM Grade_master ";

		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {

				list.add(res.getString("Grade_Code"));

			}
			logger.info("Grades:");
			for (String obj : list)
				logger.info(obj);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

		return list;
	}

}
