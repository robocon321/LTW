package service.impl;

import java.util.List;

import dao.ReviewDAO;
import dao.impl.ReviewImplDAO;
import model.Review;
import service.ReviewService;

public class ReviewServiceImpl implements ReviewService{
	ReviewDAO dao = new ReviewImplDAO();

	@Override
	public boolean insert(Review review) {
		return dao.insert(review);
	}

	@Override
	public boolean edit(Review review) {
		return dao.edit(review);
	}

	@Override
	public boolean enable(int id) {
		return dao.enable(id);
	}

	@Override
	public boolean disable(int id) {
		return dao.disable(id);
	}

	@Override
	public Review get(int id) {
		return dao.get(id);
	}

	@Override
	public List<Review> getAll() {
		return dao.getAll();
	}
	
}
