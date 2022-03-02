package com.example.demo.service;

import java.util.List;


import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;


@Service
public class EmployeeService {
	 @Autowired
	    private SessionFactory factory;

	    public Employee loginByCredentials(String email,String password)
	    {
	       Session session=factory.getSessionFactory().openSession();
	      Query query= session.createQuery("from Employee e where e.email=:x and e.password=:y", Employee.class);
	      query.setParameter("x",email);
	      query.setParameter("y",password);
	      List<Employee> employee=query.getResultList();
	        if(employee!=null)
	            return (Employee) employee.get(0);
	        return null;
	    }


}
