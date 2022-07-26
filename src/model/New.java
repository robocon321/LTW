package model;

import java.sql.Date;

public class New {
	private int newId;
	private String title;
	private String description;
	private String newImage;
	private String detail;
	private int viewCount;
	private Date createdDate;
	private int createdBy;
	private boolean status;
	public New(String title, String description, String newImage, String detail, int viewCount, Date createdDate,
			int createdBy, boolean status) {
		super();
		this.title = title;
		this.description = description;
		this.newImage = newImage;
		this.detail = detail;
		this.viewCount = viewCount;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.status = status;
	}
	public New(int newId, String title, String description, String newImage, String detail, int viewCount,
			Date createdDate, int createdBy, boolean status) {
		this.newId = newId;
		this.title = title;
		this.description = description;
		this.newImage = newImage;
		this.detail = detail;
		this.viewCount = viewCount;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.status = status;
	}
	public int getNewId() {
		return newId;
	}
	public void setNewId(int newId) {
		this.newId = newId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNewImage() {
		return newImage;
	}
	public void setNewImage(String newImage) {
		this.newImage = newImage;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
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
		return this.newId+"\t"+this.title+"\t"+this.viewCount+"\t"+this.status;
	}
}
