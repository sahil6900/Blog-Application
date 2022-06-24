package com.projet.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.blog.entities.Category;

public interface CategoryRepo  extends JpaRepository<Category, Integer> {

	
	
}
