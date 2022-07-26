package dao;

import java.util.List;

import model.Account;
import model.New;

public interface NewDAO {
	public boolean insert(New vnew);
	public boolean edit(New vnew);
	public boolean enable(int id);
	public boolean disable(int id);
	public New get(int id);
	public List<New> getAll();
	public int getCurrentId();
	public List<New> findBetween(String search, int start, int size);
	public int count(String search);}
