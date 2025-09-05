package vn.iotstar.controllers.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.models.User;
import vn.iotstar.services.UserService;
import vn.iotstar.services.UserServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/forgotPassword")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		User user = userService.findByEmail(email);

		if (user != null) {
			// Ở đây bạn có thể gửi email reset password
			// Tạm thời hiển thị mật khẩu cũ (DEMO, không an toàn!)
			req.setAttribute("message", "Mật khẩu của bạn là: " + user.getPassWord());
		} else {
			req.setAttribute("message", "Email không tồn tại trong hệ thống!");
		}

		req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
	}
}
