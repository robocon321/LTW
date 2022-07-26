package service;

import java.util.List;

import model.Review;

public interface ReviewService {
	public boolean insert(Review review);
	public boolean edit(Review review);
	public boolean enable(int id);
	public boolean disable(int id);
	public Review get(int id);
	public List<Review> getAll();
}
