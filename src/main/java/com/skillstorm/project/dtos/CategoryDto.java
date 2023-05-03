package com.skillstorm.project.dtos;

public class CategoryDto {

	private long id;
	private String name;
	private String desc;
	
	public CategoryDto() {
		super();
	}

	public CategoryDto(long id, String name, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
