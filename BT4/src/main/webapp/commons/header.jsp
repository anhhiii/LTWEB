<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title><c:out
		value="${pageTitle != null ? pageTitle : 'Admin Dashboard'}" /></title>

<!-- Bootstrap 5 CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">

<style>
body {
	min-height: 100vh;
	display: flex;
	background-color: #f8f9fa;
}

.content {
	flex-grow: 1;
	padding: 30px;
}

.card {
	border: none;
	border-radius: 15px;
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
	transition: transform 0.2s ease;
}

.card:hover {
	transform: translateY(-5px);
}

.user-info {
	font-size: 0.95rem;
	background: rgba(255, 255, 255, 0.1);
	padding: 8px;
	border-radius: 10px;
}
</style>
</head>
<body>