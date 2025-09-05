package vn.iotstar;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/hi", "/trangchu"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("ten");
		String lastname = req.getParameter("holot");
		
		PrintWriter out = resp.getWriter();
		
		out.println("Hello World!" + lastname + " " + name	);
		out.close();
	}
	
}
