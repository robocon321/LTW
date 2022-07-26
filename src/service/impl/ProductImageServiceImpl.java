package service.impl;

import java.util.List;

import dao.ProductImageDAO;
import dao.impl.ProductImageImplDAO;
import model.ProductImage;
import service.ProductImageService;

public class ProductImageServiceImpl implements ProductImageService{
	ProductImageDAO dao = new ProductImageImplDAO();

	@Override
	public boolean insert(ProductImage productImage) {
		return dao.insert(productImage);
	}

	@Override
	public List<ProductImage> getAll() {
		return dao.getAll();
	}

	@Override
	public List<ProductImage> getImages(int imageId) {
		return dao.getImages(imageId);
	}


	@Override
	public boolean edit(ProductImage oldImage, ProductImage newImage) {
		return dao.edit(oldImage, newImage);
	}

	@Override
	public boolean delete(ProductImage productImage) {
		return dao.delete(productImage);
	}
	
}
