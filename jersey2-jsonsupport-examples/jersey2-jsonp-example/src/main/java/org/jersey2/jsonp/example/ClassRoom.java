package org.jersey2.jsonp.example;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ClassRoom implements Serializable{

	private int cid;
	private String name;
	private List<Student> students;
	
	public ClassRoom() {
	}
	
	public ClassRoom(int cid, String name) {
		super();
		this.cid = cid;
		this.name = name;
	}

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
}
