package dao;

import java.util.List;

import model.Admin;
import model.Cart;

public interface CartDAO {
	public boolean insert(Cart cart);
	public boolean edit(Cart cart);
	public boolean delete(int userId, int productId);
	public boolean delete(int userId);
	public List<Cart> get(int userId);
	public Cart get(int userId, int productId);
	public List<Cart> getAll();
}
