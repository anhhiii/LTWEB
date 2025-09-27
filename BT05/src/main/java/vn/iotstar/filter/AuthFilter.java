package vn.iotstar.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.entity.User;

@WebFilter("/*")
public class AuthFilter implements Filter{

	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();

        HttpSession session = req.getSession(false);

        if (uri.endsWith("/login") || uri.contains("/css") || uri.contains("/js") || uri.contains("/images")) {
            chain.doFilter(request, response);
            return;
        }

        if (session == null || session.getAttribute("account") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        User user = (User) session.getAttribute("account");
        int role = user.getRoleid();

        if (uri.startsWith(req.getContextPath() + "/admin") && role != 3) {
            resp.sendRedirect(req.getContextPath() + "/accessDenied.jsp");
            return;
        }
        if (uri.startsWith(req.getContextPath() + "/manager") && role != 2 && role != 3) {
            resp.sendRedirect(req.getContextPath() + "/accessDenied.jsp");
            return;
        }
        if (uri.startsWith(req.getContextPath() + "/user") && role != 1 && role != 2 && role != 3) {
            resp.sendRedirect(req.getContextPath() + "/accessDenied.jsp");
            return;
        }

        chain.doFilter(request, response);
    }
}
