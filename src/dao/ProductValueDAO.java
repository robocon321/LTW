package dao;

import java.util.List;

import model.ProductTitle;
import model.ProductValue;

public interface ProductValueDAO {
	public boolean insert(ProductValue productValue);
	public boolean edit(ProductValue productValue);
	public boolean delete(int id);
	public ProductValue get(int id);
	public int getCurrentId();
	public List<ProductValue> getValues(int idTitle);
	public List<ProductValue> getAll();
}
