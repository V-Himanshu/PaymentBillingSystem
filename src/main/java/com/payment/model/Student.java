package com.payment.model;

public class Student {
	private int registerNumber;
	private String name;
	private int departmentId;
	private int branchId;
	private String email;
	private int phone;
	private int parentPhone;
	private int modifiedByAccountant;
	private char activeStatus;

	public int getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(int registerNumber) {
		this.registerNumber = registerNumber;
	}

	@Override
	public String toString() {
		return "Student [registerNumber=" + registerNumber + ", name=" + name + ", departmentId=" + departmentId
				+ ", branchid=" + branchId + ", email=" + email + ", phone=" + phone + ", parentPhone=" + parentPhone
				+ ", modifiedByAccountant=" + modifiedByAccountant + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchid) {
		this.branchId = branchid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getParentPhone() {
		return parentPhone;
	}

	public void setParentPhone(int parentPhone) {
		this.parentPhone = parentPhone;
	}

	public int getModifiedByAccountant() {
		return modifiedByAccountant;
	}

	public void setModifiedByAccountant(int modifiedByAccountant) {
		this.modifiedByAccountant = modifiedByAccountant;
	}

	public char getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(char activeStatus) {
		this.activeStatus = Character.toUpperCase(activeStatus);
	}
}
