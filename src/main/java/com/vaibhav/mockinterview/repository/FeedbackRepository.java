package com.vaibhav.mockinterview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.mockinterview.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

	List<Feedback> findByStudentId(int studentId);

}
