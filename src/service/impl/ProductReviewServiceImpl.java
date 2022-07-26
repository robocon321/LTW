package service.impl;

import java.util.List;

import dao.ProductReviewDAO;
import dao.impl.ProductReviewImplDAO;
import model.ProductReview;
import service.ProductReviewService;

public class ProductReviewServiceImpl implements ProductReviewService{
	ProductReviewDAO dao = new ProductReviewImplDAO();

	@Override
	public boolean insert(ProductReview productImage) {
		return dao.insert(productImage);
	}

	@Override
	public boolean edit(ProductReview oldItem, ProductReview newItem) {
		return dao.edit(oldItem, newItem);
	}

	@Override
	public boolean enable(int reviewId, int productId) {
		return dao.enable(reviewId, productId);
	}

	@Override
	public boolean disable(int reviewId, int productId) {
		return dao.disable(reviewId, productId);
	}

	@Override
	public ProductReview get(int reviewId, int productId) {
		return dao.get(reviewId, productId);
	}

	@Override
	public List<ProductReview> getReviews(int productId) {
		return dao.getReviews(productId);
	}

	@Override
	public List<ProductReview> getAll() {
		return dao.getAll();
	}
	
}
