package service;

import java.util.List;
import java.util.Map;

import model.ProductAttribute;

public interface ProductAttributeService {
	public boolean insert(ProductAttribute productAttribute);
	public boolean edit(ProductAttribute oldItem, ProductAttribute newItem);
	public boolean delete(ProductAttribute productAttribute);
	public List<ProductAttribute> getAttributes(int productId);
	public List<ProductAttribute> getAll();
}
