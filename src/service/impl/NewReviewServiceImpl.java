package service.impl;

import java.util.List;

import dao.NewReviewDAO;
import dao.impl.NewReviewImplDAO;
import model.NewReview;
import service.NewReviewService;

public class NewReviewServiceImpl implements NewReviewService{
	NewReviewDAO dao = new NewReviewImplDAO();

	@Override
	public boolean insert(NewReview newReview) {
		return dao.insert(newReview);
	}

	@Override
	public boolean edit(NewReview oldItem, NewReview newItem) {
		return dao.edit(oldItem, newItem);
	}

	@Override
	public boolean disable(int reviewId, int newId) {
		return dao.disable(reviewId, newId);
	}

	@Override
	public boolean enable(int reviewId, int newId) {
		return dao.enable(reviewId, newId);
	}

	@Override
	public NewReview get(int reviewId, int newId) {
		return dao.get(reviewId, newId);
	}

	@Override
	public List<NewReview> getReviews(int newId) {
		return dao.getReviews(newId);
	}

	@Override
	public List<NewReview> getAll() {
		return dao.getAll();
	}
	
}
