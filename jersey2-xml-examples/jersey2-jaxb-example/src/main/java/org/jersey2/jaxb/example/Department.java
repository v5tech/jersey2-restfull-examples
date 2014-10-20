package org.jersey2.jaxb.example;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Department implements Serializable{

	private int did;
	private String deptname;
	private List<Employee> employees;

	public Department() {
	}
	
	public Department(int did, String deptname) {
		super();
		this.did = did;
		this.deptname = deptname;
	}



	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
