package com.skillstorm.project.dtos;

public class WarehouseDto {

	private long id;
	private String name;
	private String description;
	private String address;
	private double maxCapacity;
	
	public WarehouseDto() {
		super();
	}
	
	public WarehouseDto(long id, String name, String description, String address, double maxCapacity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		this.maxCapacity = maxCapacity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setDescription(String desc) {
		this.description = desc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(double maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
}
