package com.js;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
	
	private DAO dao;
	
	private Student stud;
	
	private static String col;
	
    public ControllerServlet() {
        
    	
    }
    
    public void init() {
    	
    	 this.dao = dao.getDaoObj();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html");
		
		try {
			
			
			int no = Integer.parseInt(request.getParameter("sno"));
		
			/*String name = request.getParameter("sname");
		
			String city = request.getParameter("scity");
			
			String val = checkUserData(no, name, city);*/
			
			
			//stud = dao.getStudentDetail(col, val);
			
			stud = dao.getStudentDetail(no);
		
		if(stud != null) {
			
			request.setAttribute("stud", stud);
			request.setAttribute("flag", 1);
			request.getRequestDispatcher("WelcomeServlet").forward(request, response);
			
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
	
	private String checkUserData(int no, String name, String city) {
		
		if(no == (int) no) {
			
			col = "rollno";
			
			return String.valueOf(no); 
			
		}else if(name != null) {
			
			col = "name";
			
			return name;
			
		}else if(city != null) {
			
			col = "city";
			
			return city;
		}

		return null;
	}
}
