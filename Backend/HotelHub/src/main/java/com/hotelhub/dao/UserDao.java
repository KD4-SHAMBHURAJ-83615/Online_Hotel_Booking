package com.hotelhub.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelhub.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

}
