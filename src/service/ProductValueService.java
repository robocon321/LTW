package service;

import java.util.List;

import model.ProductValue;

public interface ProductValueService {
	public boolean insert(ProductValue productValue);
	public boolean edit(ProductValue productValue);
	public boolean delete(int id);
	public ProductValue get(int id);
	public List<ProductValue> getValues(int idTitle);
	public List<ProductValue> getAll();
}
