<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

if(session.getAttribute("user") == null){
	// 아예 새로운 요청을 함
	// rd.forward(request, response) 이면 화면 유지한 상태에서 값만 바뀌는 것
	response.sendRedirect("/");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<body>
<form>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
	<%
	if(request.getAttribute("boardList") == null){
		out.println("<tr><td colspan=\"4\">There is no posting.</td></tr>");
	} else {
		List<Map<String, String>> boardList = (List<Map<String, String>>)request.getAttribute("boardList");
		for(Map<String, String> board:boardList){
	%>
		<tr>
			<td><%= board.get("biNum") %></td>
			<td><%= board.get("biTitle") %></td>
			<td><%= board.get("uiNum") %></td>
			<td><%= board.get("credat") %></td>
		</tr>
	<%
		}
	}
	%>
	</table>
</form>
<br>
<a href="/views/board/insert">*** 글쓰기 ***</a><br>
<a href="/board/list">*** 글 목록 보기 ***</a><br>
</body>
</html>