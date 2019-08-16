package com.payment.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;
import com.payment.model.Accountant;
import com.payment.model.Login;
import com.payment.model.Student;

@Repository
public class DaoImpl implements Dao {

	public int loginValidate(Connection conn, Login login) {
		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();

			if (login.getUserType().equals("accountant")) {
				String sql = "SELECT num_accountant_id, vch_accountant_password FROM login where chr_active_status ='Y'";
				ResultSet rs = statement.executeQuery(sql);
				System.out.println(rs.getFetchSize());

				while (rs.next()) {

					int id = rs.getInt("num_accountant_id");
					String password = rs.getString("vch_accountant_password");
					if ((Integer.parseInt(login.getUserName())) == id && (login.getPassword()).equals(password)) {
						return 1; // Accountant return 1
					}
				}
			}
			if (login.getUserType().equals("admin")) {
				String sql = "SELECT num_administrator_id , vch_administrator_password FROM login where chr_active_status ='Y'";
				ResultSet rs = statement.executeQuery(sql);
				System.out.println(rs.getFetchSize());

				while (rs.next()) {

					int id = rs.getInt("num_administrator_id");
					String password = rs.getString("vch_administrator_password");
					if ((Integer.parseInt(login.getUserName())) == id && (login.getPassword()).equals(password)) {
						return 0; // Admin return 0
					}
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return -1; // Invalid return -1
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
				student.setActiveStatus(rs.getString("chr_active_status").charAt(0));
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

	public boolean createAccountant(Connection conn, Accountant accountant) {
		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String sql = "Insert into accountant(num_accountant_id,vch_accountant_name,num_accountant_salary,num_accountant_phone,vch_accountant_email,num_accountant_branch_id) values("
					+ accountant.getAccountantId() + ",'" + accountant.getName() + "'," + accountant.getSalary() + ","
					+ accountant.getPhone() + ",'" + accountant.getEmail() + "'," + accountant.getBranchId() + ")";
			statement.executeUpdate(sql);
			String sql1 = "Insert into login(num_accountant_id,vch_accountant_password)values(" + accountant.getAccountantId() + ",'" + accountant.getName() +  "')";
			statement.executeUpdate(sql1);
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

	public boolean updateAccountant(Connection conn, int accountantId, Accountant accountant) {
		Statement statement = null;
		try {

			statement = (Statement) conn.createStatement();
			String sql = "Update accountant set vch_accountant_name='" + accountant.getName()
					+ "',num_accountant_salary=" + accountant.getSalary() + ",num_accountant_phone="
					+ accountant.getPhone() + ",vch_accountant_email='" + accountant.getEmail()
					+ "',num_accountant_branch_id=" + accountant.getBranchId() + ",chr_accountant_active_status='"
					+ accountant.getActiveStatus() + "' where num_accountant_id=" + accountantId;
			statement.executeUpdate(sql);
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		}

	}

	public Accountant searchAccountant(Connection conn, int accountantId) {
		Statement statement = null;
		Accountant accountant = new Accountant();
		try {

			System.out.println(accountantId + "DAO");
			statement = (Statement) conn.createStatement();
			String sql = "Select * from accountant where num_accountant_id=" + accountantId;
			ResultSet rs = statement.executeQuery(sql);
			accountant.setAccountantId(accountantId);
			while (rs.next()) {
//			System.out.println(rs.getString("vch_student_name"));
				accountant.setName(rs.getString("vch_accountant_name"));
				accountant.setSalary(rs.getInt("num_accountant_salary"));
				accountant.setPhone(rs.getInt("num_accountant_phone"));
				accountant.setEmail(rs.getString("vch_accountant_email"));
				accountant.setBranchId(rs.getInt("num_accountant_branch_id"));
				accountant.setActiveStatus(rs.getString("chr_accountant_active_status").charAt(0));
			}
			return accountant;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		} catch (Exception e) {
			return null;
		}
	}

	public boolean deleteAccountant(Connection conn, int accountantId) {
		Statement statement = null;
		try {
			statement = (Statement) conn.createStatement();
			String sql = "Update accountant set chr_accountant_active_status='N' where num_accountant_id="
					+ accountantId;
			statement.executeUpdate(sql);
			String sql1 = "Update login set chr_active_status='N' where num_accountant_id="
					+ accountantId;
			statement.executeUpdate(sql1);
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}
}