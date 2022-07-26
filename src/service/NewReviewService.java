package service;

import java.util.List;

import model.NewReview;

public interface NewReviewService {
	public boolean insert(NewReview newReview);
	public boolean edit(NewReview oldItem, NewReview newItem);
	public boolean disable(int reviewId, int newId);
	public boolean enable(int reviewId, int newId);
	public NewReview get(int reviewId, int newId);
	public List<NewReview> getReviews(int newId);
	public List<NewReview> getAll();

}
