package org.jersey2.simple.basic.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/")
public class PathURIRestService {
	
	/**
	 * http://localhost:8080/v1/api/
	 * @return
	 */
	@GET
	public Response getUser() {
		return Response.status(200).entity("getUser is called").build();
	}
 
	/**
	 * http://localhost:8080/v1/api/vip
	 * @return
	 */
	@GET
	@Path("/vip")
	public Response getUserVIP() {
		return Response.status(200).entity("getUserVIP is called").build();
	}
	
	/**
	 * http://localhost:8080/v1/api/scott
	 * @param name
	 * @return
	 */
	@GET
	@Path("{name}")
	public Response getUserByName(@PathParam("name") String name) {
 
		return Response.status(200)
			.entity("getUserByName is called, name : " + name).build();
 
	}
	
	/**
	 * http://localhost:8080/v1/api/2008
	 * @param id
	 * @return
	 */
	@GET
	@Path("{id : \\d+}") //support digit only
	public Response getUserById(@PathParam("id") String id) {
 
	   return Response.status(200).entity("getUserById is called, id : " + id).build();
 
	}
 
	/**
	 * http://localhost:8080/v1/api/username/sxyx2008
	 * @param username
	 * @return
	 */
	@GET
	@Path("/username/{username : [a-zA-Z][a-zA-Z_0-9]}")
	public Response getUserByUserName(@PathParam("username") String username) {
 
	   return Response.status(200)
		.entity("getUserByUserName is called, username : " + username).build();
 
	}
	
	/**
	 * http://localhost:8080/v1/api/books/193518234
	 * @param isbn
	 * @return
	 */
	@GET
	@Path("/books/{isbn : \\d+}")
	public Response getUserBookByISBN(@PathParam("isbn") String isbn) {
 
	   return Response.status(200)
		.entity("getUserBookByISBN is called, isbn : " + isbn).build();
 
	}
	
}
