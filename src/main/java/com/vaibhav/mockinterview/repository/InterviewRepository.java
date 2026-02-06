package com.vaibhav.mockinterview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.mockinterview.entity.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Integer> {

	// ✅ Find interviews for student
	List<Interview> findByStudent_Id(int studentId);

	// ✅ Find interviews for trainer
	List<Interview> findByTrainer_Id(int trainerId);

	// ✅ Upcoming interview for student
	Interview findTopByStudent_IdOrderByInterviewIdDesc(int studentId);
}
