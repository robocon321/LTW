package service;

import java.util.List;

import model.Cart;

public interface CartService {
	public boolean insert(Cart cart);
	public boolean edit(Cart cart);
	public boolean delete(int userId, int productId);
	public boolean delete(int userId);
	public List<Cart> get(int userId);
	public Cart get(int userId, int productId);
	public List<Cart> getAll();
	public void addToCart(Cart cart);

}
