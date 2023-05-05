package com.skillstorm.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.project.dtos.WarehouseDto;
import com.skillstorm.project.models.Lot;
import com.skillstorm.project.models.Warehouse;
import com.skillstorm.project.repositories.LotRepository;
import com.skillstorm.project.repositories.WarehouseRepository;

@Service
@Transactional
public class WarehouseService {
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Autowired
	private LotRepository lotRepository;

	/**
	 * Finds a warehouse by its id
	 * @param id The warehouse's id
	 * @return The data of the found warehouse
	 */
	public WarehouseDto findWarehouseById(long id) {
		return warehouseRepository.findById(id)
				.orElseThrow()
				.toDto();
	}
	
	/**
	 * Finds all warehouses
	 * @return List of warehouses
	 */
	public List<WarehouseDto> findAllWarehouses() {
		return warehouseRepository.findAll()
				.stream()
				.map(w -> w.toDto())
				.toList();
	}

	/**
	 * Creates/updates a warehouse
	 * @param warehouseData
	 * @return the new warehouse
	 */
	public WarehouseDto createWarehouse(WarehouseDto warehouseData) {
		Warehouse warehouse = new Warehouse(
				warehouseData.getId(),
				warehouseData.getName(),
				warehouseData.getDescription(),
				warehouseData.getAddress(),
				warehouseData.getMaxCapacity());
		
		return warehouseRepository.save(warehouse).toDto();
	}

	/**
	 * Deletes a warehouse
	 * @param id The warehouse's id
	 */
	public void deleteWarehouse(long id) {
		warehouseRepository.deleteById(id);
		
	}

	/**
	 * Gets the current number of items in a warehouse
	 * @param id The id of the warehouse
	 * @return Number of items in the warehouse
	 */
	public int getCurrentCapacityById(long id) {
		List<Lot> lots = lotRepository.findAllLotsByWarehouseId(id);
		int capacity = 0;
		for (Lot l : lots) {
			capacity += l.getQuantity();
		}

		return capacity;
	}

	

}
