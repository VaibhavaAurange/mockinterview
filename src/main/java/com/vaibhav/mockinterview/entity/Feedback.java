package com.vaibhav.mockinterview.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int interviewId;
	private int studentId;
	private int trainerId;

	// ✅ Ratings
	private int technicalSkills;
	private int communicationSkills;
	private int problemSolvingSkills;

	// ✅ Written Feedback
	private String feedbackText;

	// Getters & Setters

	public int getId() {
		return id;
	}

	public int getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public int getTechnicalSkills() {
		return technicalSkills;
	}

	public void setTechnicalSkills(int technicalSkills) {
		this.technicalSkills = technicalSkills;
	}

	public int getCommunicationSkills() {
		return communicationSkills;
	}

	public void setCommunicationSkills(int communicationSkills) {
		this.communicationSkills = communicationSkills;
	}

	public int getProblemSolvingSkills() {
		return problemSolvingSkills;
	}

	public void setProblemSolvingSkills(int problemSolvingSkills) {
		this.problemSolvingSkills = problemSolvingSkills;
	}

	public String getFeedbackText() {
		return feedbackText;
	}

	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}
}
