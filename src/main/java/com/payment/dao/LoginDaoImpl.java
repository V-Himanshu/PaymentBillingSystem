package com.payment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

import org.springframework.stereotype.Repository;
import java.sql.Connection;
import com.payment.model.Login;

@Repository
public class LoginDaoImpl {

	public boolean loginValidate(Connection conn, Login login) {
		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String sql = "SELECT num_accountant_id, vch_accountant_password FROM login where chr_active_status ='Y'";
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("num_accountant_id");
				String password = rs.getString("vch_accountant_password");
				if ((Integer.parseInt(login.getUserName())) == id && (login.getPassword()).equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}
}