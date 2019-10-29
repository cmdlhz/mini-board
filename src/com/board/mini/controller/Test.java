package com.board.mini.controller;

public class Test {
	public void test() {
		System.out.println("Test!");
	}
	
	public static void main(String[] args) {
		/* 
		 * Reflection
		 */
//		String className = "com.board.mini.controller.Test";
//		try {
//			class clazz = Class.forName(className);
//			Test t = (Test)clazz.newInstance();
//			t.test();
//		} ...... (음... 따라가다 포기ㅠ)
//		
		
		Test t = new Test();
		t.test();
	}
}
