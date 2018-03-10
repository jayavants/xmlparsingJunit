package com.js;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO {
	
	private Connection conn;
	
	private  PreparedStatement ps;
	
	private Statement st;
	
	private static DAO dao = new DAO();
	
	private DAO(){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://215.216.217.62:3306/devdb","dev_user","devpass");
			
			ps = conn.prepareStatement("select rollno,name,city from Student where rollno = ?");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
			
	}
	
	public static DAO getDaoObj() {
		
		return dao;
	}
	
	public Student getStudentDetail(int rollno) {
		
		Student stud = new Student();
		
		
		
		try {
			
			/*if(col.equals("rollno")) {
				int rollno = Integer.parseInt(val);
				//ps.setString(1, col);
				ps.setInt(1, rollno);
			}else if(col.equals("name")){
				
				//ps.setString(1, col);
				ps.setString(1, val);
			}*/
			
			ps.setInt(1, rollno);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				stud.setRollno(rs.getInt(1));
				stud.setName(rs.getString(2));
				stud.setCity(rs.getString(3));
				
			}else {
				
				return null;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return stud;
	}
	
	public List<Student> getAllStudentDetail() {
		
		List<Student> studlist = new ArrayList<Student>();
		
		try {
			
			st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select * from Student");
			
			while(rs.next()) {
				
				Student stud = new Student();
				
				stud.setRollno(rs.getInt(1));
				stud.setName(rs.getString(2));
				stud.setCity(rs.getString(3));
				
				studlist.add(stud);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return studlist;
	}
	
	public boolean setStudentInfo(Student studInsert) {
		
		
		try {
			
			st = conn.createStatement();
			
			st.executeUpdate("insert into Student values (" +studInsert.getRollno()+ ",'" +studInsert.getName()+ "','" +studInsert.getCity()+ "');");
			
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public void deleteRecord(int rollno) {
		
		try {
			
			st = conn.createStatement();
			
			st.executeUpdate("delete from Student where rollno = "+rollno);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void connectionClose() {
		
		if(ps != null) {
			
			try {
				
				ps.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			
			try {
				
				conn.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	

}
