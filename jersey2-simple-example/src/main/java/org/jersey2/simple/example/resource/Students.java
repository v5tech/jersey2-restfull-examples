package org.jersey2.simple.example.resource;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Students {

	private List<Student> students;

	public List<Student> getStudents() {
		if(students ==null){
			students = new ArrayList<Student>();
		}
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
