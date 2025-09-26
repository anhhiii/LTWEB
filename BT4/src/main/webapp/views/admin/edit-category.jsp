<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa danh mục</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	min-height: 100vh;
	display: flex;
	background-color: #f8f9fa;
}

.sidebar {
    width: 250px;
    background: linear-gradient(180deg, #198754, #28a745); /* xanh lá sáng */
    color: #fff;
    min-height: 100vh;
    position: sticky;
    top: 0;
    box-shadow: 2px 0 10px rgba(0,0,0,0.2);
}

.sidebar h4 {
	font-size: 1.3rem;
	font-weight: bold;
	text-align: center;
	margin-bottom: 1.5rem;
	color: #fff; /* chắc chắn trắng */
	text-shadow: 1px 1px 3px rgba(0,0,0,0.5); /* tạo độ nổi */
}

.sidebar a {
    color: #fff;  /* chữ trắng */
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

.user-info {
	font-size: 0.95rem;
	background: rgba(255, 255, 255, 0.1);
	padding: 8px;
	border-radius: 10px;
	text-align: center;
	margin-bottom: 1.5rem;
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
</style>
</head>
<body>
	<!-- Sidebar -->
	<nav class="sidebar d-flex flex-column">
		<h4>Admin</h4>
		<div class="user-info">
			<i class="bi bi-person-circle fs-4"></i>
		</div>
		<ul class="nav flex-column mb-auto">
			<li class="nav-item"><a
				href="<c:url value='/admin/manageUsers' />" class="nav-link"><i
					class="bi bi-people-fill"></i> Account</a></li>
			<li class="nav-item"><a href="<c:url value='/admin/category' />"
				class="nav-link"><i class="bi bi-tags-fill"></i> Categories</a></li>
			<li class="nav-item"><a
				href="<c:url value='/admin/manageProducts' />" class="nav-link"><i
					class="bi bi-box-seam"></i> Products</a></li>
			<li class="nav-item mt-3"><a href="<c:url value='/logout' />"
				class="nav-link bg-danger text-white"><i
					class="bi bi-box-arrow-right"></i> Logout</a></li>
		</ul>
	</nav>

	<div class="content">
		<div class="container mt-5">
			<div class="card shadow mx-auto"
				style="max-width: 700px; width: 100%;">
				<div class="card-header">Edit Categories</div>
				<div class="card-body">

					<!-- Thông báo lỗi -->
					<c:if test="${not empty errorMsg}">
						<div class="alert alert-danger alert-dismissible fade show"
							role="alert">
							${errorMsg}
							<button type="button" class="btn-close" data-bs-dismiss="alert"
								aria-label="Close"></button>
						</div>
					</c:if>

					<form action="<c:url value='/admin/category/edit' />" method="post"
						enctype="multipart/form-data">

						<!-- Hidden ID -->
						<input type="hidden" name="id"
							value="${cate != null ? cate.cateId : ''}" />

						<!-- Tên danh mục -->
						<div class="mb-3">
							<label for="name" class="form-label">Tên danh mục:</label> <input
								type="text" class="form-control" id="name" name="name"
								value="${cate != null ? cate.cateName : ''}" required>
						</div>

						<!-- Ảnh hiện tại -->
						<div class="mb-3">
							<label class="form-label">Ảnh hiện tại:</label><br>
							<c:if test="${cate != null && not empty cate.icons}">
								<c:url value="/image" var="imgUrl">
									<c:param name="fname" value="${cate.icons}" />
								</c:url>
								<img src="${imgUrl}" class="img-thumbnail img-preview mb-2"
									alt="Icon">
							</c:if>
						</div>

						<!-- Upload ảnh mới -->
						<div class="mb-3">
							<label for="icon" class="form-label">Chọn ảnh mới:</label> <input
								type="file" class="form-control" id="icon" name="icon">
						</div>

						<!-- Buttons -->
						<div class="d-flex justify-content-between">
							<button type="submit" class="btn btn-primary">Lưu</button>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>