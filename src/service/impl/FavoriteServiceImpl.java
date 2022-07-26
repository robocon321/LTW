package service.impl;

import java.util.List;

import dao.FavoriteDAO;
import dao.impl.FavoriteImplDAO;
import model.Favorite;
import service.FavoriteService;

public class FavoriteServiceImpl implements FavoriteService{
	FavoriteDAO dao = new FavoriteImplDAO();

	@Override
	public boolean insert(Favorite favorite) {
		return dao.insert(favorite);
	}

	@Override
	public boolean delete(int userId, int productId) {
		return dao.delete(userId, productId);
	}

	@Override
	public List<Favorite> get(int id) {
		return dao.get(id);
	}

	@Override
	public List<Favorite> getAll() {
		return dao.getAll();
	}

	@Override
	public boolean delete(int userId) {
		return dao.delete(userId);
	}
	

}
