package com.projet.blog.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;
	@NotBlank
	@Size(min = 4,message = "Min size should 4")
	private String categoryTitle;
	@NotBlank
	@Size(min = 10,message = "Min size should 10")
	private String categoryDescription;
	public CategoryDto(Integer categoryId, @NotBlank @Size(min = 4, message = "Min size should 4") String categoryTitle,
			@NotBlank @Size(min = 10, message = "Min size should 10") String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}
	
	
	
}
