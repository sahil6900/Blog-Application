package com.projet.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.blog.entities.Category;
import com.projet.blog.exceptions.ResourceNotFoundEception;
import com.projet.blog.payloads.CategoryDto;
import com.projet.blog.repositories.CategoryRepo;
import com.projet.blog.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
			Category category = this.modelMapper.map(categoryDto, Category.class); //This converts CategoryDto into Category
			Category addedCategory = this.categoryRepo.save(category);
			return this.modelMapper.map(addedCategory, CategoryDto.class);   // Here we converted Category into CategoryDto
	}

	@Override
	public CategoryDto updatCategory(CategoryDto categoryDto, Integer categoryId) {
			Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundEception("Category", "id", categoryId));
			
			category.setCategoryTitle(categoryDto.getCategoryTitle());
			category.setCategoryDescription(categoryDto.getCategoryDescription());
			Category updatedCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category getedCategory = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundEception("Category", "Id", categoryId));
		
		return this.modelMapper.map(getedCategory, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> Categories = this.categoryRepo.findAll();
		List<CategoryDto> CategoriesDto = Categories.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return CategoriesDto;
	}

	@Override
	public void deleteCategory(Integer categoryId) {

		Category getedCategory = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundEception("Category", "Id", categoryId));
		this.categoryRepo.delete(getedCategory);
		
	}

}
