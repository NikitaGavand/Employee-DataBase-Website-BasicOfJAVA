package com.cg.empmaintenance.dto;

public class DepartmentBean {

	private int deptId;
	private String deptName;

	// getters and setters

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "GradeMasterBean [deptId=" + deptId + ", deptName=" + deptName
				+ "]";
	}

}
