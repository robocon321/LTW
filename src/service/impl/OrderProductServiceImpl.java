package service.impl;

import java.util.List;

import dao.OrderProductDAO;
import dao.ProductDAO;
import dao.impl.OrderProductImplDAO;
import dao.impl.ProductImplDAO;
import model.Account;
import model.OrderProduct;
import model.Product;
import service.OrderProductService;

public class OrderProductServiceImpl implements OrderProductService{
	OrderProductDAO dao = new OrderProductImplDAO();
	ProductDAO daoProduct = new ProductImplDAO();
	private int start = 0;
	private int size = 10;
	private int countData = 0;

	@Override
	public boolean insert(OrderProduct orderProduct) {
		return dao.insert(orderProduct);
	}

	@Override
	public boolean edit(OrderProduct oldItem, OrderProduct newItem) {
		return dao.edit(oldItem, newItem);
	}

	@Override
	public boolean enable(int orderId, int productId) {
		return dao.enable(orderId, productId);
	}

	@Override
	public boolean disable(int orderId, int productId) {
		return dao.disable(orderId, productId);
	}

	@Override
	public boolean delete(int orderId, int productId) {
		return dao.delete(orderId, productId);
	}

	@Override
	public OrderProduct get(int orderId, int productId) {
		return dao.get(orderId, productId);
	}

	@Override
	public List<OrderProduct> getProducts(int orderId) {
		return dao.getProducts(orderId);
	}

	@Override
	public List<OrderProduct> getAll() {
		List<OrderProduct> list = dao.getAll();
		countData = list.size();
		return list;
	}

	@Override
	public int pay(int orderId) {
		int result = 0;
		int[] list = getCost(orderId);
		for(int i:list) {
			result += i;
		}
		return result;
	}

	@Override
	public int getCost(int orderId, int productId) {
		OrderProduct item = dao.get(orderId, productId);
		return item.getQuantity()*daoProduct.get(item.getProductId()).getPrice();
	}

	@Override
	public int[] getCost(int orderId) {
		List<OrderProduct> list = getProducts(orderId);
		int size = list.size();
		int[] result = new int[size];
		for(int i=0;i<size;i++) {
			result[i] = getCost(orderId, list.get(i).getProductId());
		}
		return result;
	}
	

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public List<OrderProduct> findBetween(String search) {
		List<OrderProduct> list = dao.findBetween(search, start, size);
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
	
}
