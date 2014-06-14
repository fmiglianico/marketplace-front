package com.formation.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.jee.service.PlayerService;
import com.formation.jee.service.impl.PlayerServiceImpl;

@WebServlet("/inventory")
public class InventoryController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private PlayerService playerService;
	
	public InventoryController() {
		playerService = new PlayerServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.getRequestDispatcher( "WEB-INF/inventory.jsp" ).forward(req, resp);
	
	}
}
