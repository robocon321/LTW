package service.impl;

import java.util.List;
import java.util.Map;

import dao.ProductAttributeDAO;
import dao.impl.ProductAttributeImplDAO;
import model.ProductAttribute;
import service.ProductAttributeService;

public class ProductAttributeServiceImpl implements ProductAttributeService{
	ProductAttributeDAO dao = new ProductAttributeImplDAO();

	@Override
	public boolean insert(ProductAttribute productAttribute) {
		return dao.insert(productAttribute);
	}

	@Override
	public boolean edit(ProductAttribute oldItem, ProductAttribute newItem) {
		return dao.edit(oldItem, newItem);
	}

	@Override
	public boolean delete(ProductAttribute productAttribute) {
		return dao.delete(productAttribute);
	}

	@Override
	public List<ProductAttribute> getAttributes(int productId) {
		return dao.getAttributes(productId);
	}

	@Override
	public List<ProductAttribute> getAll() {
		return dao.getAll();
	}
	
}
