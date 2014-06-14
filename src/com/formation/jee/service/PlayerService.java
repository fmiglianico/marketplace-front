package com.formation.jee.service;

import com.formation.jee.domain.Player;

public interface PlayerService {
	
	void createPlayer(String login, String password);
	
	String login(String login, String password);
	
	Player getPlayer(String token);
	
	void buy(String token, int itemId, int quantity);
	
	void sell(String token, int itemId, int quantity);

}