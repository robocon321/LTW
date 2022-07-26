package model;

import dao.ProductCategoryDAO;
import dao.impl.ProductCategoryImplDAO;
import service.impl.ProductCategoryServiceImpl;

public class ProductCategory {
	private int categoryId;
	private String name;
	private int parentId;
	
	public ProductCategory(String name, int parentId) {
		super();
		this.name = name;
		this.parentId = parentId;
	}
	public ProductCategory(int categoryId, String name, int parentId) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.parentId = parentId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
		return this.categoryId+"\t"+this.name+"\t"+this.parentId;
	}
}
