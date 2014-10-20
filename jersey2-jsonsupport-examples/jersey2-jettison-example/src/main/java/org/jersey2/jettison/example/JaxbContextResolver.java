package org.jersey2.jettison.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ext.ContextResolver;
import javax.xml.bind.JAXBContext;

import org.glassfish.jersey.jettison.JettisonConfig;
import org.glassfish.jersey.jettison.JettisonJaxbContext;

public class JaxbContextResolver implements ContextResolver<JAXBContext> {

	private final JAXBContext context;
    private final Set<Class<?>> types;
    private final Class<?>[] cTypes = {Student.class, ClassRoom.class, Students.class};
	
    public JaxbContextResolver() throws Exception {
    	this.types = new HashSet<Class<?>>(Arrays.asList(cTypes));
        this.context = new JettisonJaxbContext(JettisonConfig.DEFAULT, cTypes);
	}
    
	@Override
	public JAXBContext getContext(Class<?> type) {
		return (types.contains(type)) ? context : null;
	}

}
