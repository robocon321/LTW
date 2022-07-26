package model;

import java.sql.Date;

public class OrderInfo {
	private int orderId;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String email;
	private Date createdDate;
	private int createdBy;
	private boolean status;
	public OrderInfo(String firstName, String lastName, String address, String phone, String email, Date createdDate,
			int createdBy, boolean status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.status = status;
	}
	public OrderInfo(int orderId, String firstName, String lastName, String address, String phone, String email,
			Date createdDate, int createdBy, boolean status) {
		super();
		this.orderId = orderId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		return this.orderId+"\t"+this.firstName+"\t"+this.status;
	}
}
