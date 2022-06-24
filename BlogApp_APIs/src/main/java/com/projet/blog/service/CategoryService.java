package com.projet.blog.service;

import java.util.List;

import com.projet.blog.payloads.CategoryDto;


public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);

	CategoryDto updatCategory(CategoryDto categoryDto, Integer categoryId);

	CategoryDto getCategory(Integer categoryId);

	List<CategoryDto> getAllCategories();

	void deleteCategory(Integer categoryId);
}
