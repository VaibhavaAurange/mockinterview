package com.vaibhav.mockinterview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.mockinterview.entity.Interview;
import com.vaibhav.mockinterview.repository.InterviewRepository;

@Service
public class StudentService {

	@Autowired
	InterviewRepository repo;

	// ✅ 1. Upcoming Interview (Latest Scheduled)
	public Interview getUpcomingInterview(int studentId) {

		return repo.findTopByStudent_IdOrderByInterviewIdDesc(studentId);
	}

	// ✅ 2. Interview History (All Interviews)
	public List<Interview> getAllStudentInterviews(int studentId) {

		return repo.findByStudent_Id(studentId);
	}
}
