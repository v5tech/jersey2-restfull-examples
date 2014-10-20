package org.jersey2.jackson.example;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Student implements Serializable{

	private int sid;
	private String sname;
	private Date date;
	private ClassRoom clsssRoom;
	
	public Student() {
	}
	
	public Student(int sid, String sname, Date date, ClassRoom clsssRoom) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.date = date;
		this.clsssRoom = clsssRoom;
	}

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ClassRoom getClsssRoom() {
		return clsssRoom;
	}
	public void setClsssRoom(ClassRoom clsssRoom) {
		this.clsssRoom = clsssRoom;
	}
	
	
}
