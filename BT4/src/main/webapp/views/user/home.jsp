<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Trang chủ User</title>
<!-- Bootstrap 5 CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
<style>
body {
	min-height: 100vh;
	display: flex;
	background-color: #f8f9fa;
}

.sidebar {
	width: 250px;
	background: linear-gradient(180deg, #212529, #343a40);
	color: #fff;
	min-height: 100vh;
	position: sticky;
	top: 0;
	box-shadow: 2px 0 10px rgba(0, 0, 0, 0.2);
}

.sidebar h4 {
	font-size: 1.3rem;
	font-weight: bold;
	text-align: center;
	margin-bottom: 1rem;
}

.sidebar a {
	color: #adb5bd;
	text-decoration: none;
	border-radius: 8px;
	padding: 10px 15px;
	display: flex;
	align-items: center;
	gap: 10px;
	transition: all 0.3s ease;
}

.sidebar a:hover {
	background-color: #495057;
	color: #fff;
	transform: translateX(5px);
}

.content {
	flex-grow: 1;
	padding: 30px;
}
</style>
</head>
<body>
	<!-- Sidebar -->
	<nav class="sidebar d-flex flex-column p-3">
		<h4>User</h4>
		<ul class="nav nav-pills flex-column mb-auto">
			<li class="nav-item mb-2"><a href="<c:url value='/home' />"
				class="nav-link active"> <i class="bi bi-house-fill"></i> Home
			</a></li>
			<li class="nav-item mb-2"><a
				href="<c:url value='/user/category' />" class="nav-link"> <i
					class="bi bi-tags-fill"></i> Categories
			</a></li>
			<li class="nav-item mt-3"><a href="<c:url value='/logout' />"
				class="nav-link bg-danger text-white"> <i
					class="bi bi-box-arrow-right"></i> Logout
			</a></li>
		</ul>
	</nav>


	<!-- Bootstrap 5 JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>