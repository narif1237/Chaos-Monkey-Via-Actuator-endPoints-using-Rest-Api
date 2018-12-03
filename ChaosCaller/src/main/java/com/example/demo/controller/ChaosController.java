package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ChaosController {

	@GetMapping("/chaosStart")
	public String startChaos() {
		RestTemplate restTemplate = new RestTemplate();
		JSONObject body = new JSONObject();
		body.put("exceptionsActive", false);
		ResponseEntity<String> enableResult = restTemplate.exchange("http://localhost:8080/actuator/chaosmonkey/enable",
				HttpMethod.POST, null, String.class);
		return enableResult.getBody();
	}

	@GetMapping("/chaosExceptionAssault")
	public String startExceptionChaos() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String body = "{\r\n" + "\"level\": 5,\r\n" + "\"latencyRangeStart\": 2000,\r\n"
				+ "\"latencyRangeEnd\": 5000,\r\n" + "\"latencyActive\": false,\r\n" + "\"exceptionsActive\": true,\r\n"
				+ "\"killApplicationActive\": false,\r\n" + "\"restartApplicationActive\": false\r\n" + "}";

		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> request = new HttpEntity<>(body, headers);
		ResponseEntity<String> enableResult = restTemplate.exchange(
				"http://localhost:8080/actuator/chaosmonkey/assaults", HttpMethod.POST, request, String.class);
		return enableResult.getBody();
	}
	

}
