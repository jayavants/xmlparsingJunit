package com.js;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class InsertStudentInMysql extends HttpServlet {
	
	private DAO dao;
	
	private boolean status;
	
    public InsertStudentInMysql() {
        super();
        
    }
    public void init() {
    	
   	 this.dao = dao.getDaoObj();
   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html");
		
		try {
			
			Student studInsert = new Student();
			
			studInsert.setRollno(Integer.parseInt(request.getParameter("studno")));
		
			studInsert.setName(request.getParameter("studname"));
		
			studInsert.setCity(request.getParameter("studcity"));
			
			
			status = dao.setStudentInfo(studInsert);
		
		if(status) {
			
			request.setAttribute("flag", 3);
			request.getRequestDispatcher("WelcomeServlet").forward(request, response);
			
		}else{
			
			request.setAttribute("flag", 4);
			request.getRequestDispatcher("WelcomeServlet").forward(request, response);
		}
		}
		catch(Exception e) {
			
			request.setAttribute("flag", 5);
			request.getRequestDispatcher("WelcomeServlet").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	public void destroy() {
		
		dao.connectionClose();
	
	}
	
	
}
