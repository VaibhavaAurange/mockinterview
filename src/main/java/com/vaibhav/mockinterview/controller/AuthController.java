package com.vaibhav.mockinterview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.mockinterview.dto.LoginDTO;
import com.vaibhav.mockinterview.dto.RegisterDTO;
import com.vaibhav.mockinterview.entity.User;
import com.vaibhav.mockinterview.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthService service;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO dto) {

		User user = service.login(dto);

		if (user == null) {
			return ResponseEntity.status(401).body("Invalid Credentials or Not Approved");
		}

		return ResponseEntity.ok(user);
	}

	@PostMapping("/register")
	public User register(@RequestBody RegisterDTO dto) {
		return service.register(dto);
	}

}
