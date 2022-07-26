package service;

import java.util.List;

import model.Account;
import model.NewCategory;

public interface NewCategoryService {
	public boolean insert(NewCategory newCategory);
	public boolean edit(NewCategory newCategory);
	public boolean delete(int id);
	public NewCategory get(int id);
	public List<NewCategory> getAll();
	public List<NewCategory> findBetween(String search);
	
	public void setSize(int size);
	public void setPage(int page);
	public int countPage();
	public int posPage();
	public int[] showPage();}
