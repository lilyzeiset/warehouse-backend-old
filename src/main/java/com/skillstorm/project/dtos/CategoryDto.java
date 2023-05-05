package com.skillstorm.project.dtos;

import javax.validation.constraints.NotBlank;

public class CategoryDto {

	private long id;
	@NotBlank 
	private String name;
	private String description;
	
	public CategoryDto() {
		super();
	}

	public CategoryDto(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	public void setDesc(String description) {
		this.description = description;
	}
	
	
}
