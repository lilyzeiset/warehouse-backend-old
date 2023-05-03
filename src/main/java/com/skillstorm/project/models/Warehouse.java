package com.skillstorm.project.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a single warehouse.
 * @author lily
 *
 */
@Entity @Table(name = "warehouse")
public class Warehouse {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "warehouse_id")
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String desc;
	
	@Column
	private String address;
	
	@Column(name = "max_capacity")
	private double maxCapacity;

	public Warehouse() {
		super();
	}

	public Warehouse(long id, String name, String address, double maxCapacity) {
		super();
		this.id = id;
		this.name = name;
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
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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
		Warehouse other = (Warehouse) obj;
		return id == other.id;
	}
	
	

}
