package com.asta.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asta.app.dto.UserDTO;
import com.asta.app.model.User;
import com.asta.app.repository.UserRepository;
import com.asta.app.service.UserService;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class UserControler {

	@Autowired
	UserService userService;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/register")
	 //@ResponseStatus(HttpStatus.CREATED)
	 public ResponseEntity<User> register(@RequestBody UserDTO user)
	{
		//try {
            return ResponseEntity.ok(userService.Save(user));
        /*}catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }*/
	 }

	@GetMapping("/users/profile")
	public ResponseEntity<User> profile(HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();

		if (principal != null) {
			return ResponseEntity.ok(userRepository.findByUserName(principal.getName()).orElseThrow());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
