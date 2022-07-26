package service;

import java.util.List;

import model.ProductImage;

public interface ProductImageService {
	public boolean insert(ProductImage productImage);
	public boolean edit(ProductImage oldImage, ProductImage newImage);
	public boolean delete(ProductImage productImage);
	public List<ProductImage> getAll();
	public List<ProductImage> getImages(int imageId);
}
