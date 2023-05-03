package com.skillstorm.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skillstorm.project.dtos.LotDto;
import com.skillstorm.project.models.Item;
import com.skillstorm.project.models.Lot;
import com.skillstorm.project.models.Warehouse;
import com.skillstorm.project.repositories.ItemRepository;
import com.skillstorm.project.repositories.LotRepository;
import com.skillstorm.project.repositories.WarehouseRepository;

public class LotService {

	@Autowired
	private LotRepository lotRepository;
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Autowired
	private ItemRepository itemRepository;

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
	 * Creates/updates a lot
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
		
		return lotRepository.save(lot).toDto();
	}

	/**
	 * Deletes a lot
	 * @param id lot id
	 */
	public void deleteLot(long id) {
		lotRepository.deleteById(id);
	}
}
