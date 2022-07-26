package service.impl;

import java.util.List;

import dao.ProductValueDAO;
import dao.impl.ProductValueImplDAO;
import model.ProductValue;
import service.ProductValueService;

public class ProductValueServiceImpl implements ProductValueService{
	ProductValueDAO dao = new ProductValueImplDAO();

	@Override
	public boolean insert(ProductValue productValue) {
		return dao.insert(productValue);
	}

	@Override
	public boolean edit(ProductValue productValue) {
		return dao.edit(productValue);
	}

	@Override
	public boolean delete(int id) {
		return dao.delete(id);
	}

	@Override
	public ProductValue get(int id) {
		return dao.get(id);
	}

	@Override
	public List<ProductValue> getValues(int idTitle) {
		return dao.getValues(idTitle);
	}

	@Override
	public List<ProductValue> getAll() {
		return dao.getAll();
	}

}
