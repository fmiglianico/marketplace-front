package com.formation.jee.service.impl;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.formation.jee.domain.Armor;
import com.formation.jee.domain.Consumable;
import com.formation.jee.domain.Item;
import com.formation.jee.domain.Weapon;
import com.formation.jee.service.ItemService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ItemServiceImpl implements ItemService {
	
	private final static String MARKETPLACE_URL = "http://localhost:8080/rest/marketplace/";

	@Override
	public List<Item> getAll() throws JsonMappingException, IOException {
		Client client = Client.create();
		 
		WebResource webResource = client
		   .resource(MARKETPLACE_URL + "get-all-items");
 
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                   .get(ClientResponse.class);
 
		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}
 
		String json = response.getEntity(String.class);
		ObjectMapper mapper = new ObjectMapper();
		List<Item> items = mapper.readValue(json, new TypeReference<List<Item>>(){});
		return items;
	}

	@Override
	public List<Weapon> getAllWeapons() throws JsonParseException, JsonMappingException, IOException {
		Client client = Client.create();
		 
		WebResource webResource = client
		   .resource(MARKETPLACE_URL + "get-all-weapons");
 
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                   .get(ClientResponse.class);
 
		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}
 
		String json = response.getEntity(String.class);
		ObjectMapper mapper = new ObjectMapper();
		List<Weapon> items = mapper.readValue(json, new TypeReference<List<Weapon>>(){});
		return items;
	}

	@Override
	public List<Armor> getAllArmors() throws JsonParseException, JsonMappingException, IOException {
		Client client = Client.create();
		 
		WebResource webResource = client
		   .resource(MARKETPLACE_URL + "get-all-armors");
 
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                   .get(ClientResponse.class);
 
		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}
 
		String json = response.getEntity(String.class);
		ObjectMapper mapper = new ObjectMapper();
		List<Armor> items = mapper.readValue(json, new TypeReference<List<Armor>>(){});
		return items;
	}

	@Override
	public List<Consumable> getAllConsumables() throws JsonParseException, JsonMappingException, IOException {
		Client client = Client.create();
		 
		WebResource webResource = client
		   .resource(MARKETPLACE_URL + "get-all-consumables");
 
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                   .get(ClientResponse.class);
 
		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}
 
		String json = response.getEntity(String.class);
		ObjectMapper mapper = new ObjectMapper();
		List<Consumable> items = mapper.readValue(json, new TypeReference<List<Consumable>>(){});
		return items;
	}

	@Override
	public List<Item> getInventory(String token) throws JsonParseException, JsonMappingException, IOException {
		Client client = Client.create();
		 
		WebResource webResource = client
		   .resource(MARKETPLACE_URL + "my-inventory");
 
		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class, token);
 
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus());
		}
		
		String json = response.getEntity(String.class);
		ObjectMapper mapper = new ObjectMapper();
		List<Item> items = mapper.readValue(json, new TypeReference<List<Item>>(){});
		return items;
	}

	
}
