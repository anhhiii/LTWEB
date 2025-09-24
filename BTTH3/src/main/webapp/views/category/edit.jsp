<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Category</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">
    <h2 class="mb-4">Sửa Category</h2>

    <c:if test="${not empty message}">
        <div class="alert alert-info">${message}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/category?action=edit" method="post">
        <input type="hidden" name="id" value="${category.id}">
        <div class="mb-3">
            <label class="form-label">Tên Category:</label>
            <input type="text" class="form-control" name="name" value="${category.name}" required>
        </div>
        <button type="submit" class="btn btn-success">Lưu</button>
        <a href="${pageContext.request.contextPath}/category" class="btn btn-secondary">Quay về</a>
    </form>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
