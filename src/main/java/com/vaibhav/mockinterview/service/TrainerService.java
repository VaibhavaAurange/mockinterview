package com.vaibhav.mockinterview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.mockinterview.entity.Interview;
import com.vaibhav.mockinterview.repository.InterviewRepository;

@Service
public class TrainerService {

	@Autowired
	InterviewRepository repo;

	// ✅ Trainer Interview List
	public List<Interview> getTrainerInterviews(int trainerId) {

		return repo.findByTrainer_Id(trainerId);
	}
}
