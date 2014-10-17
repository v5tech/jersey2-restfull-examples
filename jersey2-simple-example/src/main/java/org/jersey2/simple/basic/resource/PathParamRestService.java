package org.jersey2.simple.basic.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/")
public class PathParamRestService {
	
	/**
	 * http://localhost:8080/v1/api/2014/10/17
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	@GET
	@Path("{year}/{month}/{day}")
	public Response getUserHistory(
			@PathParam("year") int year,
			@PathParam("month") int month, 
			@PathParam("day") int day) {
 
	   String date = year + "/" + month + "/" + day;
 
	   return Response.status(200)
		.entity("getUserHistory is called, year/month/day : " + date)
		.build();
 
	}
	
}
