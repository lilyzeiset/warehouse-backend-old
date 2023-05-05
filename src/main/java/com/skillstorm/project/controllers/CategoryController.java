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

import com.skillstorm.project.dtos.CategoryDto;
import com.skillstorm.project.services.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/{id}")
	public CategoryDto findCategoryById(@PathVariable long id) {
		return categoryService.findCategoryById(id);
	}
	
	@GetMapping
	public List<CategoryDto> findAllItems() {
		return categoryService.findAllCategories();
	}
	
	@PostMapping
	public ResponseEntity<CategoryDto> createItem(@Valid @RequestBody CategoryDto categoryData) {
		CategoryDto item = categoryService.createCategory(categoryData);
		return new ResponseEntity<>(item, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public CategoryDto updateItem(@PathVariable long id, @Valid @RequestBody CategoryDto categoryData) {
		categoryData.setId(id);
		return categoryService.createCategory(categoryData);
	}
	
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable long id) {
		categoryService.deleteCategory(id);
	}
}
