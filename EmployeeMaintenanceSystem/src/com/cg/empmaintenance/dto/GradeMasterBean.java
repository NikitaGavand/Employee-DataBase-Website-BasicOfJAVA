package com.cg.empmaintenance.dto;

public class GradeMasterBean {

	private String gradeCode;
	private String description;
	private int minSalary;
	private int maxSalary;

	
	//getters and setters
	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}

	@Override
	public String toString() {
		return "GradeMasterBean [gradeCode=" + gradeCode + ", description="
				+ description + ", minSalary=" + minSalary + ", maxSalary="
				+ maxSalary + "]";
	}

}
