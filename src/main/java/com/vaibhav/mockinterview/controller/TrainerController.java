package com.vaibhav.mockinterview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.mockinterview.dto.FeedbackDTO;
import com.vaibhav.mockinterview.dto.StatusUpdateDTO;
import com.vaibhav.mockinterview.entity.Feedback;
import com.vaibhav.mockinterview.entity.Interview;
import com.vaibhav.mockinterview.service.FeedbackService;
import com.vaibhav.mockinterview.service.InterviewService;
import com.vaibhav.mockinterview.service.TrainerService;

@RestController
@RequestMapping("/trainer")
@CrossOrigin(origins = "http://localhost:4200")
public class TrainerController {

	@Autowired
	FeedbackService feedbackService;

	@Autowired
	TrainerService trainerService;

	@Autowired
	InterviewService interviewService;

	// ✅ 1. Trainer Gives Feedback
	@PostMapping("/feedback")
	public Feedback addFeedback(@RequestBody FeedbackDTO dto) {
		return feedbackService.addFeedback(dto);
	}

	// ✅ 2. Trainer Dashboard → View Assigned Interviews
	@GetMapping("/interviews/{trainerId}")
	public List<Interview> trainerInterviews(@PathVariable int trainerId) {
		return trainerService.getTrainerInterviews(trainerId);
	}

	@PostMapping("/update-status")
	public Interview updateStatus(@RequestBody StatusUpdateDTO dto) {
		return interviewService.updateStatus(dto);
	}

}
