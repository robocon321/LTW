package service.impl;

import java.util.List;

import dao.ProductTitleDAO;
import dao.impl.ProductTitleImpleDAO;
import model.ProductTitle;
import service.ProductTitleService;

public class ProductTitleServiceImpl implements ProductTitleService{
	ProductTitleDAO dao = new ProductTitleImpleDAO();

	@Override
	public boolean insert(ProductTitle productTitle) {
		return dao.insert(productTitle);
	}

	@Override
	public boolean edit(ProductTitle productTitle) {
		return dao.edit(productTitle);
	}

	@Override
	public boolean delete(int id) {
		return dao.delete(id);
	}

	@Override
	public ProductTitle get(int id) {
		return dao.get(id);
	}

	@Override
	public List<ProductTitle> getAll() {
		return dao.getAll();
	}
	
}
