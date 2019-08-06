package com.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
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
	
	@RequestMapping(value="/createStudentPage")
	public String createStudentPage() {
		return "CreateStudent";
	}
	
	@RequestMapping(value="/createStudent", method = RequestMethod.POST)
	public ModelAndView createStudentProcess(@ModelAttribute("student")Student student) {
		
		if(loginServiceImpl.createStudent(student)) {
			modelAndView = new ModelAndView("welcome");
			modelAndView.addObject("message", "Added Successfully!!");
		}else {
			modelAndView = new ModelAndView("CreateStudent");
			modelAndView.addObject("message", "Failed Creating Student");
		}
		
		
		return modelAndView;
	}
	
	
	
	
	

}
