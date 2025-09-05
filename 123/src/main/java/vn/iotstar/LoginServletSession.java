package vn.iotstar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServletSession")
public class LoginServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServletSession() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.sendRedirect(request.getContextPath() + "/loginSession.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		
		if (username.equals("trang")&& password.equals("123")) {
			HttpSession session = request.getSession();
			session.setAttribute("name", username);
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			out.print("Wrong!");
			request.getRequestDispatcher("LoginSession.html").include(request, response);
		}
	}

}