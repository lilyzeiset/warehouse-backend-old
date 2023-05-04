package com.skillstorm.project.controllers;

import java.util.List;

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

import com.skillstorm.project.dtos.ItemDto;
import com.skillstorm.project.services.ItemService;

@RestController
@RequestMapping("/items")
@CrossOrigin
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/{sku}")
	public ItemDto findItemById(@PathVariable long sku) {
		return itemService.findItemById(sku);
	}
	
	@GetMapping
	public List<ItemDto> findAllItems() {
		return itemService.findAllItems();
	}
	
	@GetMapping("/c/{category_id}")
	public List<ItemDto> findAllItemsByCategoryId(@PathVariable long category_id) {
		return itemService.findAllItemsByCategoryId(category_id);
	}
	
	@PostMapping
	public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemData) {
		ItemDto item = itemService.createItem(itemData);
		return new ResponseEntity<>(item, HttpStatus.CREATED);
	}
	
	@PutMapping("/{sku}")
	public ItemDto updateItem(@PathVariable long sku, @RequestBody ItemDto itemData) {
		itemData.setSku(sku);
		return itemService.createItem(itemData);
	}
	
	@DeleteMapping("/{sku}")
	public void deleteItem(@PathVariable long sku) {
		itemService.deleteItem(sku);
	}
}
