<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%@ page import="vn.iotstar.models.User"%>

<%
User user = (User) session.getAttribute("account");
if (user == null || user.getRoleid() != 1) {
	response.sendRedirect(request.getContextPath() + "/loginMVC");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ Admin</title>
</head>
<body>
	<h1>Xin chào Admin!</h1>
	<p>Đây là trang quản trị của hệ thống.</p>

	<!-- Menu chức năng -->
	<ul>
		<li><a href="#">Quản lý người dùng</a></li>
		<li><a href="#">Quản lý sản phẩm</a></li>
		<li><a href="#">Báo cáo thống kê</a></li>
	</ul>
	<p><a href="${pageContext.request.contextPath}/logout">Đăng xuất</a></p>

</body>
</html>
