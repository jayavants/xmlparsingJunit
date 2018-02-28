package com.js;

public class Student {
	
	private int rollno;
	
	private String name;
	
	private String city;
	
	public Student() {
		
	}
	
	public Student(int rollno, String name, String city) {
		
		this.rollno = rollno;
		this.name = name;
		this.city = city;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		
		return "Student [rollno="+rollno+", name="+name+", city="+city+"]";
	}

}
