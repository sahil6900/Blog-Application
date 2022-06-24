package com.projet.blog.service;

import java.util.List;
import com.projet.blog.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);
	
	UserDto updatUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers(); 
	
	void deleteUser(Integer userId);		
}
