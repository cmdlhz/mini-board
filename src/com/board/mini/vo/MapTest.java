package com.board.mini.vo;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
//	public static void signUp(String id, String pwd, String name, String addr) {
//		
//	}
	
	public static void signUp2(Map<String, String> user) {
		
	}
	
	public static void main(String[] args) {
		String id = "red";
		String pwd = "1234";
		String name = "Hello";
		String addr = "Seoul";
//		signUp(id, pwd, name, addr);
		
		Map<String, String> user = new HashMap<>();
		user.put("id", id);
		user.put("pwd", pwd);
		user.put("name", name);
		user.put("addr", addr);
		signUp2(user);
	}
}
