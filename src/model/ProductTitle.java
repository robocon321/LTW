package model;

public class ProductTitle {
	private int titleId;
	private String titleContent;
	public ProductTitle(int titleId, String titleContent) {
		super();
		this.titleId = titleId;
		this.titleContent = titleContent;
	}
	public ProductTitle(String titleContent) {
		super();
		this.titleContent = titleContent;
	}
	public int getTitleId() {
		return titleId;
	}
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}
	public String getTitleContent() {
		return titleContent;
	}
	public void setTitleContent(String titleContent) {
		this.titleContent = titleContent;
	}
	@Override
	public String toString() {
		return this.titleId+"\t"+this.titleContent;
	}
}
