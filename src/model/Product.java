package model;

import java.sql.Date;

import com.google.gson.Gson;

public class Product {
	private int productId;
	private String name;
	private String description;
	private String imageMain;
	private int price;
	private int promotionPrice;
	private boolean includeVat;
	private int quantity;
	private String detail;
	private int viewCount;
	private String brand;
	private int categoryId;
	private Date launchDate;
	private Date createdDate;
	private int createdBy;
	private boolean status;
	public Product(String name, String description, String imageMain, int price, int promotionPrice, boolean includeVat,
			int quantity, String detail, int viewCount, String brand, int categoryId, Date launchDate, Date createdDate,
			int createdBy, boolean status) {
		super();
		this.name = name;
		this.description = description;
		this.imageMain = imageMain;
		this.price = price;
		this.promotionPrice = promotionPrice;
		this.includeVat = includeVat;
		this.quantity = quantity;
		this.detail = detail;
		this.viewCount = viewCount;
		this.brand = brand;
		this.categoryId = categoryId;
		this.launchDate = launchDate;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.status = status;
	}
	public Product(int productId, String name, String description, String imageMain, int price, int promotionPrice,
			boolean includeVat, int quantity, String detail, int viewCount, String brand, int categoryId, Date launchDate,
			Date createdDate, int createdBy, boolean status) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.imageMain = imageMain;
		this.price = price;
		this.promotionPrice = promotionPrice;
		this.includeVat = includeVat;
		this.quantity = quantity;
		this.detail = detail;
		this.viewCount = viewCount;
		this.brand = brand;
		this.categoryId = categoryId;
		this.launchDate = launchDate;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.status = status;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPromotionPrice() {
		return promotionPrice;
	}
	public void setPromotionPrice(int promotionPrice) {
		this.promotionPrice = promotionPrice;
	}
	public boolean isIncludeVat() {
		return includeVat;
	}
	public void setIncludeVat(boolean includeVat) {
		this.includeVat = includeVat;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Date getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
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
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getImageMain() {
		return imageMain;
	}
	public void setImageMain(String imageMain) {
		this.imageMain = imageMain;
	}
	public String getJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	@Override
	public String toString() {
		return this.getProductId()+"\t"+this.name+"\t"+this.price+"\t"+this.quantity+"\t"+this.viewCount+"\t"+this.status;
	}
}
