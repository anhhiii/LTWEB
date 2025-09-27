package vn.iotstar.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.User;
import vn.iotstar.service.*;
import vn.iotstar.ultis.Constants;

@WebServlet(urlPatterns = { "/admin/category", "/admin/category/add", "/admin/category/edit",
        "/admin/category/delete" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    CategoryService cateService = new CategoryServiceImpl();

    public CategoryController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getServletPath();

        if (url.contains("add")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-category.jsp");
            dispatcher.forward(req, resp);

        } else if (url.contains("edit")) {
            String id = req.getParameter("id");
            if (id == null || id.isEmpty()) {
                ListAll(req, resp);
                return;
            }

            Category category = cateService.get(Integer.parseInt(id));
            req.setAttribute("cate", category);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit-category.jsp");
            dispatcher.forward(req, resp);

        } else if (url.contains("delete")) {
            String id = req.getParameter("id");
            if (id != null && !id.isEmpty()) {
                cateService.remove(Integer.parseInt(id));
            }
            resp.sendRedirect(req.getContextPath() + "/admin/category");

        } else {
            ListAll(req, resp);
        }
    }

    private void ListAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("account");

        if (currentUser == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        int roleId = currentUser.getRoleid();
        List<Category> cateList;

        if (roleId == 3 || roleId == 1) {
            // admin, user -> tất cả
            cateList = cateService.findAll();
        } else {
            // manager -> theo user
            cateList = cateService.findByUser(currentUser.getId());
        }

        req.setAttribute("cateList", cateList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/category.jsp");
        dispatcher.forward(req, resp);
    }

    private void InsertCate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        User currentUser = (User) req.getSession().getAttribute("account");
        if (currentUser == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        Category category = new Category();
        category.setUser(currentUser);

        String idStr = req.getParameter("id");
        boolean isEdit = false;
        if (idStr != null && !idStr.isEmpty()) {
            category.setCateId(Integer.parseInt(idStr));
            isEdit = true;
        }

        String name = req.getParameter("name");

        if (cateService.isExistName(name, currentUser.getId())) {
            req.setAttribute("errorMsg", "Danh mục đã tồn tại!");
            req.getRequestDispatcher("/views/admin/add-category.jsp").forward(req, resp);
            return;
        }

        category.setCateName(name);

        // upload icon
        Part filePart = req.getPart("icon");
        String filename = null;
        if (filePart != null && filePart.getSize() > 0) {
            String uploadDir = Constants.DIR;
            File dir = new File(uploadDir);
            if (!dir.exists())
                dir.mkdirs();

            String originalFileName = new File(filePart.getSubmittedFileName()).getName();
            int index = originalFileName.lastIndexOf(".");
            String ext = index > 0 ? originalFileName.substring(index + 1) : "";
            filename = System.currentTimeMillis() + (ext.isEmpty() ? "" : "." + ext);

            filePart.write(uploadDir + File.separator + filename);
            category.setIcons(filename);
        }

        if (isEdit) {
            cateService.update(category);
        } else {
            cateService.create(category);
        }

        resp.sendRedirect(req.getContextPath() + "/admin/category");
    }

    private void UpdateCate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String idStr = req.getParameter("id");
        if (idStr == null || idStr.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/admin/category");
            return;
        }

        int id = Integer.parseInt(idStr);
        Category oldCategory = cateService.get(id);
        Category category = new Category();

        category.setCateId(id);
        category.setCateName(req.getParameter("name"));
        category.setUser(oldCategory.getUser());

        // update icon
        Part filePart = req.getPart("icon");
        if (filePart != null && filePart.getSize() > 0) {
            String uploadDir = Constants.DIR;
            File dir = new File(uploadDir);
            if (!dir.exists())
                dir.mkdirs();

            String originalFileName = new File(filePart.getSubmittedFileName()).getName();
            int index = originalFileName.lastIndexOf(".");
            String ext = index > 0 ? originalFileName.substring(index + 1) : "";
            String fileName = System.currentTimeMillis() + (ext.isEmpty() ? "" : "." + ext);

            filePart.write(uploadDir + File.separator + fileName);
            category.setIcons(fileName);

            // xóa file cũ
            String oldFile = oldCategory.getIcons();
            if (oldFile != null) {
                File f = new File(uploadDir + File.separator + oldFile);
                if (f.exists())
                    f.delete();
            }
        } else {
            category.setIcons(oldCategory.getIcons());
        }

        cateService.update(category);
        resp.sendRedirect(req.getContextPath() + "/admin/category");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();

        if (url.contains("add")) {
            InsertCate(req, resp);
        } else if (url.contains("edit")) {
            UpdateCate(req, resp);
        } else {
            doGet(req, resp);
        }
    }
}
