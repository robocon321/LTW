package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.Product;
import model.ProductAttribute;
import model.ProductImage;
import model.ProductTitle;
import model.ProductValue;

public interface ProductService {
	public boolean insert(Product product);
	public boolean edit(Product product);
	public boolean enable(int id);
	public boolean disalbe(int id);
	public Product get(int id);
	public List<Product> getAll();
	public List<ProductAttribute> getAttribute(int productId);
	public ProductTitle getTitle(int titleId);
	public ProductValue getValue(int valueId);
	public int getCurrentId();
	public List<ProductImage> getImages(int productId);
	public void addProduct(Product product, ArrayList<String> images, String[] title, String[] value);
	public void updateProduct(Product product, ArrayList<String> images, String[] title, String[] value);

	public int countPage();
	public List<Product> findBetween(String search);
	public void setSize(int size);
	public void setPage(int page);
	public int posPage();
	public int[] showPage();
}
