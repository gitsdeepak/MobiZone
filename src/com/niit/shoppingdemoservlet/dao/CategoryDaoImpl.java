package com.niit.shoppingdemoservlet.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.shoppingdemoservlet.config.HibernateUtil;
import com.niit.shoppingdemoservlet.dao.CategoryDao;
import com.niit.shoppingdemoservlet.model.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public boolean addCategory(Category category) {
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(category);
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
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getcustomerByusername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCategory(Category c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validate(String emailid, String password) {
		// TODO Auto-generated method stub
		return false;
	}
*/
/*	@Override
	public int delete(int categoryId) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	*/

	@Override
	public int deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Category> getcategoryByName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}
}
