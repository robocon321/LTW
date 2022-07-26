package service.impl;

import java.util.List;

import dao.CartDAO;
import dao.impl.CartImplDAO;
import model.Cart;
import service.CartService;

public class CartServiceImpl implements CartService {
	CartDAO dao = new CartImplDAO();

	@Override
	public boolean insert(Cart cart) {
		return dao.insert(cart);
	}

	@Override
	public boolean edit(Cart cart) {
		return dao.edit(cart);
	}

	@Override
	public boolean delete(int userId, int productId) {
		return dao.delete(userId, productId);
	}

	@Override
	public List<Cart> get(int userId) {
		return dao.get(userId);
	}

	@Override
	public List<Cart> getAll() {
		return dao.getAll();
	}

	@Override
	public Cart get(int userId, int productId) {
		return dao.get(userId, productId);
	}

	@Override
	public void addToCart(Cart cart) {
		Cart cartFind = get(cart.getUserId(), cart.getProductId());
		if (cartFind == null) {
			insert(cart);
		} else {
			Cart cartUpdate = new Cart(cartFind.getUserId(), cartFind.getProductId(),
					cartFind.getQuantity() + cart.getQuantity());
			edit(cartUpdate);
		}
	}

	@Override
	public boolean delete(int userId) {
		return dao.delete(userId);
	}

}
