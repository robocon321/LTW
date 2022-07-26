package dao;

import java.util.List;

import model.ProductImage;
import model.ProductReview;
import model.ProductTitle;

public interface ProductTitleDAO {
	public boolean insert(ProductTitle productTitle);
	public boolean edit(ProductTitle productTitle);
	public boolean delete(int id);
	public ProductTitle get(int id);
	public int find(String title);
	public int getCurrentId();
	public List<ProductTitle> getAll();
}
