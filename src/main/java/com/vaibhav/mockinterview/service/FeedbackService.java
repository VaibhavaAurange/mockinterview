package com.vaibhav.mockinterview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.mockinterview.dto.FeedbackDTO;
import com.vaibhav.mockinterview.entity.Feedback;
import com.vaibhav.mockinterview.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	FeedbackRepository repo;

	// ✅ Trainer Adds Feedback
	public Feedback addFeedback(FeedbackDTO dto) {

		Feedback fb = new Feedback();

		fb.setInterviewId(dto.interviewId);
		fb.setStudentId(dto.studentId);
		fb.setTrainerId(dto.trainerId);

		fb.setTechnicalSkills(dto.technicalSkills);
		fb.setCommunicationSkills(dto.communicationSkills);
		fb.setProblemSolvingSkills(dto.problemSolvingSkills);

		fb.setFeedbackText(dto.feedbackText);

		return repo.save(fb);
	}

	public List<Feedback> getStudentFeedback(int studentId) {
		return repo.findByStudentId(studentId);
	}
}
