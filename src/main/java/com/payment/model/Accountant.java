package com.payment.model;

public class Accountant {
	private int accountantId;
	private String name;
	private int salary;
	private int phone;
	private String email;
	private char activeStatus;
	private int branchId;

	@Override
	public String toString() {
		return "Accountant [accountantId=" + accountantId + ", name=" + name + ", salary=" + salary + ", phone=" + phone
				+ ", email=" + email + ", activeStatus=" + activeStatus + ", branchId=" + branchId + "]";
	}

	public int getAccountantId() {
		return accountantId;
	}

	public void setAccountantId(int accountantId) {
		this.accountantId = accountantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(char activeStatus) {
		this.activeStatus = Character.toUpperCase(activeStatus);
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

}
