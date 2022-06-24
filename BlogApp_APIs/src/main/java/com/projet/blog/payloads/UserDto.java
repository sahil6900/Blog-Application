package com.projet.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class UserDto {

	private int id;
	@NotEmpty
	@Size(min = 3,message = "Username must be minumum of  characters")
	private String name;
	@Email(message = "Email is not valid")
	private String email;
	@NotEmpty
	@Size(max = 15 , min = 3,message = "Password must be min 3 & max 10 characters")
	/* @Pattern(regexp = ) */
	private String password;
	@NotEmpty
	private String about;
	
	
}
