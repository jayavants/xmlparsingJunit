/*pojo class*/

package com.js;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllDetailController extends HttpServlet {
	
	private DAO dao;
	
	private List<Student> studlist;
	
	private PrintWriter pw;
	
    public AllDetailController() {
      
    }
    
    public void init() {
    	
    
    	 System.out.println("create db object");
    	 this.dao = dao.getDaoObj();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		pw = response.getWriter();
		
		studlist = new ArrayList<Student>();
		
		response.setContentType("text/html");
		
		try {
		
				
		studlist = dao.getAllStudentDetail();
		
		//Student s1 = studlist.get(1);
		
		if(studlist != null) {
			
			
			request.setAttribute("studlist", studlist);
			request.setAttribute("flag", 2);
			request.getRequestDispatcher("WelcomeServlet").forward(request, response);
			//request.getRequestDispatcher("all.jsp").forward(request, response);
			
		}else{
			
			response.sendRedirect("error.html");
		}
		}
		catch(Exception e) {
			
			response.sendRedirect("error.html");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	public void destroy() {
		
		dao.connectionClose();
	
	}
}