package org.jersey2.jaxbcontext.example;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@Provider
public class EmployeeJAXBContextProvider implements ContextResolver<JAXBContext>{

	private JAXBContext context = null;
	
	@Override
	public JAXBContext getContext(Class<?> type) {
		if (type != Employee.class) {
            return null; // we don't support nothing else than Employee
        }
        if (context == null) {
            try {
                context = JAXBContext.newInstance(Employee.class);
            } catch (JAXBException e) {
            }
        }
        return context;
	}

}
