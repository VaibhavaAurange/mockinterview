package com.vaibhav.mockinterview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.mockinterview.dto.LoginDTO;
import com.vaibhav.mockinterview.dto.RegisterDTO;
import com.vaibhav.mockinterview.entity.User;
import com.vaibhav.mockinterview.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	UserRepository repo;

	// ✅ REGISTER USER (Always Pending)
	public User register(RegisterDTO dto) {

		User user = new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());

		// Default role pending
		user.setRole("PENDING");

		// Not approved yet
		user.setApproved(false);

		return repo.save(user);
	}

	// ✅ LOGIN ONLY IF APPROVED
	public User login(LoginDTO dto) {

		User user = repo.findByEmail(dto.getEmail());

		if (user != null && user.getPassword().equals(dto.getPassword()) && user.isApproved()) {

			return user;
		}

		return null;
	}
}
