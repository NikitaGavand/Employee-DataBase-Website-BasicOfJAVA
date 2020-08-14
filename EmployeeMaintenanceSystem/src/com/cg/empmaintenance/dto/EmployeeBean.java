package com.cg.empmaintenance.dto;

import java.time.LocalDate;

public class EmployeeBean {
	private int empId;
	private String firstName;
	private String lastName;
	private LocalDate empDob;
	private LocalDate empDoj;
	private int deptId;
	private String grade;
	private String designation;
	private int salary;
	private String gender;
	private String maritalStatus;
	private String address;
	private String contactNo;

	//getters and setters
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getEmpDob() {
		return empDob;
	}

	public void setEmpDob(LocalDate empDob) {
		this.empDob = empDob;
	}

	public LocalDate getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(LocalDate empDoj) {
		this.empDoj = empDoj;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", empDob=" + empDob + ", empDoj="
				+ empDoj + ", deptId=" + deptId + ", grade=" + grade
				+ ", designation=" + designation + ", salary=" + salary
				+ ", gender=" + gender + ", maritalStatus=" + maritalStatus
				+ ", address=" + address + ", contactNo=" + contactNo + "]";
	}

}
