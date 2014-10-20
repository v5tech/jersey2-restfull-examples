package org.jersey2.jackson.example;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {

	public MyApplication() {
		super(
			MyObjectMapperProvider.class,
			JacksonFeature.class
		);
		packages("org.jersey2.jackson.example");
	}
	
}
