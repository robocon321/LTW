package model;

public class ProductImage {
	private int productId;
	private String imageUrlContent;
	public ProductImage(int productId, String imageUrlContent) {
		super();
		this.productId = productId;
		this.imageUrlContent = imageUrlContent;
	}

	public String getImageUrlContent() {
		return imageUrlContent;
	}
	public void setImageUrlContent(String imageUrlContent) {
		this.imageUrlContent = imageUrlContent;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return this.productId+"\t"+this.imageUrlContent;
	}
	
}
