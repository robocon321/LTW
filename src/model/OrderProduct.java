package model;

import java.sql.Date;

public class OrderProduct {
	private int orderId;
	private int productId;
	private int quantity;
	private Date shipDate;
	private boolean status;
	public OrderProduct(int orderId, int productId, int quantity, Date shipDate, boolean status) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.shipDate = shipDate;
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return this.orderId +"\t" +this.productId + "\t"+this.status;
	}
}
