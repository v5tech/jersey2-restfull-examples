package org.jersey2.moxy.example;

import javax.ws.rs.ext.ContextResolver;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {
	
	public MyApplication() {
		
        packages("org.jersey2.moxy.example");
        register(LoggingFilter.class);
        //使用Moxy操作json
        register(MoxyJsonFeature.class);//json序列化与反序列化
        register(createMoxyJsonResolver());//json序列化与反序列化

	}
	
	public static ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
		MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig();
        moxyJsonConfig.setFormattedOutput(true);//格式化json
        return moxyJsonConfig.resolver();
    }
	
}