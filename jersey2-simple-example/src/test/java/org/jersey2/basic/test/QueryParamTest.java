package org.jersey2.basic.test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.jersey2.simple.MyApplication;
import org.junit.Test;

public class QueryParamTest extends JerseyTest {
	
	
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
	 * http://localhost:8080/v1/api/v1?from=100&to=200&orderBy=age&orderBy=name
	 */
	@Test
	public void testV1(){
		Response response = target("v1")
		.queryParam("from", "100")
		.queryParam("to", "200")
		.queryParam("orderBy",new Object[]{"age","name"})
		.request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	/**
	 * http://localhost:8080/v1/api/v2?from=100&to=200&orderBy=age&orderBy=name
	 */
	@Test
	public void testV2(){
		Response response = target("v2")
		.queryParam("from", "100")
		.queryParam("to", "200")
		.queryParam("orderBy",new Object[]{"age","name"})
		.request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	/**
	 * http://localhost:8080/v1/api/v3
	 */
	@Test
	public void testV3(){
		Response response = target("v3")
		.request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
}
