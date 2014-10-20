package org.jersey2.jackson.example;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ClassRoom implements Serializable{
	
	private int cid;
	private String cname;
	private List<Student> students;
	
	public ClassRoom() {
	}
	
	public ClassRoom(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}


	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
