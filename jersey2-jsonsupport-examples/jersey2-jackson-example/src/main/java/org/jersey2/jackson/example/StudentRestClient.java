package org.jersey2.jackson.example;

import java.util.Calendar;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class StudentRestClient {
	
	public static void main(String[] args) {
		GetAll();
		System.out.println();
		GetStudent();
		System.out.println();
		SaveStudent();
		System.out.println();
		UpdateStudent();
		System.out.println();
		DeleteStudent();
	}
	
	public static void GetAll(){
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/v1/api/student").path("all").request(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	public static void GetStudent(){
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/v1/api/student").path("1").request(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------------------------------------");
		response = client.target("http://localhost:8080/v1/api/student").path("1").queryParam("callback", "callback").request("application/javascript").get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	public static void SaveStudent(){
		Client client = ClientBuilder.newClient();
		Student student = new Student();
		ClassRoom classRoom = new ClassRoom(1, "三年二班");
		student.setSid(1);
		student.setSname("SCOTT");
		student.setDate(Calendar.getInstance().getTime());
		student.setClsssRoom(classRoom);
		
		Response response = client.target("http://localhost:8080/v1/api/student").request().post(Entity.entity(student, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
		System.out.println("----------------------------------------------");
		
		response = client.target("http://localhost:8080/v1/api/student").queryParam("callback", "callback").request("application/javascript").post(Entity.entity(student, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	public static void UpdateStudent(){
		Client client = ClientBuilder.newClient();
		Student student = new Student();
		ClassRoom classRoom = new ClassRoom(1, "三年二班");
		student.setSid(1);
		student.setSname("SCOTT");
		student.setDate(Calendar.getInstance().getTime());
		student.setClsssRoom(classRoom);
		
		Response response = client.target("http://localhost:8080/v1/api/student").request().put(Entity.entity(student, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
		System.out.println("----------------------------------------------");
		
		response = client.target("http://localhost:8080/v1/api/student").queryParam("callback", "callback").request("application/javascript").put(Entity.entity(student, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	public static void DeleteStudent(){
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/v1/api/student").path("2").request().delete();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------------------------------------");
		response = client.target("http://localhost:8080/v1/api/student").path("2").queryParam("callback", "callback").request("application/javascript").delete();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
}
