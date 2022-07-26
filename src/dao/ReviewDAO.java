package dao;

import java.util.List;

import model.ProductValue;
import model.Review;

public interface ReviewDAO {
	public boolean insert(Review review);
	public boolean edit(Review review);
	public boolean enable(int id);
	public boolean disable(int id);
	public Review get(int id);
	public List<Review> getAll();

}
