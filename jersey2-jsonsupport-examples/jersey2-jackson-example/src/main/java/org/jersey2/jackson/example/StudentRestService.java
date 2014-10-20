package org.jersey2.jackson.example;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.server.JSONP;

@Path("student")
@Produces({MediaType.APPLICATION_JSON,"application/javascript"})
public class StudentRestService {

	@GET
	@Path("all")
	@JSONP(callback="jsonp",queryParam="callback")
	@Produces({MediaType.APPLICATION_JSON,"application/javascript"})
	public List<Student> getAll(){
		List<Student> students = new ArrayList<Student>();
		Student student;
		ClassRoom classRoom;
		for (int i = 1; i <= 100; i++) {
			student = new Student();
			classRoom = new ClassRoom(i, "classRoom"+i);
			student.setSid(i);
			student.setSname("student"+i);
			student.setDate(Calendar.getInstance().getTime());
			student.setClsssRoom(classRoom);
			students.add(student);
		}
		return students;
	}
	
	
	@GET
	@Path("/{id}")
	@JSONP(callback="jsonp",queryParam="callback")
	@Produces({MediaType.APPLICATION_JSON,"application/javascript"})
	public Student getStudent(@PathParam("id")int id){
		Student student = new Student();
		ClassRoom classRoom = new ClassRoom(id, "classRoom"+id);
		student.setSid(id);
		student.setSname("student"+id);
		student.setDate(Calendar.getInstance().getTime());
		student.setClsssRoom(classRoom);
		return student;
	}
	
	
	
	@POST
	@JSONP(callback="jsonp",queryParam="callback")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,"application/javascript"})
	public Student saveStudent(Student student){
		return student;
	}
	
	
	
	@PUT
	@JSONP(callback="jsonp",queryParam="callback")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,"application/javascript"})
	public Student updateStudent(Student student){
		student.setSname("apple");
		student.getClsssRoom().setCname("三年三班");
		return student;
	}
	
	
	@DELETE
	@Path("{id}")
	@JSONP(callback="jsonp",queryParam="callback")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,"application/javascript"})
	public Response deleteStudent(@PathParam("id")int id,@Context UriInfo uriInfo){
		return Response.ok("{\"id\":"+id+",\"status\":\"200\"}").build();
	}
	
}
