package com.niit.shoppingdemoservlet.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.shoppingdemoservlet.config.HibernateUtil;
import com.niit.shoppingdemoservlet.model.Product;
import com.niit.shoppingdemoservlet.model.Sales;

public class ProductDaoImpl implements ProductDao {
//show now where? is servlet?
	@Override
	public boolean addProduct(Product p) {
		
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(p);
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
public List<Product> getAllProduct(){
	try {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Product");
		List<Product> product = (List<Product>) query.list();
		session.flush();
		tx.commit();
		// show servlet where method execute
		return product;
	    }
    catch(HibernateException e)
    {
     	return null;
    }

}*/
/*
@Override
public boolean deleteproduct (Product productname) {
	 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	 Session session = sessionFactory.openSession();
	 Transaction tx = session.beginTransaction();
	 session.delete(productname);
	 session.flush();
	 tx.commit();
	
	 return true;
	
}
/*
@Override
public boolean updateProduct (Product p) {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	session.updateProduct(Product);
	session.flush();
	tx.commit();
	
	return true;
}
/*
@Override
public boolean validate (String emailid, String password) {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	session.update(emailid, password);
	session.flush();
	tx.commit();
	
	return true;
}*/
/*
@Override
public List<Product> getProductByname(String name) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean deleteProduct(int productId) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean updateProduct(Product p) {
	// TODO Auto-generated method stub
	return false;
}
*/
/*
@Override
public boolean deleteProduct(Product productname) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public List<Product> getAllProducts() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Product> getproductByname(String name) {
	// TODO Auto-generated method stub
	return null;
}
*/
@Override
public int delete(int id) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int update(Product product) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public Product getProduct(int id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Product> getProducts(int categoryId) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Product> getAllProducts() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int addSales(Sales sales) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public List<Sales> getSales() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Product getProductById(int productId) {
	// TODO Auto-generated method stub
	return null;
}
}