package org.jersey2.moxyxml.example;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.moxy.xml.MoxyXmlFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {

	public MyApplication() {
		packages("org.jersey2.moxyxml.example");
		register(LoggingFilter.class);
		register(MoxyXmlFeature.class);
	}
}
