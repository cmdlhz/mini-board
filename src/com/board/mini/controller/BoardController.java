package com.board.mini.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.mini.service.BoardService;


public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		/* "/board/"를 잘라내야 하므로 "7" */
		String cmd = uri.substring(7);
		
		BoardService bs = new BoardService();
		String path = "/views/board/list";
		
		if("list".equals(cmd)) {
			request.setAttribute("boardList", bs.getBoardList());
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bi_title = request.getParameter("biTitle");
		String bi_content = request.getParameter("biContent");
		
		BoardService bs = new BoardService();
		String uri = request.getRequestURI();
		uri = uri.substring(7);
		
		String path = "/views/board/list";
		String msg = "게시물이 저장되었습니다.";
		
		if("insert".equals(uri)) {
			Map<String, String> board = new HashMap<>();
			board.put("biTitle", bi_title);
			board.put("biContent", bi_content);
			
			HttpSession hs = request.getSession();
			
			Map<String, Object> user = (Map<String, Object>)hs.getAttribute("user");
			board.put("ui_num", user.get("ui_num").toString());
			int result = bs.insertBoardList(board);
			if(result!= 1) {
				path = "/views/board/insert";
				msg = "저장 안 됨...";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
