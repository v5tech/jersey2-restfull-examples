package org.jersey2.moxy.example;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.jersey2.moxy.example.ClassRoom;
import org.jersey2.moxy.example.MyApplication;
import org.jersey2.moxy.example.Student;
import org.junit.Test;

public class StudentRestServiceTest extends JerseyTest {

	@Override
	protected Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
		return new MyApplication();
	}
	
	@Override
	protected void configureClient(ClientConfig config) {
		super.configureClient(config);
		config.register(MyApplication.createMoxyJsonResolver());
	}
	
	@Test
	public void testGetStudentsV1(){
		 Response response = target("/student").path("v1").request().accept(MediaType.APPLICATION_XML).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
		 
		 System.out.println("-----------------------------------------------------");
		 
		 response = target("/student").path("v1").request().accept(MediaType.APPLICATION_JSON).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
		 
	}
	
	
	@Test
	public void testGetStudentsV2(){
		 Response response = target("/student").path("v2").request().accept(MediaType.APPLICATION_XML).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
		 
		 System.out.println("-----------------------------------------------------");
		 
		 response = target("/student").path("v2").request().accept(MediaType.APPLICATION_JSON).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
		 
	}
	
	
	@Test
	public void testGetStudentsV3(){
		 Response response = target("/student").path("v3").request().accept(MediaType.APPLICATION_XML).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
		 
		 System.out.println("-----------------------------------------------------");
		 
		 response = target("/student").path("v3").request().accept(MediaType.APPLICATION_JSON).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
		 
	}
	
	
	@Test
	public void testGetStudentsV4(){
		 Response response = target("/student").path("v4").queryParam("pageNumber", "1").request().accept(MediaType.APPLICATION_XML).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
		 
		 System.out.println("-----------------------------------------------------");
		 
		 response = target("/student").path("v4").queryParam("pageNumber", "1").request().accept(MediaType.APPLICATION_JSON).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
		 
	}
	
	@Test
	public void testGetStudentsV5(){
		 Response response = target("/student").path("v5").queryParam("pageNumber", "1").queryParam("callback", "jsonpCallback").request().accept(MediaType.APPLICATION_XML).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
		 
		 System.out.println("-----------------------------------------------------");
		 
		 response = target("/student").path("v5").queryParam("pageNumber", "1").queryParam("callback", "jsonpCallback").request().accept(MediaType.APPLICATION_JSON).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
		 
		 System.out.println("-----------------------------------------------------");
		 
		 response = target("/student").path("v5").queryParam("pageNumber", "1").queryParam("callback", "jsonpCallback").request().accept("application/javascript").get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
		 
	}
	
	@Test
	public void testGetStudentInJson(){
		 Response response = target("/student").path("json").path("1").request().accept(MediaType.APPLICATION_JSON).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
	}
	
	
	@Test
	public void testGetStudentInJsonp(){
		 Response response = target("/student").path("jsonp").path("1").queryParam("callback", "jsonpCallback").request().accept("application/javascript").get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
	}
	
	
	@Test
	public void testGetStudentInXml(){
		 Response response = target("/student").path("xml").path("1").request().accept(MediaType.APPLICATION_XML).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
	}
	
	@Test
	public void testGetStudentInfo(){
		 Response response = target("/student").path("1").request().accept(MediaType.APPLICATION_JSON).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
		 
		 System.out.println("-----------------------------------------------------");
		 
		 response = target("/student").path("1").request().accept(MediaType.APPLICATION_XML).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
	}
	
	/**
	 * @DELETE
	 */
	@Test
	public void testRemoveStudent(){
		 Response response = target("/student").path("1").request().accept(MediaType.APPLICATION_JSON).delete();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
	}
	
	/**
	 * @POST
	 */
	@Test
	public void testSaveStudent(){
		 Student student = new Student();
		 student.setSid(2);
		 student.setName("SCOTT");
		 ClassRoom classRoom = new ClassRoom();
		 classRoom.setCid(2);
		 classRoom.setClassname("三年二班");
		 student.setClassRoom(classRoom);
		 Response response = target("/student").request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(student, MediaType.APPLICATION_JSON));
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
	}
	
	/**
	 * @PUT
	 */
	@Test
	public void testUpdateStudent(){
		 Student student = new Student();
		 student.setSid(1);
		 student.setName("SCOTT");
		 ClassRoom classRoom = new ClassRoom();
		 classRoom.setCid(1);
		 classRoom.setClassname("三年二班");
		 student.setClassRoom(classRoom);
		 Response response = target("/student").request().accept(MediaType.APPLICATION_JSON).put(Entity.entity(student, MediaType.APPLICATION_JSON));
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
	}
	
}
