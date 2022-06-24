package com.projet.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
