package org.jersey2.basic.test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.jersey2.simple.MyApplication;
import org.junit.Test;

public class PathParamTest extends JerseyTest {

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
	
	@Test
	public void test(){
		Response response = target().path("2014").path("10").path("17").request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
}
