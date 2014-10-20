package org.jersey2.jaxbcontext.example;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {

	public MyApplication() {
		packages("org.jersey2.jaxbcontext.example");
		register(LoggingFilter.class);
		register(EmployeeJAXBContextProvider.class);
		register(StudentJAXBContextProvider.class);
	}
}
