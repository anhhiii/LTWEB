<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đặt lại mật khẩu</title>
</head>
<body>
	<h2>Đặt lại mật khẩu</h2>
	<form action="resetPassword" method="post">
		<input type="hidden" name="token"
			value="<%= request.getAttribute("token") %>" /> <label>Mật
			khẩu mới:</label> <input type="password" name="password" required />
		<button type="submit">Cập nhật mật khẩu</button>
	</form>
	<% if (request.getAttribute("message") != null) { %>
	<p><%= request.getAttribute("message") %></p>
	<% } %>
</body>
</html>