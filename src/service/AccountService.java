package service;

import java.util.List;

import model.Account;

public interface AccountService {
	public boolean insert(Account account);
	public boolean edit(Account account);
	public boolean disable(int id);
	public boolean enable(int id);
	public Account get(int id);
	public Account get(String uname);
	public List<Account> getAll();
	public List<Account> findBetween(String search);
	
	public boolean login(String uname, String pwd);
	public void setSize(int size);
	public void setPage(int page);
	public int countPage();
	public int posPage();
	public int[] showPage();
}
