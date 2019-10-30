package com.board.mini.vo;

class Form{
	public void submit() {
		// 6
		System.out.println("It's the final call!");
	}
	public void onSubmit(boolean isSubmit) {
		// 4
		if(isSubmit) {
			// 5
			submit();
		}
	}
}

public class CheckTest {
	static boolean checkForm() {
		// 3
		return true;
	}
	public static void main(String[] args) {
		// 1
		Form f = new Form();
		// 2
		f.onSubmit(checkForm());
	}
}

// "true" 일경우 submit() 실행
// "false" 이면 아무것도 출력되지 않음