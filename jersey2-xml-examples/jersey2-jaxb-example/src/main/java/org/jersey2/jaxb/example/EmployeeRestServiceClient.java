package org.jersey2.jaxb.example;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class EmployeeRestServiceClient{

	
	public static void GetAll(){
		Client client = ClientBuilder.newBuilder().build();
		Response response = client.target("http://localhost:8080/v1/api/employee").path("v1").request(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
	}
	
	public static void GetEmployee(){
		Client client = ClientBuilder.newBuilder().build();
		Response response = client.target("http://localhost:8080/v1/api/employee").path("1").request(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
	}
	
	/**
	 * 测试POST方法
	 */
	public static void SaveEmployee(){
		
		Client client = ClientBuilder.newBuilder().build();
		Department department = new Department(1,"研发部");
		Employee employee = new Employee(1,"scott",department);
		JAXBElement<Employee> element = new JAXBElement<Employee>(new QName("employee"), Employee.class, employee);
		Response response = client.target("http://localhost:8080/v1/api/employee").request(MediaType.APPLICATION_XML).post(Entity.entity(element, MediaType.APPLICATION_XML));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	/**
	 * 测试PUT方法
	 */
	public static void UpdateEmployee(){
		
		Client client = ClientBuilder.newBuilder().build();
		Department department = new Department(1,"研发部");
		Employee employee = new Employee(1,"scott",department);
		JAXBElement<Employee> element = new JAXBElement<Employee>(new QName("employee"), Employee.class, employee);
		Response response = client.target("http://localhost:8080/v1/api/employee").request(MediaType.APPLICATION_XML).put(Entity.entity(element, MediaType.APPLICATION_XML));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	
	
	
	/**
	 * 测试DELETE方法
	 */
	public static void RemoveEmployee(){
		Client client = ClientBuilder.newBuilder().build();
		Response response = client.target("http://localhost:8080/v1/api/employee").path("1").request(MediaType.APPLICATION_XML).delete();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	public static void main(String[] args) {
		
		GetAll();
		System.out.println();
		
		GetEmployee();
		System.out.println();
		
		SaveEmployee();
		System.out.println();
		
		UpdateEmployee();
		System.out.println();
		
		RemoveEmployee();
	}
	
}
