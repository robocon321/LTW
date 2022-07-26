package model;

public class ProductValue {
	private int valueId;
	private String valueContent;
	private int titleId;
	public ProductValue(int valueId, String valueContent, int titleId) {
		super();
		this.valueId = valueId;
		this.valueContent = valueContent;
		this.titleId = titleId;
	}
	public ProductValue(String valueContent, int titleId) {
		super();
		this.valueContent = valueContent;
		this.titleId = titleId;
	}
	public int getValueId() {
		return valueId;
	}
	public void setValueId(int valueId) {
		this.valueId = valueId;
	}
	public String getValueContent() {
		return valueContent;
	}
	public void setValueContent(String valueContent) {
		this.valueContent = valueContent;
	}
	public int getTitleId() {
		return titleId;
	}
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}
	@Override
	public String toString() {
		return this.valueId+"\t"+this.valueContent+"\t"+this.titleId;
	}
}
