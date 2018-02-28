package com.js;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCasesForXmlParsing {
	
	private static DAO dao = null;
	
	@BeforeClass
	public static void dbConnectionOpen() {
		
		dao = dao.getDaoObj();
	}

	@AfterClass
	public static void dbConnectionClose() {
		
		dao.connectionClose();
	}
	
	@Test
	public void singleRecord() {
		
		Student stud = dao.getStudentDetail(101);
		
		assertEquals("Student [rollno=101, name=Raja, city=Pune]", stud.toString());
				
	}

	@Test
	public void allStudentRecord() {
		
		List<Student> studlist = new ArrayList<Student>();
		
		studlist = dao.getAllStudentDetail();
		
		assertNotNull(studlist);
	}
	
	
	public void insertStudentRecord() {
		
		Student studInsert = new Student();
		studInsert.setName("testName");
		studInsert.setCity("testCity");
		studInsert.setRollno(551);
		boolean flag = dao.setStudentInfo(studInsert);
		
		assertTrue(flag);
	}
	
	
}
