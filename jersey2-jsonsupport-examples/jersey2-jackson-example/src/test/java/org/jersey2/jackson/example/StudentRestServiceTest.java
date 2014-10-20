package org.jersey2.jackson.example;

import java.util.Calendar;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
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
		config.register(MyObjectMapperProvider.class);
		config.register(JacksonFeature.class);
	}
	
	
	@Test
	public void testGetAll(){
		Response response = target("student").path("all").request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------------------------------------");
		response = target("student").path("all").queryParam("callback", "callback").request("application/javascript").get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	@Test
	public void testGetStudent(){
		Response response = target("student").path("1").request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------------------------------------");
		response = target("student").path("1").queryParam("callback", "callback").request("application/javascript").get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	@Test
	public void testSaveStudent(){
		Student student = new Student();
		ClassRoom classRoom = new ClassRoom(1, "三年二班");
		student.setSid(1);
		student.setSname("SCOTT");
		student.setDate(Calendar.getInstance().getTime());
		student.setClsssRoom(classRoom);
		
		Response response = target("student").request().post(Entity.entity(student, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
		System.out.println("----------------------------------------------");
		
		response = target("student").queryParam("callback", "callback").request("application/javascript").post(Entity.entity(student, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	@Test
	public void testUpdateStudent(){
		Student student = new Student();
		ClassRoom classRoom = new ClassRoom(1, "三年二班");
		student.setSid(1);
		student.setSname("SCOTT");
		student.setDate(Calendar.getInstance().getTime());
		student.setClsssRoom(classRoom);
		
		Response response = target("student").request().put(Entity.entity(student, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
		System.out.println("----------------------------------------------");
		
		response = target("student").queryParam("callback", "callback").request("application/javascript").put(Entity.entity(student, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	@Test
	public void testDelete(){
		Response response = target("student").path("2").request().delete();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------------------------------------");
		response = target("student").path("2").queryParam("callback", "callback").request("application/javascript").delete();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
}
