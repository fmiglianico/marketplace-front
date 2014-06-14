package com.formation.jee.service;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.formation.jee.domain.Armor;
import com.formation.jee.domain.Consumable;
import com.formation.jee.domain.Item;
import com.formation.jee.domain.Weapon;

public interface ItemService {
	
	List<Item> getAll() throws JsonParseException, JsonMappingException, IOException ;

	List<Weapon> getAllWeapons() throws JsonParseException, JsonMappingException, IOException;

	List<Armor> getAllArmors() throws JsonParseException, JsonMappingException, IOException;

	List<Consumable> getAllConsumables() throws JsonParseException, JsonMappingException, IOException;
	
	List<Item> getInventory(String token) throws JsonParseException, JsonMappingException, IOException;
	

}