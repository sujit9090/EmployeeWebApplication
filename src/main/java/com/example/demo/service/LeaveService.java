package com.example.demo.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.Leave;

@Service
public class LeaveService {
	@Autowired
    private SessionFactory factory;

    public List<Leave> getleaves(Employee employee){
        Session session=factory.getSessionFactory().openSession();
       Query query= session.createQuery("from Leave a where a.employeeId=:x");
       query.setParameter("x",employee);
      List<Leave> leave= query.getResultList();
        return leave;
    }

    public List<Leave> myleaves(String dept){
        Session session=factory.getSessionFactory().openSession();
        Query query= session.createQuery("from Leave a where a.department=:x");
        query.setParameter("x",dept);
        List<Leave> leave= query.getResultList();
        return leave;
    }
    
    public List<Leave> myAppointments(String spec){
        Session session=factory.getSessionFactory().openSession();
        Query query= session.createQuery("from Leave a where a.department=:x");
        query.setParameter("x",spec);
        List<Leave> leave= query.getResultList();
        return leave;
    }

    public void acceptAppointment(int id) {
        Session session=factory.getSessionFactory().openSession();
        Query query= session.createQuery("update Leave a set a.status=:y where a.lid=:z");
     Transaction trx=session.beginTransaction();
        query.setParameter("y","Accepted");
        query.setParameter("z",id);
        query.executeUpdate();
        trx.commit();
    }

    public void rejectAppointment(int id) {
        Session session=factory.getSessionFactory().openSession();
        Query query= session.createQuery("update Leave a set a.status=:y where a.lid=:z");
        Transaction trx=session.beginTransaction();
        query.setParameter("y","Rejected");
        query.setParameter("z",id);
        query.executeUpdate();
        trx.commit();
    }


}