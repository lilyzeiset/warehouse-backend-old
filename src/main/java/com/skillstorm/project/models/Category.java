package com.skillstorm.project.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a category of items
 * @author lily
 *
 */
@Entity @Table(name = "category")
public class Category {

	/**
	 * Primary key
	 */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private long id;
	
	/**
	 * Name of category
	 */
	@Column
	private String name;
	
	/**
	 * Description of category
	 */
	@Column
	private String desc;

	public Category() {
		super();
	}

	public Category(long id, String name, String desc) {
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return id == other.id;
	}
	
	
}
