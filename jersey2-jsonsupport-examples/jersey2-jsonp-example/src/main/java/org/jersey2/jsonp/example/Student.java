package org.jersey2.jsonp.example;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Student implements Serializable{
	
	private int sid;
	private String name;
	private Date date;
	private ClassRoom classRoom;
	
	public Student() {
	}
	
	public Student(int sid, String name, Date date, ClassRoom classRoom) {
		super();
		this.sid = sid;
		this.name = name;
		this.date = date;
		this.classRoom = classRoom;
	}

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ClassRoom getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", date=" + date
				+ ", classRoom=" + classRoom + "]";
	}
	
	
	
}
