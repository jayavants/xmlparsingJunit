<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.js.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>

<%
     List<Student> studentlist = (List)request.getAttribute("stud");
    
 %>
<table align="center" border="2">
	<tr><th colspan="3"><b>Student Details</b></th></tr>
	<tr>
		<th>Roll Number</th>
		<th>Student Name</th>
		<th>City</th>
	</tr>
	
	<%
	
	 System.out.println("In JSP student list   == "+studentlist);
	
	for( Student stud : studentlist){   %>
	
	 <tr>
		<th><%=stud.getRollno() %></th>
		<th><%=stud.getName() %></th>
		<th><%=stud.getCity() %></th>
	</tr> 
	
	<%
		
		System.out.println(stud.getRollno()+"\t"+stud.getName()+"\t"+stud.getCity());
	}
	
		%> 
		
	
	<%-- <c:forEach items="${stud}" var="s">
      <tr>
        <th>${s.rollno}</th>    
		<th>${s.name}</th>
		<th>${s.city}</th> 
      </tr>
        </c:forEach> --%>


	
	
	</table>
	

</body>
</html>

	