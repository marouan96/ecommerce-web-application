package com.asta.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.asta.app.Repository.CartRepository;
import com.asta.app.Repository.UserRepository;
import com.asta.app.dto.UserDTO;
import com.asta.app.model.Cart;
import com.asta.app.model.User;


@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Optional<User> FindById(long id){
		return repository.findById(id);
	}
	
	public boolean Exist(long id) {
		return repository.existsById(id);
	}
	
	public User Save(UserDTO userDTO) {
		User user = new User();
		user.setUsername(userDTO.getUserName());
		user.setEmail(userDTO.getEmail());
		String password=passwordEncoder.encode(userDTO.getPassword());
		user.setPassword(password);
		user.setAddress(userDTO.getAddress());
		user.setMobilePhoneNumber(userDTO.getPhone());
		user.setRoles("Customer");
		Cart cart=cartRepository.save(new Cart(user));
		user.setCart(cart);
		return repository.save(user);
		
	}
	
	public void DeleteById(long id) {
		repository.deleteById(id);
	}
	
	
}
