package com.vaibhav.mockinterview.dto;

public class FeedbackDTO {

	public int interviewId;
	public int studentId;
	public int trainerId;

	public int technicalSkills;
	public int communicationSkills;
	public int problemSolvingSkills;

	public String feedbackText;

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
