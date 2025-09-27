package vn.iotstar.service;

import java.util.List;

import vn.iotstar.entity.Category;

public interface CategoryService {
	Category get(int id);

	Category create(Category entity);

	Category update(Category entity);

	void remove(int id);

	Category findById(int id);

	List<Category> findAll();

	boolean isExistName(String name);

	boolean isExistName(String name, int userId);

	List<Category> findByUser(int userId);

}
