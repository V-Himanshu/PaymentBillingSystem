package com.payment.controller;

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
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse httpServletResponse,
			@ModelAttribute("login")Login login) {
		ModelAndView modelAndView = null;
		if(request.getAttribute("userName").equals("abc") && request.getAttribute("password").equals("123")) {
			modelAndView = new ModelAndView("welcome");
		}else {
			modelAndView = new ModelAndView("Login");
		}
		return modelAndView;
	}
	
}
