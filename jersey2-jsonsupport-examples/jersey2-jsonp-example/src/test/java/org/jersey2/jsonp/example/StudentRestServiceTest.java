package org.jersey2.jsonp.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

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
	
	@Test
	public void testGetAll(){
		Response response = target("students").path("all").request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	@Test
	public void testGetStudent(){
		Response response = target("students").path("2").request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	@Test
	public void testSaveStudent(){
		
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
		
		
		Response response = target("students").request().post(Entity.json(jsonStudentObject));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	@Test
	public void testUpdateStudent(){
		
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
		
		
		Response response = target("students").request().put(Entity.json(jsonStudentObject));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	
	@Test
	public void testDeleteStudent(){
		Response response = target("students").path("1").request().delete();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
}
