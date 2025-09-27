<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Trang quản trị</title>
<!-- Bootstrap 5 CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap Icons -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
<style>
/* Body Flex column */
body {
	display: flex;
	flex-direction: column;
	min-height: 100vh;
	margin: 0;
	background-color: #f8f9fa;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

header {
	z-index: 10;
}

main {
	display: flex;
	flex: 1;
	gap: 0;
}

.sidebar {
	width: 250px;
	background-color: #343a40;
	padding: 1.5rem;
	color: #fff;
	box-shadow: 2px 0 8px rgba(0, 0, 0, 0.05);
	display: flex;
	flex-direction: column;
	gap: 1rem;
	align-items: center;
}

.sidebar h4 {
	font-size: 1.4rem;
	font-weight: bold;
	color: #fff;
	text-align: center;
	margin-bottom: 1rem;
}

.user-info {
	text-align: center;
}

.user-info img, .user-info i {
	display: block;
	margin: 0 auto 10px;
}

.user-info p {
	margin: 0;
	font-weight: 600;
	color: #f8f9fa;
}

.user-info small {
	color: #ced4da;
}

.nav-link {
	color: #f8f9fa;
	margin-bottom: 0.5rem;
	border-radius: 8px;
	padding: 0.5rem 1rem;
	transition: all 0.2s;
	text-decoration: none;
	background-color: #495057;
}

.nav-link:hover {
	background-color: #6c757d;
	color: #fff;
	transform: translateX(5px);
}

.nav-link.bg-danger {
	background-color: #dc3545 !important;
	color: #fff !important;
}

.content {
	flex: 1;
	background-color: #fff;
	padding: 2rem;
	border-radius: 15px;
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.05);
}

footer {
	background-color: #343a40;
	color: #fff;
	padding: 1rem 0;
	text-align: center;
	border-top: 1px solid #495057;
}

footer small {
	color: #fff;
}

.text-muted {
	--bs-text-opacity: 1;
	color: #fff !important;
}
</style>
</head>
<body>
	<header>
		<%@ include file="/commons/admin/header.jsp"%>
	</header>

	<main>
		<div class="sidebar">
			<%@ include file="/commons/admin/sidebar.jsp"%>
		</div>
		<main class="content">
			<sitemesh:write property="body" />
		</main>
	</main>

	<footer>
		<%@ include file="/commons/admin/footer.jsp"%>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>