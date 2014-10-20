package org.jersey2.jsonp.example;

import javax.json.stream.JsonGenerator;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jsonp.JsonProcessingFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig{

	public MyApplication() {
		register(LoggingFilter.class);
		register(JsonProcessingFeature.class);
		packages("org.jersey2.jsonp.example");
        property(JsonGenerator.PRETTY_PRINTING, true);
	}
	
}
