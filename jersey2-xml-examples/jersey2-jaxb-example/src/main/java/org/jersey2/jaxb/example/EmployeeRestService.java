package org.jersey2.jaxb.example;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

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
	public List<JAXBElement<Employee>> getEmployees(){
		List<JAXBElement<Employee>> employees = new ArrayList<JAXBElement<Employee>>();
		Employee employee;
		Department department;
		JAXBElement<Employee> element;
		for (int i = 1; i <= 100; i++) {
			department = new Department(i,"department"+i);
			employee = new Employee(i,"employee"+i,department);
			element = new JAXBElement<Employee>(new QName("employee"), Employee.class, employee);
			employees.add(element);
		}
		return employees;
	}
	
	@Path("{id}")
	@GET
	public JAXBElement<Employee> getEmployee(@PathParam("id")int id){
		Department department = new Department(id,"研发部");
		Employee employee = new Employee(id,"scott",department);
		return new JAXBElement<Employee>(new QName("employee"), Employee.class, employee);
	}
	
	
	@POST
	public JAXBElement<Employee> saveEmployee(JAXBElement<Employee> employee){
		return employee;
	}
}
