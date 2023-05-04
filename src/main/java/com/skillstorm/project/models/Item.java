package com.skillstorm.project.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.skillstorm.project.dtos.ItemDto;

/**
 * Represents a unique item
 * @author lily
 *
 */
@Entity @Table(name = "item")
public class Item {

	/**
	 * Primary key
	 */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long sku;
	
	/**
	 * Name of item
	 */
	@Column
	private String name;
	
	/**
	 * Description of item
	 */
	@Column
	private String description;
	
	/**
	 * Category of item
	 */
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Item() {
		super();
	}

	public Item(long sku, String name, String description, Category category) {
		super();
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.category = category;
	}

	public long getSku() {
		return sku;
	}

	public void setSku(long sku) {
		this.sku = sku;
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

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sku);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return sku == other.sku;
	}
	
	public ItemDto toDto() {
		return new ItemDto(sku, category.getId(), name, description);
	}
	
	
}
