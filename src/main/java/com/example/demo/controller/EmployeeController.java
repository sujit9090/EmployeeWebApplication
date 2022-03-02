package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	 @RequestMapping(value="/save",method= RequestMethod.POST)
	    public String saveDetails(Model model, Employee employee)
	    {
		 employeeRepository.save(employee);
	        model.addAttribute("employee",employee);
	        return "employeelogin";
	    }
	 
	  @RequestMapping(value="/employeelogin",method= RequestMethod.POST)
	    public String patientLogin(Model model,Employee employee)
	    {
		  Employee emp= employeeService.loginByCredentials(employee.getEmail(),employee.getPassword());
	        model.addAttribute("employee",emp);
	        return "employeehome";
	    }
	  
	  @RequestMapping(value="/myprofile/{id}")
	    public String patientProfile(@PathVariable("id") int id,Model model)
	    {
		  Employee employee=  employeeRepository.findById(id).get();
	    System.out.println(employee.getEmail());
	    model.addAttribute("employee",employee);
	    return "employeeprofile";
	    }
	  
	  


}
