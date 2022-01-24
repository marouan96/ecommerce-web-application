package com.asta.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asta.app.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUserName(String userName);

}
