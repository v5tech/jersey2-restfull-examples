package org.jersey2.simple.example.resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.owlike.genson.Genson;

@Path("/ftocservice")
public class FtoCService {

	/**
	 * http://localhost:8080/v1/api/ftocservice
	 * @return
	 */
	@SuppressWarnings("serial")
	@GET
	@Produces("application/json")
	public Response convertFtoC() {
		Genson genson = new Genson();
		Map<String, Object> jsonObject = new HashMap<String, Object>() {{
			
			Double fahrenheit = 98.24;
			Double celsius;
			celsius = (fahrenheit - 32) * 5 / 9;
			
			Student student = new Student(1,"Genson");
			
			put("F Value", fahrenheit);
			put("C Value", celsius);
			put("student", student);
		}};

		return Response.status(200).entity(genson.serialize(jsonObject)).build();
	}

	/**
	 * http://localhost:8080/v1/api/ftocservice/9.5
	 * @param f
	 * @return
	 */
	@SuppressWarnings("serial")
	@Path("{f}")
	@GET
	@Produces("application/json")
	public Response convertFtoCfromInput(@PathParam("f") final float f) {
		Genson genson = new Genson();
		Map<String, Float> jsonObject = new HashMap<String, Float>() {{
			float celsius;
			celsius = (f - 32) * 5 / 9;
			put("F Value", f);
			put("C Value", celsius);
		}};
		
		return Response.status(200).entity(genson.serialize(jsonObject)).build();
	}
}
