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
import com.projet.blog.payloads.UserDto;
import com.projet.blog.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		System.out.println(userDto);
		UserDto createUser = this.userService.createUser(userDto);
		System.out.println(createUser);
		return  new ResponseEntity<UserDto>(createUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable Integer id)
	{
		UserDto updatUser = this.userService.updatUser(userDto, id);
		return new ResponseEntity<UserDto>(updatUser,HttpStatus.OK);
	}
	
	//Delete User
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id)
	{
		this.userService.deleteUser(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true),HttpStatus.OK);
	
	}
	
	//Multiple User Getting
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		//List<UserDto> allUsers = this.userService.getAllUsers();
		return  ResponseEntity.ok(this.userService.getAllUsers());
				
	}
	
	//Single User Getting
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer id)
	{
		UserDto getUser = this.userService.getUserById(id);
		return new ResponseEntity<UserDto>(getUser,HttpStatus.OK);
				
	}
//	
}
