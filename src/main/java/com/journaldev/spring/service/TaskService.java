package com.journaldev.spring.service;

import com.journaldev.hibernate.data.Task;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TaskService {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void register(Task task){
		// Acquire session
		Session session = sessionFactory.getCurrentSession();
		// Save employee, saving behavior get done in a transactional manner
		session.save(task);
	}

    public List<Task> getTasks() {

        // Acquire session
        Session session = sessionFactory.getCurrentSession();

        Criteria c =session.createCriteria(Task.class);
        c.addOrder(Order.asc("register"));

        return c.list();
    }

    public void save(Task task)
    {
        // Acquire session
        Session session = sessionFactory.getCurrentSession();
        // Save employee, saving behavior get done in a transactional manner
        session.update(task);
    }

    public void delete(Task selectedTask) {
        // Acquire session
        Session session = sessionFactory.getCurrentSession();
        // Save employee, saving behavior get done in a transactional manner
        session.delete(selectedTask);
    }
}
