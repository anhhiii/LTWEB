package vn.iotstar.controllers.admin;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.models.User;



@WebServlet(urlPatterns = "/home")
public class HomeController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException{
		HttpSession session = req.getSession(false);
		if (session == null) {
			resp.sendRedirect(req.getContextPath() + "/loginMVC");
			return;
		}
		
		User user = (User) session.getAttribute("account");
		if (user == null || user.getRoleid() != 5) {
			resp.sendRedirect(req.getContextPath() + "/loginMVC");
			return;
		}

		req.setAttribute("username", user.getUserName());

		req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
