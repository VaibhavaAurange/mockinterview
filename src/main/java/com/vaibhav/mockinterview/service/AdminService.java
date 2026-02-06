package com.vaibhav.mockinterview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.mockinterview.dto.ApprovalDTO;
import com.vaibhav.mockinterview.entity.User;
import com.vaibhav.mockinterview.repository.UserRepository;

@Service
public class AdminService {

	@Autowired
	UserRepository repo;

	// View Pending Users
	public List<User> getPendingUsers() {
		return repo.findByApprovedFalse();
	}

	// Approve User
	public User approveUser(ApprovalDTO dto) {

		User user = repo.findById(dto.getUserId()).get();

		user.setRole(dto.getRole());
		user.setApproved(true);

		return repo.save(user);
	}

	public List<User> getAllUsers() {
		return repo.findAll();
	}

	public List<User> approvedUsers() {
		return repo.findByApprovedTrue();
	}

}
