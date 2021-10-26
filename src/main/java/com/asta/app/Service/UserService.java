package com.asta.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.asta.app.model.User;
import com.asta.app.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public Optional<User> FindById(long id){
		return repository.findById(id);
	}
	
	public boolean Exist(long id) {
		return repository.existsById(id);
	}
	
	public void Save(User user) {
		repository.save(user);
	}
	
	public void DeleteById(long id) {
		repository.deleteById(id);
	}
	
	
}
