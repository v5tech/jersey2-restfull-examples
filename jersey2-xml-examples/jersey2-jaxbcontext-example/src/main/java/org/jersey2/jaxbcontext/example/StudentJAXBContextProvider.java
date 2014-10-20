package org.jersey2.jaxbcontext.example;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@Provider
public class StudentJAXBContextProvider implements ContextResolver<JAXBContext>{

	private JAXBContext context = null;
	
	@Override
	public JAXBContext getContext(Class<?> type) {
		if (type != Student.class) {
            return null; // we don't support nothing else than Student
        }
        if (context == null) {
            try {
                context = JAXBContext.newInstance(Student.class);
            } catch (JAXBException e) {
            }
        }
        return context;
	}

}
