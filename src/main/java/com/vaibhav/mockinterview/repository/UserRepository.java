package com.vaibhav.mockinterview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.mockinterview.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);

	List<User> findByApprovedFalse();

	List<User> findByApprovedTrue();

}