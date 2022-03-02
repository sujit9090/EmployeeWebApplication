package com.example.demo.controller;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Employee;
import com.example.demo.model.Leave;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LeaveRepository;
import com.example.demo.service.LeaveService;

@Controller
public class LeaveController 
{
	@Autowired
	private LeaveRepository leaveRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private LeaveService leaveService;
	@RequestMapping(value="/employee/{id}/leave")
    public String bookAppointment(Model model, @PathVariable int id)
    {
        model.addAttribute("id",id);
        model.addAttribute("employee",employeeRepository.findById(id).get());
        model.addAttribute("leave", new Leave());
        return "applyleave";
    }
	@RequestMapping(value="/employee/{id}/leave/save",method= RequestMethod.POST)
    public String saveLeave(Leave leave,@PathVariable int id,Model model)
    {
        Employee employee=employeeRepository.findById(id).get();
        leave.setEmployeeId(employee);
        leaveRepository.save(leave);
        model.addAttribute("employee",employee);
        return "employeehome";
    }
	@RequestMapping(value="/employee/{id}/myleaves",method= RequestMethod.GET)
    public String myLeave(Leave leave, @PathVariable int id, Model model)
    {
    	Employee employee=employeeRepository.findById(id).get();
        model.addAttribute("leaves",leaveService.getleaves(employee));
        model.addAttribute("employee",employee);
        return "myleaves";
    }
    @RequestMapping(value="/accept/{id}",method= RequestMethod.GET)
    public String acceptAppointment(Leave leave, @PathVariable int id, Model model) throws HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException {
    	leaveService.acceptAppointment(id);
    	Employee employee=employeeRepository.findById(id).get();
        model.addAttribute("leaves",leaveService.getleaves(employee));
        model.addAttribute("employee",employee);
        return "myleaves";
    }
    @RequestMapping(value="/reject/{id}",method= RequestMethod.GET)
    public String rejectAppointment(Leave leave, @PathVariable int id, Model model) throws HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException {
    	leaveService.rejectAppointment(id);
    	Employee employee=employeeRepository.findById(id).get();
        model.addAttribute("leaves",leaveService.getleaves(employee));
        model.addAttribute("employee",employee);
        return "myleaves";      
    }
}
