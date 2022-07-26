package dao;

import java.util.List;

import model.Account;
import model.ProductCategory;

public interface ProductCategoryDAO {
	public boolean insert(ProductCategory productCategory);
	public boolean edit(ProductCategory productCategory);
	public boolean delete(int id);
	public ProductCategory get(int id);
	public List<ProductCategory> getAll();
	public List<ProductCategory> findBetween(String search, int start, int size);
	public int count(String search);}
