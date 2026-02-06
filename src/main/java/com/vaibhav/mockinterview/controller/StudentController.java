package com.vaibhav.mockinterview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.mockinterview.entity.Feedback;
import com.vaibhav.mockinterview.entity.Interview;
import com.vaibhav.mockinterview.service.FeedbackService;
import com.vaibhav.mockinterview.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	StudentService service;

	@Autowired
	FeedbackService feedbackService;

	// ✅ Get Upcoming Interview for Student
	@GetMapping("/upcoming/{studentId}")
	public Interview upcomingInterview(@PathVariable int studentId) {
		return service.getUpcomingInterview(studentId);
	}

	@GetMapping("/feedback/{studentId}")
	public List<Feedback> studentFeedback(@PathVariable int studentId) {
		return feedbackService.getStudentFeedback(studentId);
	}

	@GetMapping("/history/{studentId}")
	public List<Interview> history(@PathVariable int studentId) {
		return service.getAllStudentInterviews(studentId);
	}

}
