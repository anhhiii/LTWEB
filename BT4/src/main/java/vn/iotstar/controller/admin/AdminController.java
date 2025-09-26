package vn.iotstar.controller.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.entity.User;

@WebServlet(urlPatterns = {"/admin/home", "/admin"})
public class AdminController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    public AdminController() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        User user = (User) session.getAttribute("account");
        if (user == null || user.getRoleid() != 3) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        req.setAttribute("username", user.getUserName());

        req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
