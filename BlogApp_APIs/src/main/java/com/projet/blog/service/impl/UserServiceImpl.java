package com.projet.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.blog.entities.User;
import com.projet.blog.exceptions.ResourceNotFoundEception;
import com.projet.blog.payloads.UserDto;
import com.projet.blog.repositories.UserRepo;
import com.projet.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	// Creating User
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user2 = this.convertUserDtoToUser(userDto);
		User savedUser = this.userRepo.save(user2);

		return this.convertToUserToUserDto(savedUser);
	}

	// Updating User
	@Override
	public UserDto updatUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundEception("User", "id", userId));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		User updatedUser = this.userRepo.save(user);

		return this.convertToUserToUserDto(updatedUser);

	}

	// Getting Single User By Id
	@Override
	public UserDto getUserById(Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundEception("User", "id", userId));

		return this.convertToUserToUserDto(user);
	}

	// Getting All Users
	@Override
	public List<UserDto> getAllUsers() {

		List<User> users = this.userRepo.findAll();
		List<UserDto> listUserDtos = new ArrayList<UserDto>();
		for (User user : users) {

			UserDto userDto = this.convertToUserToUserDto(user);
			listUserDtos.add(userDto);
		}
		return listUserDtos;
	}

	// Deleting User
	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundEception("User", "id", userId));
		this.userRepo.delete(user);

	}

	// METHOD CONVERTING UserDto into User Obj
	public User convertUserDtoToUser(UserDto userDto) {
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
			//OR 
		User user = this.modelMapper.map(userDto, User.class);
		return user;

	}

	// METHOD CONVERTING User into UserDto Obj
	public UserDto convertToUserToUserDto(User user) {
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getEmail());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		
		//OR
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}
}
