package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Employee;
import com.example.demo.model.Manager;

@Controller
public class HomeController
	{
	@RequestMapping("/")
	public String homePage() {
		//System.out.println("HomePage");
		return "home";
	}
	@RequestMapping(value = "/employeeRegister")
	public String employeeRegisterPage(Model model) {
		model.addAttribute("employee", new Employee());
		return "employeeregister";
	}	
	@RequestMapping(value = "/employeeLogin")
	public String employeeLogin(Model model) {
		model.addAttribute("employee", new Employee());
		return "employeelogin";
	}
	@RequestMapping(value="/managerRegister")
    public String managerRegisterPage(Model model)
    {
        model.addAttribute("manager",new Manager());
        return "managerregister";
    }
    @RequestMapping(value="/managerLogin")
    public String doctorLogin(Model model)
    {
        model.addAttribute("manager",new Manager());
        return "managerlogin";
    }
}
