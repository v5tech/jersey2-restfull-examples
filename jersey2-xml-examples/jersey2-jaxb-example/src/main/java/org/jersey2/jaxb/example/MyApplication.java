package org.jersey2.jaxb.example;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {

	public MyApplication() {
		packages("org.jersey2.jaxb.example");
		register(LoggingFilter.class);
	}
}
