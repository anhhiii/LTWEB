package vn.iostar.controller.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iostar.model.User;
import vn.iostar.service.UserService;
import vn.iostar.service.impl.UserServiceImpl;
import vn.iostar.ulti.constant;

import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("user") != null) {  // đổi account → user
            System.out.println("Session exists with user: " + ((User) session.getAttribute("user")).getUserName());
            resp.sendRedirect(req.getContextPath() + "/category");
            return;
        }

        // Check cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (constant.COOKIE_REMEMBER.equals(cookie.getName())) {
                    System.out.println("Found remember cookie for username: " + cookie.getValue());
                    session = req.getSession(true);
                    // chỉ lưu username vào session, chưa phải User object
                    session.setAttribute(constant.SESSION_USERNAME, cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/category");
                    return;
                }
            }
        }

        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean isRememberMe = "on".equals(req.getParameter("remember"));

        System.out.println("Login attempt - Username: " + username + ", Password: " + password + ", Remember: " + isRememberMe);

        String alertMsg = "";
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }

        User user = service.login(username, password);
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);   // đổi account → user
            System.out.println("Login successful - Username: " + user.getUserName() + ", RoleID: " + user.getRoleid());
            if (isRememberMe) {
                saveRememberMe(resp, username);
            }
            resp.sendRedirect(req.getContextPath() + "/category");
        } else {
            alertMsg = "Tài khoản hoặc mật khẩu không đúng";
            req.setAttribute("alert", alertMsg);
            System.out.println("Login failed for username: " + username);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }

    private void saveRememberMe(HttpServletResponse response, String username) {
        Cookie cookie = new Cookie(constant.COOKIE_REMEMBER, username);
        cookie.setMaxAge(30 * 60); // 30 phút
        response.addCookie(cookie);
        System.out.println("Saved remember cookie for username: " + username);
    }
}
