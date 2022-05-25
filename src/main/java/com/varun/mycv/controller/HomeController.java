package com.varun.mycv.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.varun.mycv.csv.JobPortal;
import com.varun.mycv.csv.ReadFile;
import com.varun.mycv.entity.CsvEntity;
import com.varun.mycv.entity.UpdateUserReferralRequest;
import com.varun.mycv.entity.UserReferral;

@RestController
public class HomeController {

	//Url
	private String url = "https://www.mycvtracker.com:8080/links/referrals";
	
	//Authorization token
	private String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2YXJ1bi53YWlza2FyMTkwOUBnbWFpbC5jb20iLCJhdWQiOiJ3ZWIiLCJleHAiOjE2NTA4NzM5NDksImlhdCI6MTY1MDI2OTE0OX0.B1f4MfW1eZkIgmwtztXqhQO_ftsKb2Mgg4MPaU7084N8ihO74kytRUQHqGZBb0DwQ8tGAzNc2GjfJXF8Mu_mPg";

	private String workingStartupLocation = "C:\\Users\\Varun Waiskar\\Desktop\\Spring Software Pvt\\pagenationDemo (1).csv";
	private String jobServeLocation = "C:\\Users\\Varun Waiskar\\Desktop\\Spring Software Pvt\\jobServeDeveloperJobs.csv";
	
	
	@GetMapping("/")
	public String book() throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		List<UpdateUserReferralRequest> list= new ReadFile().getJobsList(JobPortal.WorkingStartup, workingStartupLocation);
		
		  HttpHeaders headers = new HttpHeaders(); headers.add("Authorization", token);
		  headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		  
		  MultiValueMap<String, String> map; HttpEntity<MultiValueMap<String, String>>
		  request; ResponseEntity<UpdateUserReferralRequest> response;
		  List<UpdateUserReferralRequest> respList = new
		  ArrayList<UpdateUserReferralRequest>();
		  
		  int i = 1;
		  
		 for(UpdateUserReferralRequest req : list) {
			 
			 if(i++ <= 179)
				 continue;
			 
		  map = new LinkedMultiValueMap<String, String>();
		  
		  map.add("referralDetails", req.getReferralDetails()); 
		  map.add("referralType", req.getReferralType().toString() ); 
		  map.add("referralTargetSubject", req.getReferralTargetSubject() ); 
		  map.add("referralTargetEmail", req.getReferralTargetEmail()); 
		  map.add("jobType", req.getJobType());
		  map.add("jobLocation", req.getJobLocation() ); 
		  map.add("previewType", req.getPreviewType().toString());
		  map.add("previewLink",req.getPreviewLink()); 
		  map.add("refPublic", req.isRefPublic() + "" );
		  map.add("bountyEnable", req.isBountyEnable() + "" ); map.add("jobCompany",
		  req.getJobCompany());
		  
		  request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		  
		  response = restTemplate.postForEntity( url, request ,UpdateUserReferralRequest.class );
		  
		  System.out.println(req.getReferralTargetSubject() +"\t"+req.getJobCompany());
		  
		  respList.add(response.getBody());
		  
		  // interval taken for posting job
		  Thread.sleep(3000);
		  
		  }
		  
		  
		return "posted";

	}
	
	@GetMapping("/excel")
	public List<CsvEntity> csvRead()throws Exception {
		ReadFile read =  new ReadFile();
		return read.readExcelFile("");
	}
	
	@GetMapping("/check")
	public String demoCheck()throws Exception {
		return "ok";
	}
	
}
