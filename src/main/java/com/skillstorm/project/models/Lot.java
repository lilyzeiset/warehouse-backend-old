package com.skillstorm.project.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Represents a quantity of a single item to be stored in a warehouse.
 * i.e. a pallet of items.
 * @author lily
 *
 */
@Entity @Table(name = "lot")
public class Lot {
	
	/**
	 * Primary key
	 */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lot_id")
	private long id;
	
	/**
	 * Number of items in lot.
	 */
	@Column
	private int quantity;

	/**
	 * Location within warehouse.
	 * i.e. department/aisle number
	 */
	@Column
	private String location;
	
	/**
	 * Warehouse that contains this lot
	 */
	@ManyToOne
	@JoinColumn(name = "warehouse_id")
	private Warehouse warehouse;
	
	/**
	 * Item contained in this lot
	 */
	@OneToOne //IM NOT CERTAIN THIS IS RIGHT BUT I THINK IT IS
	@JoinColumn(name = "sku")
	private Item item;
	

	public Lot() {
		super();
	}

	public Lot(long id, int quantity, Warehouse warehouse, String location) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.warehouse = warehouse;
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
		Lot other = (Lot) obj;
		return id == other.id;
	}
	

	

}
