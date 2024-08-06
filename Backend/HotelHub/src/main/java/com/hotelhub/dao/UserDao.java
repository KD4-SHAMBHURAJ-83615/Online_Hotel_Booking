package com.hotelhub.dao;

<<<<<<< HEAD
=======
import java.util.Optional;

>>>>>>> main
import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelhub.entity.User;

<<<<<<< HEAD
public interface UserDao extends JpaRepository<User, Long> {

=======
public interface UserDao extends JpaRepository<User,Long>{
//add derived finder method for user signin 
	Optional<User> findByEmailAndPassword(String email,String pass);
	Optional<User> findByEmail(String email);
>>>>>>> main
}
