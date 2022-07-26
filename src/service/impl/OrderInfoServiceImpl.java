package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.OrderInfoDAO;
import dao.impl.OrderInfoImplDAO;
import model.Account;
import model.OrderInfo;
import model.Product;
import service.OrderInfoService;

public class OrderInfoServiceImpl implements OrderInfoService{
	OrderInfoDAO dao = new OrderInfoImplDAO();
	private int start = 0;
	private int size = 10;
	private int countData = 0;

	@Override
	public boolean insert(OrderInfo orderInfo) {
		return dao.insert(orderInfo);
	}

	@Override
	public boolean edit(OrderInfo orderInfo) {
		return dao.edit(orderInfo);
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
	public OrderInfo get(int id) {
		return dao.get(id);
	}

	@Override
	public List<OrderInfo> getAll() {
		List<OrderInfo> list = dao.getAll();
		countData = list.size();
		return list;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public List<OrderInfo> findBetween(String search) {
		List<OrderInfo> list = dao.findBetween(search, start, size);
		countData = dao.count(search);
		return list;
	}

	@Override
	public int countPage() {
		return countData/size + 1;
	}

	@Override
	public int posPage() {
		return countData%size == 0 ? (start+1)/size : (start+1)/size+1;
	}

	@Override
	public int[] showPage() {
		int countPage = countPage();
		if(countPage < 3) {
			int[] result = new int[countPage]; 
			for(int i=0;i<result.length;i++)
				result[i] = i+1;
			return result;
		}else {
			int[] result = new int[3];
			int posPage = posPage();
			if(posPage <= 1) {
				result[0] = 1;
				result[1] = 2;
				result[2] = 3;
			}else if(posPage >= countPage) {
				result[0] = countPage-2;
				result[1] = countPage-1;
				result[2] = countPage;				
			}else {
				result[0] = posPage-1;
				result[1] = posPage;
				result[2] = posPage+1;								
			}
			return result;
		}
	}

	@Override
	public void setPage(int page) {
		start = (page-1)*size;
		if(start < 0) start = 0;
	}

	@Override
	public int getCurrentId() {
		return dao.getCurrentId();
	}

}
