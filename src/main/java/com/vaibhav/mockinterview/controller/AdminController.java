package com.vaibhav.mockinterview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.mockinterview.dto.ApprovalDTO;
import com.vaibhav.mockinterview.dto.InterviewDTO;
import com.vaibhav.mockinterview.entity.Interview;
import com.vaibhav.mockinterview.entity.User;
import com.vaibhav.mockinterview.service.AdminService;
import com.vaibhav.mockinterview.service.InterviewService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	InterviewService interviewService;

	@Autowired
	AdminService adminService;

	// Schedule Interview
	@PostMapping("/schedule")
	public Interview schedule(@RequestBody InterviewDTO dto) {
		return interviewService.scheduleInterview(dto);
	}

	// View Pending Users
	@GetMapping("/pending-users")
	public List<User> pendingUsers() {
		return adminService.getPendingUsers();
	}

	// Approve User Role
	@PostMapping("/approve-user")
	public User approveUser(@RequestBody ApprovalDTO dto) {
		return adminService.approveUser(dto);
	}

	// View All Users
	@GetMapping("/all-users")
	public List<User> allUsers() {
		return adminService.getAllUsers();
	}

	@GetMapping("/approved-users")
	public List<User> approvedUsers() {
		return adminService.approvedUsers();
	}

}
