package com.sample.exer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sample.exer.model.ApiResponse;
import com.sample.exer.model.DsResponse;
import com.sample.exer.model.DsResults;
import com.sample.exer.model.Quiz;
import com.sample.exer.model.Results;

@Repository
public class ApiResultsDao {

	@Autowired
	private RestTemplate restTemplate;

	public ApiResponse fetchApiDetail() {
		ApiResponse apiResp = new ApiResponse();
		Quiz[] quizRs = new Quiz[2];
		quizRs[0] = getDataSource(11);
		quizRs[1] = getDataSource(12);
		apiResp.setQuiz(quizRs);
		return apiResp;
		}

	private Quiz getDataSource(int category) {
		Quiz quiz = new Quiz();
		ResponseEntity<DsResponse> dsRespEntity = restTemplate.getForEntity("https://opentdb.com/api.php?amount=5&category=" + category, DsResponse.class);
		if(dsRespEntity != null) {			
			DsResponse dsResponse = dsRespEntity.getBody();

			if(dsResponse != null && dsResponse.getResults().length > 0) {
				quiz.setCategory(dsResponse.getResults()[0].getCategory());
				Results[] results = new Results[dsResponse.getResults().length];
				int i = 0;
				for(DsResults dsResult: dsResponse.getResults()) {					
					Results result = new Results();
					result.setCorrectAnswer(dsResult.getCorrectAnswer());
					result.setAllAnswers(dsResult.getIncorrectAnswers());
					result.setDifficulty(dsResult.getDifficulty());
					result.setQuestion(dsResult.getQuestion());
					result.setType(dsResult.getType());
					results[i] = result;
					i++;
				}
				quiz.setResults(results);
			}
		}
		return quiz;
	}
}
