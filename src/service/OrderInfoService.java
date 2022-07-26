package service;

import java.util.List;

import model.Account;
import model.OrderInfo;

public interface OrderInfoService {
	public boolean insert(OrderInfo orderInfo);
	public boolean edit(OrderInfo orderInfo);
	public boolean enable(int id);
	public boolean disable(int id);
	public OrderInfo get(int id);
	public int getCurrentId();
	public List<OrderInfo> getAll();
	public List<OrderInfo> findBetween(String search);
	
	public void setSize(int size);
	public void setPage(int page);
	public int countPage();
	public int posPage();
	public int[] showPage();
}
