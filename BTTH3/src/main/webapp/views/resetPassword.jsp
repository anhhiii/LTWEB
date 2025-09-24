<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đặt lại mật khẩu</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2 class="mb-4">Đặt lại mật khẩu</h2>

    <form action="resetPassword" method="post" class="border p-4 rounded shadow-sm bg-light">
        <!-- hidden token -->
        <input type="hidden" name="token" value="<%= request.getAttribute("token") %>"/>

        <div class="mb-3">
            <label class="form-label">Mật khẩu mới:</label>
            <input type="password" class="form-control" name="password" required>
        </div>

        <button type="submit" class="btn btn-success">Cập nhật mật khẩu</button>
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
