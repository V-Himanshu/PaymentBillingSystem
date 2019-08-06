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
import com.payment.service.LoginService;
import com.payment.service.LoginServiceImpl;



@Controller
@SessionAttributes("login")
public class MainController {

	LoginService loginServiceImpl = new LoginServiceImpl();

	@RequestMapping(value = "/login")
	public String login(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "Login";
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse httpServletResponse,
			@ModelAttribute("login") Login login) {
		ModelAndView modelAndView;

		if (loginServiceImpl.loginValidation(login)) {
			modelAndView = new ModelAndView("welcome");
		} else {
			modelAndView = new ModelAndView("Login");
			modelAndView.addObject("message", "Invalid Username or Password");
		}

		return modelAndView;
	}
	
	
	

}
