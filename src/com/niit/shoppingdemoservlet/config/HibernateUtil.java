package com.niit.shoppingdemoservlet.config;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

private static final SessionFactory sessionFactory;
    
    static {
        try {
           // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
        Configuration configuration =new Configuration().configure("hibernate.cfg.xml");
       System.out.println("=====================");
        sessionFactory= configuration.buildSessionFactory();
        }
        
        catch (HibernateException ex) {
            // Log the exception. 
     System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
       return sessionFactory;
    }
}
