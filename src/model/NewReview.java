package model;

public class NewReview {
	private int reviewId;
	private int newId;
	private int star;
	private boolean status;
	public NewReview(int reviewId, int newId, int star, boolean status) {
		this.reviewId = reviewId;
		this.newId = newId;
		this.star = star;
		this.status = status;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getNewId() {
		return newId;
	}
	public void setNewId(int newId) {
		this.newId = newId;
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
		return this.reviewId+"\t"+this.newId+"\t"+this.star+"\t"+this.status;
	}
}
