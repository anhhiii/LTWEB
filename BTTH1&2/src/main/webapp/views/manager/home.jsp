<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%@ page import="vn.iotstar.models.User"%>

<%
User user = (User) session.getAttribute("account");
if (user == null || user.getRoleid() != 2) {
	response.sendRedirect(request.getContextPath() + "/loginMVC");
	return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
	<h1>
		Chào mừng Quản lý:
		<%=user.getUserName()%></h1>
	<ul>
		<li><a href="/manager/shop">Quản lý cửa hàng</a></li>
		<li><a href="<c:url value='/logout' />">Đăng xuất</a></li>
	</ul>
</body>
</html>