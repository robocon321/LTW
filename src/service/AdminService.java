package service;

import java.util.List;

import model.Account;
import model.Admin;

public interface AdminService {
	public boolean insert(Admin admin);
	public boolean edit(Admin admin);
	public boolean disable(int id);
	public boolean enable(int id);
	public Admin get(int id);
	public Admin get(String uname);
	public List<Admin> getAll();
	public List<Admin> findBetween(String search);
	
	public void setSize(int size);
	public void setPage(int page);
	public int countPage();
	public int posPage();
	public int[] showPage();}
