package model;

import java.sql.Date;

public class Review {
	private int reviewId;
	private String title;
	private String content;
	private Date createdDate;
	private int createdBy;
	private boolean status;
	public Review(int reviewId, String title, String content, Date createdDate, int createdBy, boolean status) {
		super();
		this.reviewId = reviewId;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.status = status;
	}
	public Review( String title, String content, Date createdDate, int createdBy, boolean status) {
		super();
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.status = status;
	}	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return this.reviewId+"\t"+this.title+"\t"+this.status;
	}
}
