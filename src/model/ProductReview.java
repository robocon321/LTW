package model;

public class ProductReview {
	private int reviewId;
	private int productId;
	private int star;
	private boolean status;
	public ProductReview(int reviewId, int productId, int star, boolean status) {
		super();
		this.reviewId = reviewId;
		this.productId = productId;
		this.star = star;
		this.status = status;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return this.reviewId+"\t"+this.productId+"\t"+this.star+"\t"+this.status;
	}

}
