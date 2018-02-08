package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.journaldev.spring.model.Login;
import com.journaldev.spring.service.PersonService;


public class LoginController {
private PersonService personService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	@RequestMapping(value="home")
	public String homePage(){
		return "home";
	}
	@RequestMapping(value="home/login",method = RequestMethod.POST)
	public String userLogin(@ModelAttribute("loginform") Login l,Model model,@RequestParam("email") String email){
	
	model.addAttribute("index",personService.loginValidate(l));
	return "index";
	}
}
