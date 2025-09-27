<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Thêm danh mục mới</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<div class="card shadow-sm mx-auto" style="max-width: 450px;">
			<div class="card-header bg-primary text-white text-center">
				Thêm danh mục mới</div>
			<div class="card-body">
				<c:if test="${not empty errorMsg}">
					<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						${errorMsg}
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
				</c:if>

				<form action="<c:url value='/user/category/add' />" method="post" enctype="multipart/form-data">
					<div class="mb-3">
						<input type="text" class="form-control" name="name"
							placeholder="Tên danh mục" required>
					</div>
					<div class="mb-3">
						<input type="file" class="form-control" name="icon"
							accept="image/*" required>
					</div>
					<div class="d-flex justify-content-center gap-2">
						<button type="submit" class="btn btn-success btn-sm">Thêm</button>
						<button type="reset" class="btn btn-secondary btn-sm">Hủy</button>
					</div>
				</form>

			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>