package model;

public class ProductAttribute {
	private int productId;
	private int titleId;
	private int valueId;
	public ProductAttribute(int productId, int titleId, int valueId) {
		super();
		this.productId = productId;
		this.titleId = titleId;
		this.valueId = valueId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getTitleId() {
		return titleId;
	}
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}
	public int getValueId() {
		return valueId;
	}
	public void setValueId(int valueId) {
		this.valueId = valueId;
	}
	@Override
	public String toString() {
		return this.productId+"\t"+this.titleId+"\t"+this.valueId;
	}
}
