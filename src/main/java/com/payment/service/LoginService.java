package com.payment.service;

import com.payment.model.Accountant;
import com.payment.model.Login;
import com.payment.model.Student;

public interface LoginService {

	public int loginValidation(Login login);

	public boolean createStudent(Student student);

	public Student searchStudent(int registerNumber);

	public boolean updateStudent(int registerNumber, Student student);

	public boolean deleteStudent(int registerNumber);

	public boolean createAccountant(Accountant accountant);

	public boolean updateAccountant(int registerNumber, Accountant accountant);

	public Accountant searchAccountant(int accountantId);
}
