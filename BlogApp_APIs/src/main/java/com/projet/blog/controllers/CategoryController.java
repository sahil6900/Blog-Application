package com.projet.blog.controllers;


import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.blog.payloads.ApiResponse;
import com.projet.blog.payloads.CategoryDto;
import com.projet.blog.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	
	// CREATE HANDLER
	
	@PostMapping("/create")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto)
	{CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
		System.out.println(createCategory);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	}
	
	
	// UPDATE HANDLER

	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer id)
	{CategoryDto updateCategoryDto = this.categoryService.updatCategory(categoryDto,id);
		return new ResponseEntity<CategoryDto>(updateCategoryDto,HttpStatus.OK);
	}
	
	
	// DELETE HANDLER


	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer id)
	{
		this.categoryService.deleteCategory(id);
		return new ResponseEntity<ApiResponse>( new ApiResponse("Category is deleted successfully",false) ,HttpStatus.OK);
	}
	
	
	// GET HANDLER

	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer id)
	{
		CategoryDto category = this.categoryService.getCategory(id);
		return new ResponseEntity<CategoryDto>(category,HttpStatus.OK);
	}
	
	
	// GETALL HANDLER
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory()
	{
		List<CategoryDto> categories = this.categoryService.getAllCategories();
		return  ResponseEntity.ok(categories);
	}
	
	
}
