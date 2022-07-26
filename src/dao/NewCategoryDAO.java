package dao;

import java.util.List;

import model.Account;
import model.NewCategory;

public interface NewCategoryDAO {
	public boolean insert(NewCategory newCategory);
	public boolean edit(NewCategory newCategory);
	public boolean delete(int id);
	public NewCategory get(int id);
	public List<NewCategory> getAll();
	public List<NewCategory> findBetween(String search, int start, int size);
	public int count(String search);}
