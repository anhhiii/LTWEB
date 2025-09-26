<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Home Manager</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<style>
    body { min-height:100vh; display:flex; background-color:#f8f9fa; }
    .sidebar { width:250px; background:#343a40; color:#fff; min-height:100vh; position:sticky; top:0; }
    .sidebar a { color:#adb5bd; text-decoration:none; padding:10px 15px; display:flex; gap:10px; }
    .sidebar a:hover { background:#495057; color:#fff; transform:translateX(5px);}
    .content { flex-grow:1; padding:30px;}
</style>
</head>
<body>

<!-- Sidebar -->
<nav class="sidebar d-flex flex-column p-3">
    <h4 class="text-center mb-4">Manager</h4>
    <ul class="nav nav-pills flex-column mb-auto">
        <li class="nav-item mb-2">
            <a href="<c:url value='/manager/home' />" class="nav-link active"><i class="bi bi-house-fill"></i> Trang chủ</a>
        </li>
        <li class="nav-item mt-3">
            <a href="<c:url value='/logout' />" class="nav-link bg-danger text-white"><i class="bi bi-box-arrow-right"></i> Đăng xuất</a>
        </li>
    </ul>
</nav>

<!-- Main content -->
<div class="content">
    <div class="container-fluid">
        <h3 class="mb-4">Category</h3>

        <div class="row g-4">
            <c:forEach items="${cateList}" var="cate">
                <c:url value="/image" var="imgUrl">
                    <c:param name="fname" value="${cate.icon}" />
                </c:url>

                <div class="col-md-4">
                    <div class="card shadow-sm h-100">
                        <img src="${imgUrl}" class="card-img-top" style="max-height: 200px; object-fit: cover;">
                        <div class="card-body">
                            <h5 class="card-title">${cate.catename}</h5>
                            <a href="<c:url value='/manager/category/edit'><c:param name='id' value='${cate.cateid}'/></c:url>" class="btn btn-warning btn-sm">Sửa</a>
                            <a href="<c:url value='/manager/category/delete'><c:param name='id' value='${cate.cateid}'/></c:url>" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>