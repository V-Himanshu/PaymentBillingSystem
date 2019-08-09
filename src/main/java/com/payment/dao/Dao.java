package com.payment.dao;

import java.sql.Connection;

import com.payment.model.Accountant;
import com.payment.model.Login;
import com.payment.model.Student;

public interface Dao {

	public int loginValidate(Connection conn, Login login);

	public boolean create(Connection conn, Student student);

	public Student search(Connection conn, int registerNumber);

	public boolean update(Connection conn, int registerNumber, Student student);

	public boolean delete(Connection conn, int registerNumber);

	public boolean createAccountant(Connection conn, Accountant accountant);

	public boolean updateAccountant(Connection conn, int accountantId, Accountant accountant);

	public Accountant searchAccountant(Connection conn, int accountantId);

	public boolean deleteAccountant(Connection conn, int accountantId);

}
