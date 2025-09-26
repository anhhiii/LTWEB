<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-4">

            <form action="login" method="post" class="card p-4 shadow">
                <h2 class="text-center mb-4">Đăng nhập</h2>

                <!-- Hiển thị lỗi nếu login thất bại -->
                <c:if test="${not empty alert}">
                    <div class="alert alert-danger text-center">
                        ${alert}
                    </div>
                </c:if>

                <!-- Username -->
                <div class="input-group mb-3">
                    <span class="input-group-text"><i class="fa fa-user"></i></span>
                    <input type="text" class="form-control" name="username" placeholder="Tài khoản" required>
                </div>

                <!-- Password -->
                <div class="input-group mb-3">
                    <span class="input-group-text"><i class="fa fa-lock"></i></span>
                    <input type="password" class="form-control" name="password" placeholder="Mật khẩu" required>
                </div>

                <!-- Submit -->
                <div class="d-grid mb-3">
                    <button type="submit" class="btn btn-primary">Đăng nhập</button>
                </div>

                <!-- Extra options -->
                <div class="text-center">
                    <a href="forgot">Quên mật khẩu?</a><br>
                    <a href="register">Chưa có tài khoản? Đăng ký</a>
                </div>
            </form>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>