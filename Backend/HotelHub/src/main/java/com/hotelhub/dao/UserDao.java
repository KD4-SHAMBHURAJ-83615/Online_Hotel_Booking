package com.hotelhub.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelhub.entity.User;

public interface UserDao extends JpaRepository<User,Long>{
//add derived finder method for user signin 
	Optional<User> findByEmailAndPassword(String email,String pass);
	Optional<User> findByEmail(String email);
	Optional<User> findById(Long id);
}
