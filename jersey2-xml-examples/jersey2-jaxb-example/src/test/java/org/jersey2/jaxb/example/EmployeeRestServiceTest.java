package org.jersey2.jaxb.example;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

public class EmployeeRestServiceTest extends JerseyTest {

	@Override
	protected Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
		return new MyApplication();
	}
	
	@Test
	public void testGetAll(){
		 Response response = target("employee").path("v1").request().accept(MediaType.APPLICATION_XML).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
	}
	
	@Test
	public void testGetEmployee(){
		 Response response = target("employee").path("1").request().accept(MediaType.APPLICATION_XML).get();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
	}
	
	@Test
	public void testSaveEmployee(){
		 Department department = new Department(1,"研发部");
		 Employee employee = new Employee(1,"scott",department);
		 JAXBElement<Employee> element = new JAXBElement<Employee>(new QName("employee"), Employee.class, employee);
		 GenericType<JAXBElement<Employee>> genericType = new GenericType<JAXBElement<Employee>>(){};
		 Response response = target("employee").request().post(Entity.entity(element, genericType));
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
	}
}
