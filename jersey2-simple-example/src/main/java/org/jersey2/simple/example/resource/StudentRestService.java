package org.jersey2.simple.example.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/student")
@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})//Accept 接受值类型
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})//ContentType 返回值类型
public class StudentRestService {

	/**
	 * 使用GenericEntity类型返回xml或json格式的数据。注意方法声明为Response
	 * @return
	 */
	@Path("/v1")
	@GET
	public Response getStudentsV1() {
		
		List<Student> students = new ArrayList<Student>();
		
		ClassRoom classRoom = new ClassRoom();
		classRoom.setCid(1);
		classRoom.setClassname("三年二班");
		
		for (int i = 1; i <= 100; i++) {
			Student student = new Student(i,"SCOTT");
			student.setClassRoom(classRoom);
			students.add(student);
		}
		GenericEntity<List<Student>> entity = new GenericEntity<List<Student>>(students){};
		return Response.ok(entity).build();
 
	}
	
	/**
	 * 使用List<Student>返回xml或json格式的数据 注意方法声明返回值为List<Student>而不再是Response
	 * @return
	 */
	@Path("/v2")
	@GET
	public List<Student> getStudentsV2() {
		
		List<Student> students = new ArrayList<Student>();
		
		ClassRoom classRoom = new ClassRoom();
		classRoom.setCid(1);
		classRoom.setClassname("三年二班");
		
		for (int i = 1; i <= 100; i++) {
			Student student = new Student(i,"SCOTT");
			student.setClassRoom(classRoom);
			students.add(student);
		}
		return students;
 
	}
	
	
	/**
	 * 使用Students返回xml或json格式的数据 注意方法声明返回值为Students而不再是Response
	 * @return
	 */
	@Path("/v3")
	@GET
	public Students getStudentsV3() {
		
		Students students = new Students();
		List<Student> lists = students.getStudents();
		
		ClassRoom classRoom = new ClassRoom();
		classRoom.setCid(1);
		classRoom.setClassname("三年二班");
		
		for (int i = 1; i <= 100; i++) {
			Student student = new Student(i,"SCOTT");
			student.setClassRoom(classRoom);
			lists.add(student);
		}
		return students;
 
	}
	
	/**
	 * GET方式返回json格式数据
	 * http://localhost:8080/v1/api/student/json/1
	 * @param id
	 * @return
	 */
	@GET
	@Path("/json/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentInJson(@PathParam("id") int id) {
 
		Student student = new Student(id,"SCOTT");
		return Response.ok(student, MediaType.APPLICATION_JSON).build();
 
	}
	
	/**
	 * GET方式返回xml格式数据
	 * http://localhost:8080/v1/api/student/xml/1
	 * @param id
	 * @return
	 */
	@GET
	@Path("/xml/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getStudentInXml(@PathParam("id") int id) {
 
		Student student = new Student(id,"SCOTT");
		return Response.ok(student, MediaType.APPLICATION_XML).build();
 
	}
	
	
	/**
	 * GET方式返回xml和json格式数据,通过请求头Accept来判断Accept:application/xml或Accept:application/json
	 * http://localhost:8080/v1/api/student/1
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	public Response getStudentInfo(@PathParam("id") int id) {
 
		Student student = new Student(id,"SCOTT");
		return Response.ok(student).build();
 
	}
	
	/*****************************@DELETE**************@POST****************@PUT***********************/
	
	/**
	 * http://localhost:8080/v1/api/student/1
	 * @DELETE DELETE操作
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/{id}")
	public Response removeStudent(@PathParam("id") int id) {
 
		Student student = new Student(id,"SCOTT");
		return Response.ok(student).build();
 
	}
	
	
	/**
	 * http://localhost:8080/v1/api/student
	 * @POST POST操作
	 * @return
	 */
	@POST
	public Response saveStudent(Student student) {
 
		return Response.ok(student).build();
 
	}
	
	
	/**
	 * http://localhost:8080/v1/api/student
	 * @PUT PUT操作
	 * @return
	 */
	@PUT
	public Response updateStudent(Student student) {
		
		student.setName("Atom");
		ClassRoom classRoom = student.getClassRoom();
		classRoom.setClassname("三年三班");
		student.setClassRoom(classRoom);
		
		return Response.ok(student).build();
 
	}
	
}
