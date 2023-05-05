package com.skillstorm.project.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project.dtos.LotDto;
import com.skillstorm.project.services.LotService;

@RestController
@RequestMapping("/lot")
@CrossOrigin
public class LotController {

	@Autowired
	private LotService lotService;
	
	@GetMapping("/{sku}")
	public LotDto findLotById(@PathVariable long id) {
		return lotService.findLotById(id);
	}
	
	@GetMapping("/w/{warehouse_id}")
	public List<LotDto> findAllLotsByWarehouseId(@PathVariable long warehouse_id) {
		return lotService.findAllLotsByWarehouseId(warehouse_id);
	}
	
	@PostMapping
	public ResponseEntity<LotDto> createLot(@Valid @RequestBody LotDto lotData) {
		LotDto lot = lotService.createLot(lotData);
		return new ResponseEntity<>(lot, HttpStatus.CREATED);
	}
	
	@PutMapping("/{sku}")
	public LotDto updateLot(@PathVariable long id, @Valid @RequestBody LotDto lotData) {
		lotData.setId(id);
		return lotService.createLot(lotData);
	}
	
	@DeleteMapping("/{sku}")
	public void deleteLot(@PathVariable long id) {
		lotService.deleteLot(id);
	}
}
