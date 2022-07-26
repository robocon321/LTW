package service;

import java.util.List;

import model.ListNewCategory;

public interface ListNewCategoryService {
	public boolean insert(ListNewCategory listNewCategory);
	public boolean edit(ListNewCategory oldItem, ListNewCategory newItem);
	public boolean delete(ListNewCategory listNewCategory);
	public List<ListNewCategory> getCategorys(int newId);
	public List<ListNewCategory> getNews(int newCategoryId);
	public List<ListNewCategory> getAll();

}
