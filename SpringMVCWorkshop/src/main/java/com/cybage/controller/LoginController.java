package com.cybage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.model.Book;
import com.cybage.model.User;
import com.cybage.service.BookService;
import com.cybage.service.LoginService;

@Controller
public class LoginController {
	

	@Autowired
	LoginService loginService;
	
	@GetMapping("/addUser")
	public String showForm(Model model) {
		
		model.addAttribute("user", new User());
		
		return "addUser";
	}
	
	
@PostMapping("/addUser")
public ModelAndView addUser(@Valid @ModelAttribute("user")User user,BindingResult result) {
	if(result.hasErrors()) {
		return new ModelAndView("addUser","user",user);
	}
	
	loginService.addUser(user);
	return new ModelAndView("displayUser","userList",loginService.getUser());
	
}
}
