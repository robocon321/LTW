package model;

import dao.ProductCategoryDAO;
import dao.impl.ProductCategoryImplDAO;

public class NewCategory {
	private int newCategoryId;
	private String name;
	private int parentId;
	public NewCategory(int newCategoryId, String name, int parentId) {
		super();
		this.newCategoryId = newCategoryId;
		this.name = name;
		this.parentId = parentId;
	}
	public NewCategory(String name, int parentId) {
		super();
		this.name = name;
		this.parentId = parentId;
	}
	
	public int getNewCategoryId() {
		return newCategoryId;
	}
	public void setNewCategoryId(int newCategoryId) {
		this.newCategoryId = newCategoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public ProductCategory getParent() {
		ProductCategoryDAO dao = new ProductCategoryImplDAO();
		return dao.get(parentId);
	}
	@Override
	public String toString() {
		return this.getNewCategoryId()+"\t"+this.getName()+"\t"+this.getParentId();
	}
}
