package com.board.mini.vo;

import java.util.HashMap;
import java.util.Map;

public class RequestDispatcher {
	public void forward(Map<String, String> request) {
		System.out.println(request.get("a"));
	}
}

class Test{
	public static void doGet(Map<String, String> request) {		
		RequestDispatcher rd = new RequestDispatcher();
		System.out.println(request.get("a"));
		rd.forward(request);
	}
	
	public static void main(String[] args) {
		Map<String, String> request = new HashMap<>();
		request.put("a", "a값");
		doGet(request);
	}
}

/*
 * a값
 * a값
 * 
 */