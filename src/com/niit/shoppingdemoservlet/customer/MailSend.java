package com.niit.shoppingdemoservlet.customer;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailSend
 */
@WebServlet("/MailSend")
@MultipartConfig(maxFileSize = 16177215)
public class MailSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message=request.getParameter("message");
		String sendingTo=request.getParameter("sendTo");
		
		
		 //Get properties object    
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    

        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication("craftor0001@gmail.com","myproject1001");  
         }    
        });    
        //compose message    
        try {    
         MimeMessage message1 = new MimeMessage(session);    
         message1.addRecipient(Message.RecipientType.TO,new InternetAddress(sendingTo));    
         message1.setSubject("Test Message");    
         message1.setText(message); 
         Transport.send(message1);
         
         //send message 
         if(message1!=null) {
             
         System.out.println("message sent successfully");
         RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
         request.setAttribute("errorMsg","Message sent Sucessfully");
         rd.forward(request,response);
         }
        } catch (MessagingException e) {throw new RuntimeException(e);}    
   
		
		

	
	}

}
