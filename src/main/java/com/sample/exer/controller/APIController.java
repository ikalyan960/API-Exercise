package com.sample.exer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.exer.model.ApiResponse;
import com.sample.exer.service.AnswersService;

@RestController
@RequestMapping("/v1")
public class APIController {

	@Autowired
	public AnswersService answersService;
	
	@RequestMapping("/coding/exercise/quiz")
	public ResponseEntity<ApiResponse> getAnswers() {
		
		ApiResponse apiResponse = answersService.getAnsers();		
		if(apiResponse != null) {
			return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
		}
		return new ResponseEntity<ApiResponse>(HttpStatus.NOT_FOUND);
		
	}
}
