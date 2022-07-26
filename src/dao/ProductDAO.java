package dao;

import java.util.List;

import model.Account;
import model.Product;

public interface ProductDAO {
	public boolean insert(Product product);
	public boolean edit(Product product);
	public boolean enable(int id);
	public boolean disalbe(int id);
	public Product get(int id);
	public List<Product> getAll();
	public int getCurrentId();
	public List<Product> findBetween(String search, int start, int size);
	public int count(String search);
}
