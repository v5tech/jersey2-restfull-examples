package org.jersey2.simple.basic.resource;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/")
public class QueryParamRestService {
	
	/**
	 * QueryParam example
	 * 
	 * http://localhost:8080/v1/api/v1?from=100&to=200&orderBy=age&orderBy=name
	 * @param from
	 * @param to
	 * @param orderBy
	 * @return
	 */
	@GET
	@Path("/v1")
	public Response getUsers(
		@QueryParam("from") int from,
		@QueryParam("to") int to,
		@QueryParam("orderBy") List<String> orderBy) {
 
		return Response
		   .status(200)
		   .entity("getUsers is called, from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();
 
	}
	
	/**
	 * Programmatic Query Parameter
	 * http://localhost:8080/v1/api/v2?from=100&to=200&orderBy=age&orderBy=name
	 * @param info
	 * @return
	 */
	@GET
	@Path("/v2")
	public Response getUsers(@Context UriInfo info) {
 
		String from = info.getQueryParameters().getFirst("from");
		String to = info.getQueryParameters().getFirst("to");
		List<String> orderBy = info.getQueryParameters().get("orderBy");
 
		return Response
		   .status(200)
		   .entity("getUsers is called, from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();
 
	}
	
	/**
	 * DefaultValue example
	 * http://localhost:8080/v1/api/v3
	 * @param from
	 * @param to
	 * @param orderBy
	 * @return
	 */
	@GET
	@Path("/v3")
	public Response getUserSets(
		@DefaultValue("1000") @QueryParam("from") int from,
		@DefaultValue("999")@QueryParam("to") int to,
		@DefaultValue("name") @QueryParam("orderBy") List<String> orderBy) {
 
		return Response
		   .status(200)
		   .entity("getUsers is called, from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();
 
	}
	
}
