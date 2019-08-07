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
			System.out.println(rs.getFetchSize());

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
			String sql = "Insert into student(num_student_register_number,vch_student_name,num_student_department_id,num_student_branch_id,vch_student_email ,num_student_phone,num_student_parent_phone,num_modified_by_accountant) values("
					+ student.getRegisterNumber() + ",'" + student.getName() + "'," + student.getDepartmentId() + ","
					+ student.getBranchId() + ",'" + student.getEmail() + "'," + student.getPhone() + ","
					+ student.getParentPhone() + "," + +student.getModifiedByAccountant() + ")";
			statement.executeUpdate(sql);
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	public Student search(Connection conn, int registerNumber) {
		Statement statement = null;
		Student student = new Student();
		try {

			System.out.println(registerNumber + "DAO");
			statement = (Statement) conn.createStatement();
			String sql = "Select * from student where num_student_register_number=" + registerNumber;
			ResultSet rs = statement.executeQuery(sql);
			student.setRegisterNumber(registerNumber);
			while (rs.next()) {
//			System.out.println(rs.getString("vch_student_name"));
				student.setName(rs.getString("vch_student_name"));
				student.setDepartmentId(rs.getInt("num_student_department_id"));
				student.setBranchId(rs.getInt("num_student_branch_id"));
				student.setEmail(rs.getString("vch_student_email"));
				student.setPhone(rs.getInt("num_student_phone"));
				student.setParentPhone(rs.getInt("num_student_parent_phone"));
				student.setModifiedByAccountant(rs.getInt("num_modified_by_accountant"));
				student.setActiveStatus(rs.getString("chr_active_status"));
			}
			return student;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		} catch (Exception e) {
			return null;
		}

	}

	public boolean update(Connection conn, int registerNumber, Student student) {
		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String sql = "Update student set vch_student_name='" + student.getName() + "', num_student_department_id="
					+ student.getDepartmentId() + ", num_student_branch_id=" + student.getBranchId()
					+ ", vch_student_email='" + student.getEmail() + "', num_student_phone=" + student.getPhone()
					+ ", num_student_parent_phone=" + student.getParentPhone() + ", num_modified_by_accountant="
					+ student.getModifiedByAccountant() + ", chr_active_status='" + student.getActiveStatus()
					+ "' where num_student_register_number=" + student.getRegisterNumber();
			statement.executeUpdate(sql);
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		}

	}

	public boolean delete(Connection conn, int registerNumber) {
		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String sql = "Update student set chr_active_status='N' where num_student_register_number=" + registerNumber;
			statement.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
}