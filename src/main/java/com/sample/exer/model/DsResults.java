package com.sample.exer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DsResults {

	private String category;
	private String type;
	private String difficulty;
	private String question;
	@JsonProperty("correct_answer")
	private String correctAnswer;
	@JsonProperty("incorrect_answers")
	private String[] incorrectAnswers;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String[] getIncorrectAnswers() {
		return incorrectAnswers;
	}
	public void setIncorrectAnswers(String[] incorrectAnswers) {
		this.incorrectAnswers = incorrectAnswers;
	}
	
	
}
