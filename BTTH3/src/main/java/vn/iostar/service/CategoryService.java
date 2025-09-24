package vn.iostar.service;

import vn.iostar.model.Category;
import java.util.List;

public interface CategoryService {
	void insert(Category category);

	void update(Category category);

	void delete(int id);

	Category get(int id);

	List<Category> getAll();

	List<Category> getByUserId(int userId);

	boolean checkExistName(String name, int userId);
}