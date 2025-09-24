package vn.iostar.controller.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.model.Category;
import vn.iostar.model.User;
import vn.iostar.service.CategoryService;
import vn.iostar.service.UserService;
import vn.iostar.service.impl.CategoryServiceImpl;
import vn.iostar.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/category" })
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService categoryService = new CategoryServiceImpl();
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        // ✅ Kiểm tra session null
        if (session == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        System.out.println("User logged in: " + user.getUserName() + ", RoleID: " + user.getRoleid());

        String action = req.getParameter("action");
        if (action == null) {
            List<Category> categoryList;
            if (user.getRoleid() == 1) {
                categoryList = categoryService.getAll();
            } else {
                categoryList = categoryService.getByUserId(user.getId());
            }

            // ✅ Gắn tên người tạo vào category
            for (Category c : categoryList) {
                User creator = userService.getById(c.getUserId()); 
                if (creator != null) {
                    c.setCreatorName(creator.getFullName());
                }
            }

            req.setAttribute("categoryList", categoryList);
            req.setAttribute("userService", userService);
            req.getRequestDispatcher("/views/category/list.jsp").forward(req, resp);
        } else if (action.equals("create")) {
            req.getRequestDispatcher("/views/category/add.jsp").forward(req, resp);
        } else if (action.equals("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Category category = categoryService.get(id);
            if (category != null && (user.getRoleid() == 1 || category.getUserId() == user.getId())) {
                req.setAttribute("category", category);
                req.getRequestDispatcher("/views/category/edit.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "Bạn không có quyền sửa category này!");
                List<Category> categoryList = user.getRoleid() == 1 ? categoryService.getAll()
                        : categoryService.getByUserId(user.getId());
                req.setAttribute("categoryList", categoryList);
                req.setAttribute("userService", userService);
                req.getRequestDispatcher("/views/category/list.jsp").forward(req, resp);
            }
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Category category = categoryService.get(id);
            if (category != null && (user.getRoleid() == 1 || category.getUserId() == user.getId())) {
                categoryService.delete(id);
            }
            resp.sendRedirect(req.getContextPath() + "/category");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);

        // ✅ Kiểm tra session null
        if (session == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        String action = req.getParameter("action");
        if ("create".equals(action)) {
            String name = req.getParameter("name");
            if (categoryService.checkExistName(name, user.getId()) && user.getRoleid() != 1) {
                req.setAttribute("message", "Tên category đã tồn tại!");
                req.getRequestDispatcher("/views/category/add.jsp").forward(req, resp);
                return;
            }
            Category category = new Category();
            category.setName(name);
            category.setUserId(user.getId());
            categoryService.insert(category);
            resp.sendRedirect(req.getContextPath() + "/category");
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            Category category = categoryService.get(id);
            if (category != null && (user.getRoleid() == 1 || category.getUserId() == user.getId())) {
                category.setName(name);
                categoryService.update(category);
            } else {
                req.setAttribute("message", "Bạn không có quyền sửa category này!");
                List<Category> categoryList = user.getRoleid() == 1 ? categoryService.getAll()
                        : categoryService.getByUserId(user.getId());
                req.setAttribute("categoryList", categoryList);
                req.setAttribute("userService", userService);
                req.getRequestDispatcher("/views/category/list.jsp").forward(req, resp);
                return;
            }
            resp.sendRedirect(req.getContextPath() + "/category");
        }
    }
}
