package com.board.mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.mini.service.UserService;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// "input"의 "name"
		String ui_name = request.getParameter("ui_name");
		String ui_id = request.getParameter("ui_id");
		String ui_pwd = request.getParameter("ui_pwd");
		
		UserService us = new UserService();
		String uri = request.getRequestURI();
	
		// 
		System.out.println(uri.substring(6));
	}
}
