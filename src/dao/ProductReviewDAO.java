package dao;

import java.util.List;

import model.ProductReview;


public interface ProductReviewDAO {
	public boolean insert(ProductReview productImage);
	public boolean edit(ProductReview oldItem, ProductReview newItem);
	public boolean enable(int reviewId, int productId);
	public boolean disable(int reviewId, int productId);
	public ProductReview get(int reviewId, int productId);
	public List<ProductReview> getReviews(int productId);
	public List<ProductReview> getAll();
}
