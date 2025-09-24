<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Category</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">
	<h2 class="mb-4">Danh sách Category</h2>

	<!-- Nếu chưa đăng nhập -->
	<c:if test="${empty sessionScope.user}">
		<div class="alert alert-warning">Vui lòng đăng nhập để xem danh
			sách category!</div>
		<a href="${pageContext.request.contextPath}/login"
			class="btn btn-primary">Đăng nhập</a>
	</c:if>

	<!-- Nếu đã đăng nhập -->
	<c:if test="${not empty sessionScope.user}">
		<p class="mb-3">
			Xin chào, ${sessionScope.user.fullName} (Vai trò:
			<c:out value="${sessionScope.user.roleid == 1 ? 'Admin' : 'User'}" />
			)
		</p>

		<!-- Nút đăng xuất -->
		<a href="${pageContext.request.contextPath}/logout"
			class="btn btn-danger mb-3">Đăng xuất</a>

		<!-- Nút thêm mới -->
		<a href="${pageContext.request.contextPath}/category?action=create"
			class="btn btn-primary mb-3">Thêm mới</a>

		<!-- Thông báo -->
		<c:if test="${not empty message}">
			<div class="alert alert-info">${message}</div>
		</c:if>

		<!-- Bảng hiển thị Category -->
		<c:if test="${not empty categoryList}">
			<table class="table table-bordered table-hover">
				<thead class="table-light">
					<tr>
						<th>ID</th>
						<th>Tên Category</th>
						<th>Người tạo</th>
						<th>Ngày tạo</th>
						<th>Hành động</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cate" items="${categoryList}">
						<tr>
							<td>${cate.id}</td>
							<td>${cate.name}</td>
							<td><c:out
									value="${cate.creatorName != null ? cate.creatorName : 'Không xác định'}" /></td>
							<td><fmt:formatDate value="${cate.createdDate}"
									pattern="dd/MM/yyyy HH:mm:ss" /></td>
							<td><c:if
									test="${sessionScope.user.roleid == 1 || cate.userId == sessionScope.user.id}">
									<a
										href="${pageContext.request.contextPath}/category?action=edit&id=${cate.id}"
										class="btn btn-sm btn-warning">Sửa</a>
									<a
										href="${pageContext.request.contextPath}/category?action=delete&id=${cate.id}"
										class="btn btn-sm btn-danger"
										onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
								</c:if></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</c:if>

		<!-- Nếu không có category -->
		<c:if test="${empty categoryList}">
			<div class="alert alert-info">Chưa có category nào!</div>
		</c:if>
	</c:if>

	<a href="${pageContext.request.contextPath}/home"
		class="btn btn-secondary">Quay về</a>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
