package com.asta.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asta.app.dto.UserDTO;
import com.asta.app.model.Cart;
import com.asta.app.model.User;
import com.asta.app.repository.CartRepository;
import com.asta.app.repository.UserRepository;


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
	
    @Transactional
	public User Save(UserDTO userDTO) {
		User user = new User();
		user.setUsername(userDTO.getUserName());
		user.setEmail(userDTO.getEmail());
		String password=passwordEncoder.encode(userDTO.getPassword());
		user.setPassword(password);
		user.setAddress(userDTO.getAddress());
		user.setMobilePhoneNumber(userDTO.getPhone());
		List<String> roles = new ArrayList<>();
		roles.add("CUSTOMER");
		user.setRoles(roles);
		Cart cart=cartRepository.save(new Cart(user));
		user.setCart(cart);
		repository.save(user);
		return user;
		
	}
	
	public void DeleteById(long id) {
		repository.deleteById(id);
	}
	
	
}
