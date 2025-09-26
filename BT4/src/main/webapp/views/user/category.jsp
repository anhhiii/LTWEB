<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Danh sách danh mục</title>
<!-- Bootstrap 5 CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
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
	padding: 1rem;
}

.sidebar h4 {
	font-size: 1.3rem;
	font-weight: bold;
	text-align: center;
	margin-bottom: 1.5rem;
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
	margin-bottom: 0.5rem;
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

	<!-- Main content -->
	<div class="content">
		<div class="card shadow-sm">
			<div class="card-header bg-primary text-white">
				<h5 class="mb-0">Categories</h5>
			</div>
			<div class="card-body">
				<div class="d-flex justify-content-end mb-3">
					<a href="<c:url value='/user/category/add' />"
						class="btn btn-success">Add</a>
				</div>
				<!-- Table danh mục -->
				<table class="table table-striped table-hover align-middle">
					<thead class="table-dark">
						<tr>
							<th>#</th>
							<th>Image</th>
							<th>Category</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cateList}" var="cate" varStatus="STT">
							<c:url value="/image" var="imgUrl">
								<c:param name="fname" value="${cate.icons}" />
							</c:url>
							<tr>
								<td>${STT.index + 1}</td>
								<td><img src="${imgUrl}" class="img-thumbnail"
									style="max-height: 150px; max-width: 200px;" /></td>
								<td>${cate.cateName}</td>
								<td><a
									href="<c:url value='/user/category/edit'><c:param name='id' value='${cate.cateId}'/></c:url>"
									class="btn btn-sm btn-warning me-1">Edit</a> <a
									href="<c:url value='/user/category/delete'><c:param name='id' value='${cate.cateId}'/></c:url>"
									class="btn btn-sm btn-danger"
									onclick="return confirm('Bạn có chắc muốn xóa?');">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- Bootstrap 5 JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>