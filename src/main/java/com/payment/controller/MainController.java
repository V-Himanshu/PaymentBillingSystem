package com.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.payment.model.Login;
import com.payment.model.Student;
import com.payment.service.LoginService;
import com.payment.service.LoginServiceImpl;

@Controller

public class MainController {

	LoginService loginServiceImpl = new LoginServiceImpl();
	ModelAndView modelAndView;

	@RequestMapping(value = "/login")
	public String login(Model model) {
//		Login login = new Login();
//		model.addAttribute("login", login);
		return "Login";
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse httpServletResponse,
			@ModelAttribute("login") Login login) {

		if (loginServiceImpl.loginValidation(login)) {
			modelAndView = new ModelAndView("welcome");
		} else {
			modelAndView = new ModelAndView("Login");
			modelAndView.addObject("message", "Invalid Username or Password");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/createStudentPage")
	public String createStudentPage() {
		return "CreateStudent";
	}

	@RequestMapping(value = "/createStudent", method = RequestMethod.POST)
	public ModelAndView createStudentProcess(@ModelAttribute("student") Student student) {

		if (loginServiceImpl.createStudent(student)) {
			modelAndView = new ModelAndView("welcome");
			modelAndView.addObject("message", "Added Successfully!!");
		} else {
			modelAndView = new ModelAndView("CreateStudent");
			modelAndView.addObject("message", "Failed Creating Student");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/searchStudentPage")
	public String searchStudentPage() {
		return "SearchStudent";
	}

	@RequestMapping(value = "/searchStudent", method = RequestMethod.POST)
	public ModelAndView searchStudentProcess(HttpServletRequest request, HttpServletResponse response) {
		int registerNumber = Integer.parseInt(request.getParameter("registerNumber"));
		Student student;
		System.out.println(registerNumber);
		student = loginServiceImpl.searchStudent(registerNumber);

		modelAndView = new ModelAndView("SearchStudent");
		modelAndView.addObject("name", student.getName());
		modelAndView.addObject("departmentId", student.getDepartmentId());
		modelAndView.addObject("branchId", student.getBranchId());
		modelAndView.addObject("email", student.getEmail());
		modelAndView.addObject("studentPhone", student.getPhone());
		modelAndView.addObject("parentPhone", student.getParentPhone());
		modelAndView.addObject("modifiedbyAccountant", student.getModifiedByAccountant());
		modelAndView.addObject("activeStatus", student.getActiveStatus());

		return modelAndView;
	}
	
	@RequestMapping(value = "/updateStudentPage")
	public String updateStudentPage() {
		return "UpdateStudent";
	}
	
	@RequestMapping(value = "/searchStudentForUpdate", method = RequestMethod.POST)
	public ModelAndView searchStudentForUpdateProcess(HttpServletRequest request, HttpServletResponse response) {
		int registerNumber = Integer.parseInt(request.getParameter("registerNumber"));
		Student student;
		System.out.println(registerNumber);
		student = loginServiceImpl.searchStudent(registerNumber);

		modelAndView = new ModelAndView("UpdateStudent");
		modelAndView.addObject("registerNumber", student.getRegisterNumber());
		modelAndView.addObject("name", student.getName());
		modelAndView.addObject("departmentId", student.getDepartmentId());
		modelAndView.addObject("branchId", student.getBranchId());
		modelAndView.addObject("email", student.getEmail());
		modelAndView.addObject("studentPhone", student.getPhone());
		modelAndView.addObject("parentPhone", student.getParentPhone());
		modelAndView.addObject("modifiedbyAccountant", student.getModifiedByAccountant());
		modelAndView.addObject("activeStatus", student.getActiveStatus());

		return modelAndView;
	}
	
	@RequestMapping(value="/updateStudent", method=RequestMethod.POST)
	public ModelAndView updateStudent(HttpServletRequest request, @ModelAttribute("student")Student student) {
		int registerNumber = Integer.parseInt(request.getParameter("registerNumber"));
		if(loginServiceImpl.updateStudent(registerNumber, student)) {
			modelAndView = new ModelAndView("welcome");
			modelAndView.addObject("message", "Update Success");
			
		} else {
			modelAndView = new ModelAndView("UpdateStudent");
			modelAndView.addObject("message", "Failed Updating Student data!!");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/deleteStudentPage")
	public String deleteStudentPage() {
		return "DeleteStudent";
	}
	
	@RequestMapping(value = "/searchStudentForDelete", method = RequestMethod.POST)
	public ModelAndView searchStudentForDeleteProcess(HttpServletRequest request, HttpServletResponse response) {
		int registerNumber = Integer.parseInt(request.getParameter("registerNumber"));
		Student student;
		System.out.println(registerNumber);
		student = loginServiceImpl.searchStudent(registerNumber);

		modelAndView = new ModelAndView("DeleteStudent");
		modelAndView.addObject("registerNumber", student.getRegisterNumber());
		modelAndView.addObject("name", student.getName());
		modelAndView.addObject("departmentId", student.getDepartmentId());
		modelAndView.addObject("branchId", student.getBranchId());
		modelAndView.addObject("email", student.getEmail());
		modelAndView.addObject("studentPhone", student.getPhone());
		modelAndView.addObject("parentPhone", student.getParentPhone());
		modelAndView.addObject("modifiedbyAccountant", student.getModifiedByAccountant());
		

		return modelAndView;
	}
	
	@RequestMapping(value="/deleteStudent", method=RequestMethod.POST)
	public ModelAndView deleteStudent(HttpServletRequest request) {
		int registerNumber = Integer.parseInt(request.getParameter("registerNumber"));
		if(loginServiceImpl.deleteStudent(registerNumber)) {
			modelAndView = new ModelAndView("welcome");
			modelAndView.addObject("message", "Deleted Successfully");
		}else {
			modelAndView = new ModelAndView("DeleteStudent");
			modelAndView.addObject("message", "Failed to Delete records!!!");
		}
		return modelAndView;
	}

}
