package service;

import java.util.List;

import model.Account;
import model.OrderProduct;

public interface OrderProductService {
	public boolean insert(OrderProduct orderProduct);
	public boolean edit(OrderProduct oldItem, OrderProduct newItem);
	public boolean enable(int orderId, int productId);
	public boolean disable(int orderId, int productId);	
	public boolean delete(int orderId, int productId);
	public OrderProduct get(int orderId, int productId);
	public List<OrderProduct> getProducts(int orderId);
	public int getCost(int orderId, int productId);
	public int[] getCost(int orderId);
	public int pay(int orderId);
	public List<OrderProduct> getAll();
	public List<OrderProduct> findBetween(String search);
	
	public void setSize(int size);
	public void setPage(int page);
	public int countPage();
	public int posPage();
	public int[] showPage();
}
