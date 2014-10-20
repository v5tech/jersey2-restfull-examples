package org.jersey2.jaxbcontext.example;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.glassfish.jersey.client.ClientConfig;
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
	
	@Override
	protected void configureClient(ClientConfig config) {
		super.configureClient(config);
		config.register(EmployeeJAXBContextProvider.class);
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
		 Response response = target("employee").request().post(Entity.entity(element,MediaType.APPLICATION_XML));
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
	}
	
	@Test
	public void testUpdateEmployee(){
		 Department department = new Department(1,"研发部");
		 Employee employee = new Employee(1,"scott",department);
		 JAXBElement<Employee> element = new JAXBElement<Employee>(new QName("employee"), Employee.class, employee);
		 Response response = target("employee").request().put(Entity.entity(element,MediaType.APPLICATION_XML));
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
	}
	
	@Test
	public void testDeleteEmployee(){
		 Response response = target("employee").path("3").request().delete();
		 System.out.println(response.getStatus());
		 System.out.println(response.readEntity(String.class));
	}
}
