package com.skillstorm.project.dtos;

import javax.validation.constraints.NotBlank;

public class ItemDto {

	private long sku;
	private long categoryId;
	@NotBlank
	private String name;
	private String description;
	
	public ItemDto() {
		super();
	}

	public ItemDto(long sku, long categoryId, String name, String description) {
		super();
		this.sku = sku;
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}
	
}
