package org.jersey2.jettison.example;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jettison.JettisonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {
	
	public MyApplication() {
		
        packages("org.jersey2.jettison.example");
        register(LoggingFilter.class);
        //使用Jettison操作json
        register(JaxbContextResolver.class);//json序列化与反序列化
        register(JettisonFeature.class);//json序列化与反序列化
	}
	
}