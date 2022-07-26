package dao;

import java.util.List;

import model.Account;
import model.Admin;
import model.Review;

public interface AccountDAO {	
	public boolean insert(Account account);
	public boolean edit(Account account);
	public boolean disable(int id);
	public boolean enable(int id);
	public Account get(int id);
	public Account get(String uname);
	public List<Account> getAll();
	public List<Account> findBetween(String search, int start, int size);
	public int count(String search);
}
