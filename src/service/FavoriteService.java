package service;

import java.util.List;

import model.Favorite;

public interface FavoriteService {
	public boolean insert(Favorite favorite);
	public boolean delete(int userId, int productId);
	public boolean delete(int userId);
	public List<Favorite> get(int id);
	public List<Favorite> getAll();
}
