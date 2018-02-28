package com.js;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class WelcomeServlet extends HttpServlet {
	
	
    public WelcomeServlet() {
    	
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw = response.getWriter();
		
		response.setContentType("text/text"); 
		
		int flag = (int) request.getAttribute("flag");
		
		Student student = (Student) request.getAttribute("stud");
		 
		List<Student> list = new ArrayList<Student>();
		
		list = (List<Student>) request.getAttribute("studlist");
		
		if(flag == 1) {
		
			String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+"<students><student><rollno>"+student.getRollno()+"</rollno><name>"+student.getName()+"</name><city>"+student.getCity()+"</city></student></students>";
			
			pw.print(xmlStr);
			pw.println();
		
		}else if(flag == 2) {
			
			
			
			//String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+"<students>\n";
			
			StringBuilder xmlStrBuil = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"<students>");
			

			
			for(Student stud :  list) {
				
				//xmlStr += "<student>\n<rollno>"+stud.getRollno()+"</rollno>\n<name>"+stud.getName()+"</name>\n<city>"+stud.getCity()+"</city>\n</student>";
				
				
				xmlStrBuil.append("<student><rollno>"+stud.getRollno()+"</rollno><name>"+stud.getName()+"</name><city>"+stud.getCity()+"</city></student>");
				
			}
			
			xmlStrBuil.append("</students>\r\n");
			
			
			//xmlStr +="</students>";
			//pw.print(xmlStr);
			pw.print(xmlStrBuil);
			
			//System.out.println(xmlStr);
	
		}else if(flag == 3) {
			
			pw.println("Record successful inserted");
			
		}else if(flag == 4) {
			
			pw.println("Record already exit with same roll no");
			
		}else if(flag == 5) {
			
			pw.println("please insert proper format ..");
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
