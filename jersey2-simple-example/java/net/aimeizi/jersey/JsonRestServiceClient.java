package net.aimeizi.jersey;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;

public class JsonRestServiceClient{

	
	public static void testGetStudentInJson(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(new MoxyJsonConfig().resolver()).build();
		Response response = client.target("http://localhost:8080/jersey-example/api/student/json").path("/1").request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	public static void testGetStudentInXml(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(new MoxyJsonConfig().resolver()).build();
		Response response = client.target("http://localhost:8080/jersey-example/api/student/xml").path("/1").request().get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	
	public static void testGetStudentInfo(){
		Client client = ClientBuilder.newBuilder().register(MoxyJsonFeature.class).register(new MoxyJsonConfig().resolver()).build();
		Response response = client.target("http://localhost:8080/jersey-example/api/student").path("/1").request(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
		System.out.println("---------------------------------------------------");
		
		response = client.target("http://localhost:8080/jersey-example/api/student").path("/1").request(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
	}
	
	public static void main(String[] args) {
		testGetStudentInJson();
		System.out.println();
		testGetStudentInXml();
		System.out.println();
		testGetStudentInfo();
	}
	
}
