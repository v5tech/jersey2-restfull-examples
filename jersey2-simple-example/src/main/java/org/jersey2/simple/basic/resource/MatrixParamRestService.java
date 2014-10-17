package org.jersey2.simple.basic.resource;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/matrix")
public class MatrixParamRestService {
	
	/**
	 * http://localhost:8080/v1/api/matrix/2014
	 * http://localhost:8080/v1/api/matrix/2014;author=scott
	 * http://localhost:8080/v1/api/matrix/2014;author=scott;country=china
	 * @param year
	 * @param author
	 * @param country
	 * @return
	 */
	@GET
	@Path("{year}")
	public Response getBooks(@PathParam("year") String year,
			@MatrixParam("author") String author,
			@MatrixParam("country") String country) {
 
		return Response
			.status(200)
			.entity("getBooks is called, year : " + year
				+ ", author : " + author + ", country : " + country)
			.build();
 
	}
}
