package vn.iostar.service.impl;

import vn.iostar.dao.CategoryDao;
import vn.iostar.dao.impl.CategoryDaoImpl;
import vn.iostar.model.Category;
import vn.iostar.service.CategoryService;

//import java.util.Date;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public void insert(Category category) {
        if (checkExistName(category.getName(), category.getUserId())) {
            return; // Không thêm nếu tên đã tồn tại
        }
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        category.setCreatedDate(date);
        categoryDao.insert(category);
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public Category get(int id) {
        return categoryDao.get(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public List<Category> getByUserId(int userId) {
        return categoryDao.getByUserId(userId);
    }

    @Override
    public boolean checkExistName(String name, int userId) {
        return categoryDao.checkExistName(name, userId);
    }
}