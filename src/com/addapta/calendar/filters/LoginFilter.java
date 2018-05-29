package com.addapta.calendar.filters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.addapta.calendar.persistence.BO.UserBO;
import com.addapta.calendar.persistence.entity.User;

public class LoginFilter implements Filter {
	protected FilterConfig filterConfig;

//	   java.util.List revokeList; 
	   

	   public void doFilter(ServletRequest request, ServletResponse response, 
	FilterChain chain) throws java.io.IOException, ServletException {
		   
	    
		   
	     	
	      
		  HttpServletRequest req = (HttpServletRequest)request;
	      HttpServletResponse res = (HttpServletResponse)response;
	      HttpSession session =((HttpServletRequest) request).getSession();
	     
	      
	      User user = (User) session.getAttribute("user");	      	      
	      String url = ((HttpServletRequest)request).getRequestURL().toString();
	      String urNo = "main.jsp";
	     
	      
	      chain.doFilter(request, response); 
	      
	      
//	      UserBO uBO = new UserBO();
//	    
//	     if(url.equals("http://localhost:8080/com.calendar/login.jsp")||url.equals("http://localhost:8080/com.calendar/index.html")|| url.equals("http://localhost:8080/com.calendar/registro.jsp")) {
//	    	  	    	  
//	     }else {
//	    	 
//	    	 if(user != null) {
//		    	 
//		    	  if(uBO.recoveryWeb(user, urNo)) { 
//		    		  
//			      }else {			    	
//			    	  url = "login.jsp";			    	  
//			      }	    	  
//		    	  
//	    	 }else {	
//	    		 
//	    		 url = "http://localhost:8080/com.calendar/index.html";
//	    		 res.sendRedirect(url);
//	    		 
//		     }	    	 
//	    	 
//	     }
	      
	      
	    
	   
	     
	   }

	
	  
	   
}
