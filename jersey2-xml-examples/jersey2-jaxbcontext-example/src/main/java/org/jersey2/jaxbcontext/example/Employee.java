package org.jersey2.jaxbcontext.example;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable{
	
	private int eid;
	private String ename;
	private Department department;
	
	public Employee() {
	}
	
	public Employee(int eid, String ename, Department department) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.department = department;
	}

	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
