package com.varun.mycv.jobPortals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.opencsv.CSVReader;
import com.varun.mycv.entity.ReferralPreviewType;
import com.varun.mycv.entity.ReferralType;
import com.varun.mycv.entity.UpdateUserReferralRequest;

public class JobServe implements JobPortal {
	
	private String jobServeLocation = "C:\\Users\\Varun Waiskar\\Desktop\\Spring Software Pvt\\jobServeDeveloperJobs.csv";

	@Override
	public List<UpdateUserReferralRequest> getList(){
		
		try {
			CSVReader reader = new CSVReader(new FileReader(jobServeLocation));
			String[] nextLine;
			
			UpdateUserReferralRequest reqEntity = new UpdateUserReferralRequest();

			List<UpdateUserReferralRequest> list = new ArrayList<UpdateUserReferralRequest>();

			reader.readNext();

			while ((nextLine = reader.readNext()) != null) {

				reqEntity = new UpdateUserReferralRequest();

				reqEntity.setReferralType(ReferralType.JOB_SPEC);
				reqEntity.setReferralTargetEmail("randeep@mycvtracker.com");

				// description
				String desc[] = nextLine[12].split("<img src=");
				reqEntity.setReferralDetails(desc[0]);

				// title
				reqEntity.setReferralTargetSubject(nextLine[4]);

				reqEntity.setJobType(nextLine[11]);

				reqEntity.setJobLocation(nextLine[8]);

				reqEntity.setPreviewType(ReferralPreviewType.NONE);
				// reqEntity.setPreviewLink("");

				if (nextLine[9] != null) {

					reqEntity.setJobCompany(nextLine[9]);

					reqEntity.setReferralTargetSubject(nextLine[4] + " at " + nextLine[9]);
				}

				reqEntity.setRefPublic(false);
				reqEntity.setBountyEnable(false);

				list.add(reqEntity);

			}
			
			return list;

		}
		catch(Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("Exception in JobServe");
			
		}
		
		

	}

	

}
