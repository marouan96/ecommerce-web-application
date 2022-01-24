package com.asta.app.service;

import com.asta.app.model.User;
import com.asta.app.repository.UserRepository;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DataBaseInitializer {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init() throws IOException, URISyntaxException {
		userRepository.save(new User("marouan","marouan@gamil.com","6523147856","street 24",passwordEncoder.encode("pass"),"CUSTOMER"));
	}
}
