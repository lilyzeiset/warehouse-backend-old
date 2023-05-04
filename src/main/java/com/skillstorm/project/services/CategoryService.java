package com.skillstorm.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.project.dtos.CategoryDto;
import com.skillstorm.project.models.Category;
import com.skillstorm.project.repositories.CategoryRepository;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	/**
	 * Finds a category by its id
	 * @param id category id
	 * @return The data of the found category
	 */
	public CategoryDto findCategoryById(long id) {
		return categoryRepository.findById(id)
				.orElseThrow()
				.toDto();
	}

	/**
	 * Finds all categories
	 * @return List of categories
	 */
	public List<CategoryDto> findAllCategories() {
		return categoryRepository.findAll()
				.stream()
				.map(w -> w.toDto())
				.toList();
	}

	/**
	 * Creates/updates a category
	 * @param categoryData
	 * @return the new category
	 */
	public CategoryDto createCategory(CategoryDto categoryData) {
		Category category = new Category(
				categoryData.getId(),
				categoryData.getName(),
				categoryData.getDescription());
		
		return categoryRepository.save(category).toDto();
	}

	/**
	 * 
	 * @param id
	 */
	public void deleteCategory(long id) {
		categoryRepository.deleteById(id);
	}

}
