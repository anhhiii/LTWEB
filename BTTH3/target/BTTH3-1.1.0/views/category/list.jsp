<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Category</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-4">

    <h2 class="mb-4">Danh sách Category</h2>

    <!-- Nút thêm mới -->
    <a href="category?action=create" class="btn btn-primary mb-3">Thêm mới</a>

    <!-- Bảng hiển thị Category -->
    <table class="table table-bordered table-hover">
        <thead class="table-light">
            <tr>
                <th>ID</th>
                <th>Tên Category</th>
                <th>Ngày tạo</th>
                <th>Ngày cập nhật</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cate" items="${categoryList}">
                <tr>
                    <td>${cate.id}</td>
                    <td>${cate.name}</td>
                    <td>
                        <fmt:formatDate value="${cate.createdAt}" pattern="dd/MM/yyyy HH:mm:ss"/>
                    </td>
                    <td>
                        <fmt:formatDate value="${cate.updatedAt}" pattern="dd/MM/yyyy HH:mm:ss"/>
                    </td>
                    <td>
                        <a href="category?action=edit&id=${cate.id}" class="btn btn-sm btn-warning">Sửa</a>
                        <a href="category?action=delete&id=${cate.id}" class="btn btn-sm btn-danger"
                           onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
