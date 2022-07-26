package dao;

import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.ListNewCategory;

public interface ListNewCategoryDAO {
	public boolean insert(ListNewCategory listNewCategory);
	public boolean edit(ListNewCategory oldItem, ListNewCategory newItem);
	public boolean delete(ListNewCategory listNewCategory);
	public List<ListNewCategory> getCategorys(int newId);
	public List<ListNewCategory> getNews(int newCategoryId);
	public List<ListNewCategory> getAll();
	public List<ListNewCategory> findBetween(int start, int end);
}
