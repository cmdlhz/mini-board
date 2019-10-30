package com.board.mini.vo;

public class FinallyTest {
	public static void main(String[] args) {
		String numStr = "123";
		try{
			int num = Integer.parseInt(numStr);
			System.out.println(numStr + ": This is the correct NUMBER!");
			return;
		} catch(Exception e) {
			System.out.println(numStr + ": This is not a NUMBER!");
			
		}finally {
			System.out.println("It gets executed no matter what!");
		}
	}
}

// 123: This is not a NUMBER!
// It gets executed no matter what!