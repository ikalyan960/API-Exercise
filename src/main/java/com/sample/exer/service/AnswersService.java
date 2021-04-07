package com.sample.exer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.exer.dao.ApiResultsDao;
import com.sample.exer.model.ApiResponse;

@Service
public class AnswersService {

	@Autowired
	private ApiResultsDao apiResultsDao;

	public ApiResponse getAnsers() {
		
		return apiResultsDao.fetchApiDetail();
	}
}
