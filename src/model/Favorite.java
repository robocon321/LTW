package model;

public class Favorite {
	private int userId;
	private int productId;
	public Favorite(int userId, int productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return this.userId+"\t"+this.productId;
	}
}
