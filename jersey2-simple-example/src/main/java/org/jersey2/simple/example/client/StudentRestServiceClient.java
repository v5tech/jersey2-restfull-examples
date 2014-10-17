package org.jersey2.simple.example.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.jersey2.simple.MyApplication;
import org.jersey2.simple.example.resource.ClassRoom;
import org.jersey2.simple.example.resource.Student;

public class StudentRestServiceClient{

	
	public static void testGetStudentsV1(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target("http://localhost:8080/v1/api/student").path("v1").request(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
		System.out.println("---------------------------------");
		response = client.target("http://localhost:8080/v1/api/student").path("v1").request(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
	}
	
	
	public static void testGetStudentsV2(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target("http://localhost:8080/v1/api/student").path("v2").request(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("---------------------------------");
		response = client.target("http://localhost:8080/v1/api/student").path("v2").request(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	public static void testGetStudentsV3(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target("http://localhost:8080/v1/api/student").path("v3").request(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("---------------------------------");
		response = client.target("http://localhost:8080/v1/api/student").path("/v3").request(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	public static void testGetStudentsV4(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target("http://localhost:8080/v1/api/student").path("v4").queryParam("pageNumber", "1").request(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("---------------------------------");
		response = client.target("http://localhost:8080/v1/api/student").path("/v4").queryParam("pageNumber", "1").request(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	public static void testGetStudentInJson(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target("http://localhost:8080/v1/api/student/json").path("1").request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	public static void testGetStudentInXml(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target("http://localhost:8080/v1/api/student/xml").path("1").request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	
	public static void testGetStudentInfo(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target("http://localhost:8080/v1/api/student").path("1").request(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
		System.out.println("---------------------------------------------------");
		
		response = client.target("http://localhost:8080/v1/api/student").path("/1").request(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
	}
	
	/**
	 * 测试PUT方法
	 */
	public static void testUpdateStudent(){
		
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		
		Student student = new Student();
		student.setSid(1);
		student.setName("SCOTT");
		ClassRoom classRoom = new ClassRoom();
		classRoom.setCid(1);
		classRoom.setClassname("三年二班");
		student.setClassRoom(classRoom);
		
		Response response = client.target("http://localhost:8080/v1/api/student").request(MediaType.APPLICATION_JSON).put(Entity.entity(student, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	/**
	 * 测试POST方法
	 */
	public static void testSaveStudent(){
		
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		
		Student student = new Student();
		student.setSid(2);
		student.setName("SCOTT");
		ClassRoom classRoom = new ClassRoom();
		classRoom.setCid(2);
		classRoom.setClassname("三年二班");
		student.setClassRoom(classRoom);
		
		Response response = client.target("http://localhost:8080/v1/api/student").request(MediaType.APPLICATION_JSON).post(Entity.entity(student, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	/**
	 * 测试DELETE方法
	 */
	public static void testRemoveStudent(){
		
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(MyApplication.createMoxyJsonResolver()).build();
		Response response = client.target("http://localhost:8080/v1/api/student").path("1").request(MediaType.APPLICATION_JSON).delete();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	public static void main(String[] args) {
		
		testGetStudentsV1();
		System.out.println();
		
		testGetStudentsV2();
		System.out.println();
		
		testGetStudentsV3();
		System.out.println();
		
		testGetStudentsV4();
		System.out.println();
		
		testGetStudentInJson();
		System.out.println();
		
		testGetStudentInXml();
		System.out.println();
		
		testGetStudentInfo();
		System.out.println();
		
		testUpdateStudent();
		System.out.println();
		
		testSaveStudent();
		System.out.println();
		
		testRemoveStudent();
	}
	
}
