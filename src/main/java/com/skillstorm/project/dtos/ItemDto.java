package com.skillstorm.project.dtos;

public class ItemDto {

	private long sku;
	private long categoryId;
	private String name;
	private String desc;
	
	public ItemDto() {
		super();
	}

	public ItemDto(long sku, long categoryId, String name, String desc) {
		super();
		this.sku = sku;
		this.categoryId = categoryId;
		this.name = name;
		this.desc = desc;
	}

	public long getSku() {
		return sku;
	}

	public void setSku(long sku) {
		this.sku = sku;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
