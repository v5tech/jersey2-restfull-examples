package org.jersey2.jsonp.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class StudentRestServiceClient {

	public static void getAll(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/v1/api").path("students/all");
		Response response = target.request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	public static void getStudent(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/v1/api").path("students/2");
		Response response = target.request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	public static void saveStudent(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/v1/api").path("students");
		
		JsonObject jsonStudentObject;
		JsonObject jsonClassRoomObject;
		
		Student student = new Student();
		student.setSid(5);
		student.setName("SCOTT");
		student.setDate(Calendar.getInstance().getTime());
		
		ClassRoom classRoom = new ClassRoom(1, "三年二班");
		student.setClassRoom(classRoom);
		
		jsonClassRoomObject = Json.createObjectBuilder()
				.add("cid", student.getClassRoom().getCid())
				.add("cname", student.getClassRoom().getName())
				.build();
		
		jsonStudentObject = Json.createObjectBuilder()
				.add("sid", student.getSid())
				.add("sname", student.getName())
				.add("date", new SimpleDateFormat().format(student.getDate()))
				.add("classroom", jsonClassRoomObject)
				.build();
		
		Response response = target.request().accept(MediaType.APPLICATION_JSON).post(Entity.json(jsonStudentObject));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	public static void updateStudent(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/v1/api").path("students");
		
		JsonObject jsonStudentObject;
		JsonObject jsonClassRoomObject;
		
		Student student = new Student();
		student.setSid(5);
		student.setName("SCOTT");
		student.setDate(Calendar.getInstance().getTime());
		
		ClassRoom classRoom = new ClassRoom(1, "三年二班");
		student.setClassRoom(classRoom);
		
		jsonClassRoomObject = Json.createObjectBuilder()
				.add("cid", student.getClassRoom().getCid())
				.add("cname", student.getClassRoom().getName())
				.build();
		
		jsonStudentObject = Json.createObjectBuilder()
				.add("sid", student.getSid())
				.add("sname", student.getName())
				.add("date", new SimpleDateFormat().format(student.getDate()))
				.add("classroom", jsonClassRoomObject)
				.build();
		
		Response response = target.request().accept(MediaType.APPLICATION_JSON).put(Entity.json(jsonStudentObject));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	public static void deleteStudent(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/v1/api").path("students").path("1");
		Response response = target.request().delete();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	public static void main(String[] args) {
//		getAll();
//		getStudent();
		saveStudent();
		updateStudent();
		deleteStudent();
	}
	
}
