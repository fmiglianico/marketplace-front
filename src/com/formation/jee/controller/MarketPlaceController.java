package com.formation.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.jee.service.ItemService;
import com.formation.jee.service.PlayerService;
import com.formation.jee.service.impl.ItemServiceImpl;
import com.formation.jee.service.impl.PlayerServiceImpl;

@WebServlet("/marketplace")
public class MarketPlaceController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private PlayerService playerService;
	private ItemService itemService;
	
	public MarketPlaceController() {
		playerService = new PlayerServiceImpl();
		itemService = new ItemServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		req.getRequestDispatcher( "WEB-INF/marketplace.jsp" ).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
