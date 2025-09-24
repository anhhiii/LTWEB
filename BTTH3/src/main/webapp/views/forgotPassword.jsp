<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quên mật khẩu</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2 class="mb-4">Quên mật khẩu</h2>

    <form action="forgotPassword" method="post" class="border p-4 rounded shadow-sm bg-light">
        <div class="mb-3">
            <label class="form-label">Email:</label>
            <input type="email" class="form-control" name="email" required>
        </div>

        <button type="submit" class="btn btn-primary">Gửi liên kết đặt lại</button>
        <a href="${pageContext.request.contextPath}/login" class="btn btn-secondary">Quay về đăng nhập</a>
    </form>

    <% if (request.getAttribute("message") != null) { %>
        <div class="alert alert-info mt-3">
            <%= request.getAttribute("message") %>
        </div>
    <% } %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
