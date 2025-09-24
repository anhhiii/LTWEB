<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .login-container {
            width: 350px;
            margin: 80px auto;
            border: 1px solid #ccc;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px #ccc;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-control {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }
        .input-group-addon {
            margin-right: 8px;
        }
        .remember-forgot {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
        }
        .login-btn {
            width: 100%;
            padding: 10px;
            background-color: #0096e6;
            color: white;
            border: none;
            cursor: pointer;
        }
        .register-link {
            text-align: center;
            margin-top: 15px;
        }
        .register-link a {
            color: #0096e6;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <form action="<%= request.getContextPath() %>/loginMVC" method="post">
            <h2>Đăng Nhập Vào Hệ Thống</h2>

            <c:if test="${alert != null}">
                <h3 class="alert alert-danger">${alert}</h3>
            </c:if>

            <div>
                <label>
                    <i class="fa fa-user input-group-addon"></i>
                    <input type="text" name="username" placeholder="Tài khoản" class="form-control" required>
                </label>
            </div>

            <div>
                <label>
                    <i class="fa fa-lock input-group-addon"></i>
                    <input type="password" name="password" placeholder="Mật khẩu" class="form-control" required>
                </label>
            </div>

            <div class="remember-forgot">
                <label><input type="checkbox" name="remember"> Nhớ tôi</label>
                <a href="<%= request.getContextPath() %>/forgotPassword">Quên mật khẩu?</a>
            </div>

            <button type="submit" class="login-btn">Đăng nhập</button>

            <div class="register-link">
                Nếu bạn chưa có tài khoản trên hệ thống, thì hãy <a href="<%= request.getContextPath() %>/register">Đăng ký</a>
            </div>
        </form>
    </div>
</body>
</html>
