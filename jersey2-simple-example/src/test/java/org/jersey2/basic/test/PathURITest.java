package org.jersey2.basic.test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.jersey2.simple.MyApplication;
import org.junit.Test;

public class PathURITest extends JerseyTest {

	
	@Override
	protected Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
		return new MyApplication();
	}
	
	@Override
	protected void configureClient(ClientConfig config) {
		super.configureClient(config);
		config.register(MyApplication.createMoxyJsonResolver());
	}
	
	/**
	 * http://localhost:8080/v1/api/
	 */
	@Test
	public void test(){
		Response response = target().request().get();
		System.out.println(response.readEntity(String.class));
	}
	
	
	/**
	 * http://localhost:8080/v1/api/vip
	 */
	@Test
	public void vip(){
		Response response = target("vip").request().get();
		System.out.println(response.readEntity(String.class));
	}
	
	
	/**
	 * http://localhost:8080/v1/api/scott
	 */
	@Test
	public void username(){
		Response response = target().path("scott").request().get();
		System.out.println(response.readEntity(String.class));
	}
	
	
	/**
	 * http://localhost:8080/v1/api/2008
	 */
	@Test
	public void userid(){
		Response response = target().path("2008").request().get();
		System.out.println(response.readEntity(String.class));
	}
	
	/**
	 * http://localhost:8080/v1/api/books/193518234
	 */
	@Test
	public void book(){
		Response response = target("books").path("193518234").request().get();
		System.out.println(response.readEntity(String.class));
	}
	
	
}
