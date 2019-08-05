package com.payment.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.payment.model.Login;

@Controller
public class LoginController {
	
	
	@RequestMapping(value = "/login")
	public String login(Model model)
	{
		Login login=new Login();
		model.addAttribute("login", login);
		return "Login";
	}
	
	// JDBC driver name and database URL 
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
	   static final String DB_URL = "jdbc:mysql://localhost:3306/paymentbillingsystem";  
	   
	   //  Database credentials 
	   static final String USER = "root"; 
	   static final String PASS = ""; 
	   
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse httpServletResponse,
			@ModelAttribute("login")Login login) {
		ModelAndView modelAndView = new ModelAndView("Login");
//		String uname = request.getParameter("userName");
//		String password = request.getParameter("password");
//		if((login.getUserName()).equals("abc") && (login.getPassword()).equals("123")) {
//			modelAndView = new ModelAndView("welcome");
//		}else {
//			modelAndView = new ModelAndView("Login");
//			modelAndView.addObject("message", "Uname and pwd invalid");
//		}
//		System.out.println(login.getUserName() + " " + login.getPassword());
//		modelAndView.addObject("loginpart", login);
		
		   
		      Connection conn = null; 
		      Statement stmt = null; 
		      try { 
		         // STEP 1: Register JDBC driver 
		         Class.forName(JDBC_DRIVER); 
		         
		         // STEP 2: Open a connection 
		         System.out.println("Connecting to database..."); 
		         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
		         
		         // STEP 3: Execute a query 
		         System.out.println("Connected database successfully..."); 
		         stmt = conn.createStatement(); 
		         String sql = "SELECT num_accountant_id, vch_accountant_password FROM login where chr_active_status ='Y'"; 
		         ResultSet rs = stmt.executeQuery(sql); 
		         
		         // STEP 4: Extract data from result set 
		         while(rs.next()) { 
		            // Retrieve by column name 
		            int id  = rs.getInt("num_accountant_id"); 
		            String password = rs.getString("vch_accountant_password"); 
		            if((Integer.parseInt(login.getUserName())) == id && (login.getPassword()).equals(password)) {
		            	 System.out.println(id + " " + password);
		            	 modelAndView = new ModelAndView("welcome");
		            	 return modelAndView;
		            }
		             
		           
		            // Display values 
//		            System.out.print("ID: " + id); 
//		            System.out.print(", Age: " + age); 
//		            System.out.print(", First: " + first); 
//		            System.out.println(", Last: " + last); 
		         } 
		         // STEP 5: Clean-up environment 
		         rs.close(); 
		      } catch(SQLException se) { 
		         // Handle errors for JDBC 
		         se.printStackTrace(); 
		      } catch(Exception e) { 
		         // Handle errors for Class.forName 
		         e.printStackTrace(); 
		      } finally { 
		         // finally block used to close resources 
		         try { 
		            if(stmt!=null) stmt.close();  
		         } catch(SQLException se2) { 
		         } // nothing we can do 
		         try { 
		            if(conn!=null) conn.close(); 
		         } catch(SQLException se) { 
		            se.printStackTrace(); 
		         } // end finally try 
		      } // end try 
		      System.out.println("Goodbye!"); 
		modelAndView = new ModelAndView("Login");
		modelAndView.addObject("message", "Uname and pwd invalid");
		return modelAndView;
	}
	
}
