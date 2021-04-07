package com.sample.exer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DsResponse {

	@JsonProperty("response_code")
	private int responseCode;
	@JsonProperty("results")
	private DsResults[] results;
	
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public DsResults[] getResults() {
		return results;
	}
	public void setResults(DsResults[] results) {
		this.results = results;
	}

	
}

