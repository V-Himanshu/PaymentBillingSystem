package com.payment.model;

public class Student {
	int registerNumber;
	String name;
	int departmentId;
	int branchid;
	String email;
	int phone;
	int parentPhone;
	int modifiedByAccountant;

	public int getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(int registerNumber) {
		this.registerNumber = registerNumber;
	}

	@Override
	public String toString() {
		return "Student [registerNumber=" + registerNumber + ", name=" + name + ", departmentId=" + departmentId
				+ ", branchid=" + branchid + ", email=" + email + ", phone=" + phone + ", parentPhone=" + parentPhone
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

	public int getBranchid() {
		return branchid;
	}

	public void setBranchid(int branchid) {
		this.branchid = branchid;
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
}
