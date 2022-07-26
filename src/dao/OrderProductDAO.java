package dao;

import java.util.List;

import model.Account;
import model.OrderProduct;

public interface OrderProductDAO {
	public boolean insert(OrderProduct orderProduct);
	public boolean edit(OrderProduct oldItem, OrderProduct newItem);
	public boolean enable(int orderId, int productId);
	public boolean disable(int orderId, int productId);	
	public boolean delete(int orderId, int productId);
	public OrderProduct get(int orderId, int productId);
	public List<OrderProduct> getProducts(int orderId);
	public List<OrderProduct> getAll();
	public List<OrderProduct> findBetween(String search, int start, int size);
	public int count(String search);}
