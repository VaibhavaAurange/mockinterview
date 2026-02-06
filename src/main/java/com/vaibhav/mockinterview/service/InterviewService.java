package com.vaibhav.mockinterview.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.mockinterview.dto.InterviewDTO;
import com.vaibhav.mockinterview.dto.StatusUpdateDTO;
import com.vaibhav.mockinterview.entity.Interview;
import com.vaibhav.mockinterview.entity.User;
import com.vaibhav.mockinterview.repository.InterviewRepository;
import com.vaibhav.mockinterview.repository.UserRepository;

@Service
public class InterviewService {

	@Autowired
	InterviewRepository interviewRepo;

	@Autowired
	UserRepository userRepo;

	// ✅ 1. Admin Schedule Interview
	public Interview scheduleInterview(InterviewDTO dto) {

		Interview i = new Interview();

		i.setInterviewDate(LocalDate.parse(dto.getDate()));
		i.setInterviewTime(LocalTime.parse(dto.getTime()));

		User student = userRepo.findById(dto.getStudentId()).get();
		User trainer = userRepo.findById(dto.getTrainerId()).get();

		i.setStudent(student);
		i.setTrainer(trainer);

		// ✅ Default Status
		i.setStatus("SCHEDULED");

		return interviewRepo.save(i);
	}

	// ✅ 2. Trainer Update Interview Status
	public Interview updateStatus(StatusUpdateDTO dto) {

		Interview interview = interviewRepo.findById(dto.getInterviewId()).get();

		interview.setStatus(dto.getStatus());

		return interviewRepo.save(interview);
	}

	// ✅ 3. Student Dashboard → All Interviews
	public List<Interview> getStudentInterviews(int studentId) {

		return interviewRepo.findByStudent_Id(studentId);
	}

	// ✅ 4. Trainer Dashboard → All Assigned Interviews
	public List<Interview> getTrainerInterviews(int trainerId) {

		return interviewRepo.findByTrainer_Id(trainerId);
	}

	// ✅ 5. Student Dashboard → Upcoming Interview
	public Interview getUpcomingInterview(int studentId) {

		return interviewRepo.findTopByStudent_IdOrderByInterviewIdDesc(studentId);
	}
}
