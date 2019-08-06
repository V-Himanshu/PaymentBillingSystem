package com.payment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

import org.springframework.stereotype.Repository;
import java.sql.Connection;
import com.payment.model.Login;
import com.payment.model.Student;

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

	public boolean create(Connection conn, Student student) {
		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String sql = "Insert into student(num_student_register_number,vch_student_name,num_student_department_id,vch_student_email ,num_student_phone,num_student_parent_phone,num_modified_by_accountant) values("
					+ student.getRegisterNumber() + ",'" +  student.getName() + "'," + student.getDepartmentId() + 
					  ",'" + student.getEmail() + "'," + student.getPhone() +"," + student.getParentPhone() +"," +
					+ student.getModifiedByAccountant() + ")";
			statement.executeUpdate(sql);
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}
}