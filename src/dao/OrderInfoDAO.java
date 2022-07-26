package dao;

import java.util.List;

import model.Account;
import model.OrderInfo;

public interface OrderInfoDAO {
	public boolean insert(OrderInfo orderInfo);
	public boolean edit(OrderInfo orderInfo);
	public boolean enable(int id);
	public boolean disable(int id);
	public OrderInfo get(int id);
	public int getCurrentId();
	public List<OrderInfo> getAll();
	public List<OrderInfo> findBetween(String search, int start, int size);
	public int count(String search);}
