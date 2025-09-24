<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
</head>
<body>
	<h2>Quên mật khẩu</h2>
	<form action="forgotPassword" method="post">
		<label>Email:</label> <input type="email" name="email" required />
		<button type="submit">Gửi liên kết đặt lại</button>
	</form>
	<% if (request.getAttribute("message") != null) { %>
	<p><%= request.getAttribute("message") %></p>
	<% } %>
</body>
</html>