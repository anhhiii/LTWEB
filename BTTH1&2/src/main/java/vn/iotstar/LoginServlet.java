package vn.iotstar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        // Giả sử user: trang, pass: 123
        if ("trang".equals(user) && "123".equals(pass)) {
            // Tạo cookie lưu username
            Cookie cookie = new Cookie("username", user);
            cookie.setMaxAge(60 * 30); // 30 phút
            resp.addCookie(cookie);

            // Redirect sang trang chào mừng
            resp.sendRedirect("hello");
        } else {
            // Sai thông tin đăng nhập, quay về trang login
            resp.sendRedirect("login.html");
        }
    }
}
