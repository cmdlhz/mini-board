package com.board.mini.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		uri = uri.substring(6);
		
		String url = "/views/user/login";
		String msg = "INCORRECT ID and/or password";

		if("login".equals(uri)) {
			System.out.println(uri);
			Map<String, Object> user = us.doLogin(ui_id, ui_pwd);
			if(user != null) {
				System.out.println(user);
				// .getSession() : if the request does not have a session, creates one.
				HttpSession hs = request.getSession();
				hs.setAttribute("user", user);
				url = "/views/index";
				msg = "Welcome, " + user.get("ui_name");
			}
		} else if("signup".equals(uri)) {
			Map<String, Object> rMap = us.doSignup(ui_name, ui_id, ui_pwd);
			if(rMap != null) {
				url = (String)rMap.get("url");
				msg = (String)rMap.get("msg");
			}
		} else {
			url = "/views/user/signup";
			msg = "Something went wrong...!";
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
