package com.niit.shoppingdemoservlet.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.shoppingdemoservlet.config.HibernateUtil;
import com.niit.shoppingdemoservlet.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
//show now where? is servlet?
	
	@Override
	public boolean addCustomer(Customer c) {
		
	try{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(c);
		session.flush();
		tx.commit();
		
		return true;
	}
	catch(HibernateException e)
		{
		e.printStackTrace();
		return false;	
		}
	}
/*
@Override
public List<Customer> getAllUser(){
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from Customer");
			List<Customer> customerList = session.createQuery("from Customer").list();
			session.flush();
			tx.commit();
			// show servlet where method execute
			return customerList;
		}
	catch(HibernateException e)
	{
		return null;
	}
	
}
 
@Override
public boolean deletecustomer (Customer customerusername) {
	 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	 Session session = sessionFactory.openSession();
	 Transaction tx = session.beginTransaction();
	 session.delete(customerusername);
	 session.flush();
	 tx.commit();
	
	 return true;
	
}
/*
@Override
public boolean deleteCustomer(int customerId) {
	 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	 Session session = sessionFactory.openSession();
	 Transaction tx = session.beginTransaction();
	 session.delete(customerId);
	 session.flush();
	 tx.commit();
	
	 return true;
}
@Override
public boolean updateCustomer (Customer c) {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	session.updateCustomer(Customer);
	session.flush();
	tx.commit();
	
	return true;
}*/

@Override
public boolean validate (String e, String password) {
	try {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	Query query=session.createQuery("from Customer where email=:id and password=:pass");
	query.setParameter("id", e);
	query.setParameter("pass", password);
	
	 Customer c=(Customer) query.uniqueResult();
	 tx.commit();
	 if(c!=null)

	return true;
	 else
		 return false;
	}
	catch(HibernateException ex)
	{return false;
	}
	
}

@Override
public List<Customer> getcustomerByusername(String username) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Customer findByEmail(String email) {
	try{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
	    Session session = sessionFactory.openSession();
	    Transaction tx = session.beginTransaction();
	    Query query=session.createQuery("from Customer where email=:id");
	    query.setParameter("id", email);
	    Customer c=(Customer) query.uniqueResult(); 
	
	    return c;
	}
	 catch(HibernateException ex)
	{
		return null;
	}
}

@Override
public Customer findByNumber(long number, String password) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean deleteCustomer(Customer c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean updateCustomer(Customer c, String email) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public Customer getCustomer(String email) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Customer> getAllCustomers() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean checkUser(String email, String answer) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public int updatePassword(String email, String newPassword) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int update(Customer c, String oldEmail) {
	// TODO Auto-generated method stub
	return 0;
}
}