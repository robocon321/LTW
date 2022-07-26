package model;

public class ListNewCategory {
	private int newId;
	private int newCategoryId;
	public ListNewCategory(int newId, int newCategoryId) {
		super();
		this.newId = newId;
		this.newCategoryId = newCategoryId;
	}
	public int getNewId() {
		return newId;
	}
	public void setNewId(int newId) {
		this.newId = newId;
	}
	public int getNewCategoryId() {
		return newCategoryId;
	}
	public void setNewCategoryId(int newCategoryId) {
		this.newCategoryId = newCategoryId;
	}
	@Override
	public String toString() {
		return this.newId+"\t"+this.newCategoryId;
	}
}
