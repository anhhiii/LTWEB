package vn.iostar.dao;

import vn.iostar.model.Category;
import java.util.List;

public interface CategoryDao {
    void insert(Category category);
    void update(Category category);
    void delete(int id);
    Category get(int id);
    List<Category> getAll();
    List<Category> getByUserId(int userId); // Lấy category của 1 user cụ thể
    boolean checkExistName(String name, int userId);
}