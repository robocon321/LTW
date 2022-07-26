package dao;

import java.util.List;

import model.ProductImage;

public interface ProductImageDAO {
	public boolean insert(ProductImage productImage);
	boolean edit(ProductImage oldImage, ProductImage newImage);
	public List<ProductImage> getAll();
	public boolean delete(ProductImage productImage);
	public List<ProductImage> getImages(int productId);
}
