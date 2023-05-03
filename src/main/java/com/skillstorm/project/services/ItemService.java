package com.skillstorm.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skillstorm.project.dtos.ItemDto;
import com.skillstorm.project.models.Category;
import com.skillstorm.project.models.Item;
import com.skillstorm.project.repositories.CategoryRepository;
import com.skillstorm.project.repositories.ItemRepository;

public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	/**
	 * Finds an item by its id
	 * @param id item id
	 * @return the found item
	 */
	public ItemDto findItemById(long id) {
		return itemRepository.findById(id)
				.orElseThrow()
				.toDto();
	}
	
	/**
	 * Finds all items
	 * @return list of items
	 */
	public List<ItemDto> findAllItems() {
		return itemRepository.findAll()
				.stream()
				.map(i -> i.toDto())
				.toList();
	}
	
	/**
	 * Finds all items within a category
	 * @param id category id
	 * @return list of items
	 */
	public List<ItemDto> findAllItemsByCategoryId(long id) {
		return itemRepository.findAllItemsByCategoryId(id)
				.stream()
				.map(i -> i.toDto())
				.toList();
	}
	
	/**
	 * Creates/updates an item
	 * @param itemData
	 * @return the new item
	 */
	public ItemDto createItem(ItemDto itemData) {
		Category category = categoryRepository.findById(itemData.getCategoryId())
				.orElseThrow();
		
		Item item = new Item(
				itemData.getSku(),
				itemData.getName(),
				itemData.getDesc(),
				category);
		
		return itemRepository.save(item).toDto();
	}
	
	/**
	 * Deletes an item
	 * @param id item id
	 */
	public void deleteItem(long id) {
		itemRepository.deleteById(id);
		
	}
}
