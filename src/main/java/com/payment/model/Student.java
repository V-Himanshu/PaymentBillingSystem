package com.payment.model;

public class Student {

	int registerNumber;
	String studentName;
	String department;
	String branch;
	String email;
	int phone;
	int parentPhone;
	int modifiedByAccountantId;
	int feeId;
	int totalFee;
	@Override
	public String toString() {
		return "Student [registerNumber=" + registerNumber + ", studentName=" + studentName + ", department="
				+ department + ", branch=" + branch + ", email=" + email + ", phone=" + phone + ", parentPhone="
				+ parentPhone + ", modifiedByAccountantId=" + modifiedByAccountantId + ", feeId=" + feeId
				+ ", totalFee=" + totalFee + ", paidFee=" + paidFee + "]";
	}

	int paidFee;

	public int getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(int registerNumber) {
		this.registerNumber = registerNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
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

	public int getModifiedByAccountantId() {
		return modifiedByAccountantId;
	}

	public void setModifiedByAccountantId(int modifiedByAccountantId) {
		this.modifiedByAccountantId = modifiedByAccountantId;
	}

	public int getFeeId() {
		return feeId;
	}

	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}

	public int getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public int getPaidFee() {
		return paidFee;
	}

	public void setPaidFee(int paidFee) {
		this.paidFee = paidFee;
	}

}
