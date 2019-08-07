package com.payment.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.payment.dao.LoginDaoImpl;
import com.payment.model.Accountant;
import com.payment.model.Login;
import com.payment.model.Student;

@Service
public class LoginServiceImpl implements LoginService {

	LoginDaoImpl loginDaoImpl = new LoginDaoImpl();

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/paymentbillingsystem";

	static final String USER = "root";
	static final String PASS = "";

	public int loginValidation(Login login) {

		Connection conn = null;
		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Connected database successfully...");

			
			return loginDaoImpl.loginValidate(conn, login);
			

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return -1;
	}

	public boolean createStudent(Student student) {
		Connection conn = null;
		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Connected database successfully...");
			if (loginDaoImpl.create(conn, student)) {
				return true;
			}

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();

		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return false;

	}

	public Student searchStudent(int registerNumber) {
		Connection conn = null;
		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Connected database successfully...");

			Student student;
			student = loginDaoImpl.search(conn, registerNumber);
			return student;

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();

		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return null;
	}

	public boolean updateStudent(int registerNumber, Student student) {
		Connection conn = null;
		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Connected database successfully...");
			loginDaoImpl.update(conn, registerNumber, student);

			return true;

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return false;

		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	public boolean deleteStudent(int registerNumber) {
		Connection conn = null;
		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Connected database successfully...");
			
			loginDaoImpl.delete(conn, registerNumber);

			return true;

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return false;

		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public boolean createAccountant(Accountant accountant) {
		Connection conn = null;
		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Connected database successfully...");
			if (loginDaoImpl.createAccountant(conn, accountant)) {
				return true;
			}

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();

		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return false;
	}

	public boolean updateAccountant(int registerNumber, Accountant accountant) {
		Connection conn = null;
		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Connected database successfully...");
			loginDaoImpl.updateAccountant(conn, registerNumber, accountant);

			return true;

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return false;

		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public Accountant searchAccountant(int accountantId) {
		Connection conn = null;
		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Connected database successfully...");

			Accountant accountant;
			accountant = loginDaoImpl.searchAccountant(conn, accountantId);
			return accountant;

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();

		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return null;
	}

}
