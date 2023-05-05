package com.skillstorm.project.dtos;

import javax.validation.constraints.Min;

public class LotDto {

	private long id;
	private long warehouseId;
	private long itemId;
	@Min(1)
	private int quantity;
	private String location;
	
	public LotDto() {
		super();
	}

	public LotDto(long id, long warehouseId, long itemId, int quantity, String location) {
		super();
		this.id = id;
		this.warehouseId = warehouseId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
