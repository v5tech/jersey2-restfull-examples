package org.jersey2.basic.test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.jersey2.simple.MyApplication;
import org.junit.Test;

/**
 * http://localhost:8080/v1/api/matrix/2014
 * http://localhost:8080/v1/api/matrix/2014;author=scott
 * http://localhost:8080/v1/api/matrix/2014;author=scott;country=china
 * @author welcome
 *
 */
public class MatrixParamTest extends JerseyTest {

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
	 * http://localhost:8080/v1/api/matrix/2014
	 */
	@Test
	public void test1(){
		Response response = target("matrix").path("2014").request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	/**
	 * http://localhost:8080/v1/api/matrix/2014;author=scott
	 */
	@Test
	public void test2(){
		Response response = target("matrix")
				.path("2014")
				.matrixParam("author", "scott")
				.request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	/**
	 * http://localhost:8080/v1/api/matrix/2014;author=scott;country=china
	 */
	@Test
	public void test3(){
		Response response = target("matrix")
				.path("2014")
				.matrixParam("author", "scott")
				.matrixParam("country", "china")
				.request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
}
