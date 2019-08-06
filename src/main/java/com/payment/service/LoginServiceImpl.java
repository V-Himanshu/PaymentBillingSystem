package com.payment.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.payment.dao.LoginDaoImpl;
import com.payment.model.Login;

@Service
public class LoginServiceImpl implements LoginService{

	LoginDaoImpl loginDaoImpl = new LoginDaoImpl();

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/paymentbillingsystem";

	static final String USER = "root";
	static final String PASS = "";

	public boolean loginValidation(Login login) {

		Connection conn = null;
		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Connected database successfully...");

			if (loginDaoImpl.loginValidate(conn, login)) {
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

}
