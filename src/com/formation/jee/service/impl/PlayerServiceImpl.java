package com.formation.jee.service.impl;

import com.formation.jee.domain.Player;
import com.formation.jee.service.PlayerService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PlayerServiceImpl implements PlayerService {
	
	private final static String MARKETPLACE_URL = "http://localhost:8080/rest/marketplace/";

	@Override
	public void createPlayer(String login, String password) {
		
		Client client = Client.create();
		 
		WebResource webResource = client
		   .resource(MARKETPLACE_URL + "create-player");
 
		String input = "{\"login\":\"" + login + "\",\"password\":\"" + password + "\"}";
 
		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class, input);
 
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus());
		}
	}

	@Override
	public String login(String login, String password) {
		
		Client client = Client.create();
		 
		WebResource webResource = client
		   .resource(MARKETPLACE_URL + "login");
 
		String input = "{\"login\":\"" + login + "\",\"password\":\"" + password + "\"}";
 
		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class, input);
 
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus());
		}
		
		return response.getEntity(String.class);
	}

	@Override
	public Player getPlayer(String token) {
		Client client = Client.create();
		 
		WebResource webResource = client
		   .resource(MARKETPLACE_URL + "my-profile");
 
		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class, token);
 
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus());
		}
		
		return response.getEntity(Player.class);
	}

	@Override
	public void buy(String token, int itemId, int quantity) {
		Client client = Client.create();
		
		WebResource webResource = client
		   .resource(MARKETPLACE_URL + "buy/" + itemId + "/" + quantity);
 
		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class, token);
 
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus());
		}
	}

	@Override
	public void sell(String token, int itemId, int quantity) {
		Client client = Client.create();
		 
		WebResource webResource = client
		   .resource(MARKETPLACE_URL + "sell/" + itemId + "/" + quantity);
 
		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class, token);
 
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus());
		}
	}
	
}
