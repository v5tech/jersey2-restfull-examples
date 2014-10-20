package org.jersey2.moxyxml.example;

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
import javax.ws.rs.core.MediaType;

/**
 * 不使用注解返回xml
 * @author welcome
 *
 */

@Path("/employee")
@Consumes(MediaType.APPLICATION_XML)//Accept 接受值类型
@Produces(MediaType.APPLICATION_XML)//ContentType 返回值类型
public class EmployeeRestService {

	@Path("/v1")
	@GET
	public List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee;
		Department department;
		for (int i = 1; i <= 100; i++) {
			department = new Department(i,"department"+i);
			employee = new Employee(i,"employee"+i,department);
			employees.add(employee);
		}
		return employees;
	}
	
	@Path("{id}")
	@GET
	public Employee getEmployee(@PathParam("id")int id){
		Department department = new Department(id,"研发部");
		Employee employee = new Employee(id,"scott",department);
		return employee;
	}
	
	
	@POST
	public Employee saveEmployee(Employee employee){
		return employee;
	}
	
	@PUT
	public Employee updateEmployee(Employee employee){
		employee.setEname("乔布斯");
		employee.getDepartment().setDeptname("apple");
		return employee;
	}
	
	@DELETE
	@Path("{id}")
	public Employee deleteEmployee(@PathParam("id")int id){
		Department department = new Department(id,"研发部");
		Employee employee = new Employee(id,"scott",department);
		return employee;
	}
}
