package org.jersey2.simple.basic.resource;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("/userAgent")
public class HeaderParamRestService {

	/**
	 * HeaderParam Example
	 * http://localhost:8080/v1/api/userAgent/v1
	 * @param userAgent
	 * @return
	 */
	@GET
	@Path("/v1")
	public Response addUser(@HeaderParam("user-agent") String userAgent) {
 
		return Response.status(200)
			.entity("addUser is called, userAgent : " + userAgent)
			.build();
 
	}
	
	/**
	 * Context Example
	 * http://localhost:8080/v1/api/userAgent/v2
	 * @param headers
	 * @return
	 */
	@GET
	@Path("/v2")
	public Response addUser(@Context HttpHeaders headers) {
 
		String userAgent = headers.getRequestHeader("user-agent").get(0);
 
		return Response.status(200)
			.entity("addUser is called, userAgent : " + userAgent)
			.build();
 
	}
	
}
