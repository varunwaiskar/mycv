package com.varun.mycv.controller;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.varun.mycv.entity.CsvEntity;
import com.varun.mycv.entity.UpdateUserReferralRequest;

@RestController
public class HomeController {

	//Url
	private String url = "https://www.mycvtracker.com:8080/links/referrals";
	
	//Authorization token
	private String token = "Bearer ";


	@GetMapping("/")
	public UpdateUserReferralRequest book() throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		List<CsvEntity> list= new ReadFile()
							.readCsvFile();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", token);

		HttpEntity<CsvEntity> entity = new HttpEntity<>(list.get(0) , headers);

		UpdateUserReferralRequest response = restTemplate.postForObject(
										 		url,  
										 		entity,
										 		UpdateUserReferralRequest.class);

		return response;

	}
	
	@GetMapping("/excel")
	public List<CsvEntity> csvRead()throws Exception {
		ReadFile read =  new ReadFile();
		return read.readExcelFile("");
	}
	
}
