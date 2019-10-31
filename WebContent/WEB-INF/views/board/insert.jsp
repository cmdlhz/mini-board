<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
// if(request.getAttribute("user") == null){
// 	response.sendRedirect("/");
// }
if(request.getAttribute("msg") != null){
%>
<script>
	alert('<%= request.getAttribute("msg")%>');
</script>
<%
}
Map<String,Object> user = (Map<String, Object>)session.getAttribute("user");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록</title>
</head>
<body>
<form method="POST" action="/board/insert">
	<table border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" name="biTitle" id="biTitle"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea type="text" name="biContent" id="biContent"></textarea></td>
		</tr>
<!-- 		<tr> -->
<!-- 			<th>글쓴이</th> -->
<%-- 			<td><%= user.get("ui_name")%></td> --%>
<!-- 		</tr> -->
		<tr>
			<th colspan="2"><button>등록하기</button></th>
		</tr>
	</table>
</form>
</body>
</html>