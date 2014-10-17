package org.jersey2.simple.example.client;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * JerseyClient
 * @author welcome
 *
 */
public class CrunchifyRESTJerseyClient {

	private static final String URL = "http://localhost:8080/v1/api";
	
	public static void main(String[] args) {

		CrunchifyRESTJerseyClient crunchifyClient = new CrunchifyRESTJerseyClient();
		crunchifyClient.getCtoFResponse();
		crunchifyClient.getFtoCResponse();
	}

	private void getFtoCResponse() {
		try {

			Client client = ClientBuilder.newClient();
			WebTarget target = client.target(URL).path("ftocservice/90");
			Response response = target.request().get();
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			}

			String output = response.readEntity(String.class);
			System.out.println("\n============getFtoCResponse============");
			System.out.println(output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getCtoFResponse() {
		try {

			Client client = ClientBuilder.newClient();
			WebTarget target = client.target(URL).path("ctofservice/40");
			Response response = target.request().get();
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			}

			String output = response.readEntity(String.class);
			System.out.println("============getCtoFResponse============");
			System.out.println(output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
