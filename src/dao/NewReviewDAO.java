package dao;

import java.util.List;

import model.New;
import model.NewReview;

public interface NewReviewDAO {
	public boolean insert(NewReview newReview);
	public boolean edit(NewReview oldItem, NewReview newItem);
	public boolean disable(int reviewId, int newId);
	public boolean enable(int reviewId, int newId);
	public NewReview get(int reviewId, int newId);
	public List<NewReview> getReviews(int newId);
	public List<NewReview> getAll();
}
