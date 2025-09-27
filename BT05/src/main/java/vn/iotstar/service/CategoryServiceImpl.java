package vn.iotstar.service;

import java.util.List;

import vn.iotstar.dao.CategoryDao;
import vn.iotstar.dao.CategoryDaoImpl;
import vn.iotstar.entity.Category;

public class CategoryServiceImpl implements CategoryService{

	private CategoryDao categoryDao;

    public CategoryServiceImpl() {
        this.categoryDao = new CategoryDaoImpl(); // khởi tạo DAO
    }

    @Override
    public Category create(Category entity) {
        return categoryDao.create(entity);
    }

    @Override
    public Category update(Category entity) {
        return categoryDao.update(entity);
    }

    @Override
    public void remove(int id) {
        categoryDao.remove(id);
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
    
    @Override
    public boolean isExistName(String name) {
        return categoryDao.isExistName(name);
    }

    @Override
    public boolean isExistName(String name, int userId) {
        return categoryDao.isExistName(name, userId);
    }
    @Override
    public Category get(int id) {
    	return categoryDao.get(id);
    }
    
    @Override
    public List<Category> findByUser(int userId){
    	return categoryDao.findByUser(userId);
    }
}
