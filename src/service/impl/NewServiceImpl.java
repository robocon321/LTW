package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.ListNewCategoryDAO;
import dao.NewCategoryDAO;
import dao.NewDAO;
import dao.impl.ListNewCategoryImplDAO;
import dao.impl.NewCategoryImplDAO;
import dao.impl.NewImplDAO;
import model.Account;
import model.ListNewCategory;
import model.New;
import model.Product;
import service.NewService;

public class NewServiceImpl implements NewService{
	NewDAO dao = new NewImplDAO();
	ListNewCategoryDAO daoList = new ListNewCategoryImplDAO();
	private int start = 0;
	private int size = 10;
	private int countData = 0;
	

	@Override
	public boolean insert(New vnew) {
		return dao.insert(vnew);
	}

	@Override
	public boolean edit(New vnew) {
		return dao.edit(vnew);
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
	public New get(int id) {
		return dao.get(id);
	}

	@Override
	public List<New> getAll() {
		List<New> list = dao.getAll();
		countData = list.size();
		return list;
	}

	@Override
	public int getCurrentId() {
		return dao.getCurrentId();
	}

	@Override
	public void addNew(New item, int[] newCategoryId) {
		dao.insert(item);
		int currentId = dao.getCurrentId();
		for(int i : newCategoryId)
			daoList.insert(new ListNewCategory(currentId, i));
	}

	@Override
	public void updateNew(New item, int[] newCategoryId) {
		dao.edit(item);
		int currentId = item.getNewId();
		List<ListNewCategory> list = daoList.getCategorys(currentId);
		for(ListNewCategory newCate: list) 
			daoList.delete(newCate);
		for(int i : newCategoryId)
			daoList.insert(new ListNewCategory(currentId, i));		
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public List<New> findBetween(String search) {
		List<New> list = dao.findBetween(search, start, size);
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
		System.out.println(start +"\t"+size);
		int countPage = countPage();
		if(countPage < 3) {
			int[] result = new int[countPage]; 
			for(int i=0;i<result.length;i++)
				result[i] = i+1;
			return result;
		}else {
			System.out.println(1);
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
