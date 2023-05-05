package com.skillstorm.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.project.dtos.LotDto;
import com.skillstorm.project.exceptions.ExceedMaxCapacityException;
import com.skillstorm.project.models.Item;
import com.skillstorm.project.models.Lot;
import com.skillstorm.project.models.Warehouse;
import com.skillstorm.project.repositories.ItemRepository;
import com.skillstorm.project.repositories.LotRepository;
import com.skillstorm.project.repositories.WarehouseRepository;

@Service
@Transactional
public class LotService {

	@Autowired
	private LotRepository lotRepository;
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private WarehouseService warehouseService;

	/**
	 * Finds a lot by its id
	 * @param id lot id
	 * @return the found lot
	 */
	public LotDto findLotById(long id) {
		return lotRepository.findById(id)
				.orElseThrow()
				.toDto();
	}

	/**
	 * Finds all lots in a given warehouse
	 * @param warehouse_id id of the given warehouse
	 * @return List of lots
	 */
	public List<LotDto> findAllLotsByWarehouseId(long warehouse_id) {
		return lotRepository.findAllLotsByWarehouseId(warehouse_id)
				.stream()
				.map(i -> i.toDto())
				.toList();
	}

	/**
	 * Creates a lot
	 * Checks warehouse capacity and throws an ExceedMaxCapacityException if necessary
	 * @param lotData
	 * @return the new lot
	 */
	public LotDto createLot(LotDto lotData) {
		Warehouse warehouse = warehouseRepository.findById(lotData.getWarehouseId())
				.orElseThrow();
		
		Item item = itemRepository.findById(lotData.getItemId())
				.orElseThrow();
		
		Lot lot = new Lot(
				lotData.getId(),
				lotData.getQuantity(),
				lotData.getLocation(),
				warehouse,
				item);

		int currentCapacity = warehouseService.getCurrentCapacityById(warehouse.getId());
		int maxCapacity = warehouse.getMaxCapacity();
		int quantity = lot.getQuantity();
		if (currentCapacity + quantity > maxCapacity) {
			throw new ExceedMaxCapacityException();
		} else {
			return lotRepository.save(lot).toDto();
		}
	}
	
	/**
	 * Updates a lot
	 * Checks warehouse capacity and throws an ExceedMaxCapacityException if necessary
	 * @param lotData
	 * @return the new lot
	 */
	public LotDto updateLot(LotDto lotData) {
		Warehouse warehouse = warehouseRepository.findById(lotData.getWarehouseId())
				.orElseThrow();
		
		Item item = itemRepository.findById(lotData.getItemId())
				.orElseThrow();
		
		Lot lot = new Lot(
				lotData.getId(),
				lotData.getQuantity(),
				lotData.getLocation(),
				warehouse,
				item);

		int oldQuantity = lotRepository.findById(lot.getId()).orElseThrow().getQuantity();
		int currentCapacity = warehouseService.getCurrentCapacityById(warehouse.getId()) - oldQuantity;
		int maxCapacity = warehouse.getMaxCapacity();
		int quantity = lot.getQuantity();
		if (currentCapacity + quantity > maxCapacity) {
			throw new ExceedMaxCapacityException();
		} else {
			return lotRepository.save(lot).toDto();
		}
	}

	/**
	 * Deletes a lot
	 * @param id lot id
	 */
	public void deleteLot(long id) {
		lotRepository.deleteById(id);
	}
}
