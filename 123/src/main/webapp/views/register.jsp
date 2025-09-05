<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng ký tài khoản</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
        }
        .register-container {
            width: 350px;
            margin: 80px auto;
            padding: 30px;
            border: 1px solid #ccc;
            border-radius: 8px;
            background: #fff;
            box-shadow: 0 0 10px #ccc;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .input-group {
            display: flex;
            align-items: center;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 15px;
            padding: 8px;
            background: #fafafa;
        }
        .input-group i {
            margin-right: 10px;
            color: #999;
        }
        .input-group input {
            border: none;
            outline: none;
            flex: 1;
            font-size: 14px;
            background: transparent;
        }
        .btn {
            width: 100%;
            padding: 10px;
            background-color: #0096e6;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .btn:hover {
            background-color: #007bb5;
        }
        .login-link {
            text-align: center;
            margin-top: 15px;
            font-size: 14px;
        }
        .login-link a {
            color: #0096e6;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <form action="<%= request.getContextPath() %>/register" method="post">
            <h2>Tạo tài khoản mới</h2>

            <c:if test="${alert != null}">
                <h3 class="alert alert-danger">${alert}</h3>
            </c:if>

            <div class="input-group">
                <i class="fa fa-user"></i>
                <input type="text" name="username" placeholder="Tài khoản" required>
            </div>

            <div class="input-group">
                <i class="fa fa-id-card"></i>
                <input type="text" name="fullname" placeholder="Họ tên" required>
            </div>

            <div class="input-group">
                <i class="fa fa-envelope"></i>
                <input type="email" name="email" placeholder="Nhập Email" required>
            </div>

            <div class="input-group">
                <i class="fa fa-phone"></i>
                <input type="text" name="phone" placeholder="Số điện thoại" required>
            </div>

            <div class="input-group">
                <i class="fa fa-lock"></i>
                <input type="password" name="password" placeholder="Mật khẩu" required>
            </div>

            <div class="input-group">
                <i class="fa fa-lock"></i>
                <input type="password" name="confirm" placeholder="Nhập lại mật khẩu" required>
            </div>

            <button type="submit" class="btn">Tạo tài khoản</button>

            <div class="login-link">
                Nếu bạn đã có tài khoản? <a href="<%= request.getContextPath() %>/loginMVC">Đăng nhập</a>
            </div>
        </form>
    </div>
</body>
</html>
