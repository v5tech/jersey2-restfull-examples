package org.jersey2.jsonp.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/students")
public class StudentRestServiceResource {

	
	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public JsonArray getAll(){
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		JsonObject jsonStudentObject;
		JsonObject jsonClassRoomObject;
		Student student;
		ClassRoom classRoom;
		for (int i = 1; i <= 100; i++) {
			student = new Student();
			classRoom = new ClassRoom(i, "classRoom"+i);
			student.setSid(i);
			student.setName("student"+i);
			student.setDate(Calendar.getInstance().getTime());
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
			jsonArrayBuilder.add(jsonStudentObject);
		}
		return jsonArrayBuilder.build();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public JsonObject getStudent(@PathParam("id")int id){
		JsonObject jsonStudentObject;
		JsonObject jsonClassRoomObject;
		Student student = new Student();
		student.setSid(id);
		student.setName("student"+id);
		student.setDate(Calendar.getInstance().getTime());
		
		ClassRoom classRoom = new ClassRoom(id, "classRoom"+id);
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
		
		return jsonStudentObject;
	}
	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public JsonObject saveStudent(JsonObject jsonObject){
		return jsonObject;
	}
	
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public JsonObject updateStudent(JsonObject jsonObject) throws Exception{
		int sid = jsonObject.getInt("sid");
		String sname = jsonObject.getString("sname");
		String date = jsonObject.getString("date");
		JsonObject jsonClassRoomObject = jsonObject.getJsonObject("classroom");
		int cid = jsonClassRoomObject.getInt("cid");
		String cname = jsonClassRoomObject.getString("cname");
		ClassRoom classRoom = new ClassRoom(cid, cname);
		Student student = new Student(sid,sname,new SimpleDateFormat().parse(date),classRoom);
		System.out.println(student);
		return jsonObject;
	}
	
	
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response deleteStudent(@PathParam("id")int id){
		return Response.ok("{\"id\":"+1+",\"status\":\"200\"}",MediaType.APPLICATION_JSON).build();
	}
	
}
