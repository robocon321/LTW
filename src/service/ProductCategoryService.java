package service;

import java.util.List;

import model.Account;
import model.Admin;
import model.ProductCategory;

public interface ProductCategoryService {
	public boolean insert(ProductCategory productCategory);
	public boolean edit(ProductCategory productCategory);
	public boolean delete(int id);
	public ProductCategory get(int id);
	public List<ProductCategory> getAll();
	public List<ProductCategory> findBetween(String search);
	
	public void setSize(int size);
	public void setPage(int page);
	public int countPage();
	public int posPage();
	public int[] showPage();
}
