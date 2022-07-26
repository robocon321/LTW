package service;

import java.util.List;

import model.Account;
import model.New;

public interface NewService {
	public boolean insert(New vnew);
	public boolean edit(New vnew);
	public boolean enable(int id);
	public boolean disable(int id);
	public New get(int id);
	public List<New> getAll();
	public int getCurrentId();
	public void addNew(New item, int[] newCategoryId);
	public void updateNew(New item, int[] newCategoryId);
	public List<New> findBetween(String search);
	
	public void setSize(int size);
	public void setPage(int page);
	public int countPage();
	public int posPage();
	public int[] showPage();}
