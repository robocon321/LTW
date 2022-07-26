package service.impl;

import java.util.List;

import dao.ListNewCategoryDAO;
import dao.impl.ListNewCategoryImplDAO;
import model.ListNewCategory;
import service.ListNewCategoryService;

public class ListNewCategoryServiceImpl implements ListNewCategoryService{
	ListNewCategoryDAO dao = new ListNewCategoryImplDAO();

	@Override
	public boolean insert(ListNewCategory listNewCategory) {
		return dao.insert(listNewCategory);
	}

	@Override
	public boolean edit(ListNewCategory oldItem, ListNewCategory newItem) {
		return dao.edit(oldItem, newItem);
	}

	@Override
	public boolean delete(ListNewCategory listNewCategory) {
		return dao.delete(listNewCategory);
	}

	@Override
	public List<ListNewCategory> getCategorys(int newId) {
		return dao.getCategorys(newId);
	}

	@Override
	public List<ListNewCategory> getNews(int newCategoryId) {
		return dao.getNews(newCategoryId);
	}

	@Override
	public List<ListNewCategory> getAll() {
		return dao.getAll();
	}
	
}
