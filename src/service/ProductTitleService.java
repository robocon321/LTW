package service;

import java.util.List;

import model.ProductTitle;

public interface ProductTitleService {
	public boolean insert(ProductTitle productTitle);
	public boolean edit(ProductTitle productTitle);
	public boolean delete(int id);
	public ProductTitle get(int id);
	public List<ProductTitle> getAll();
}
