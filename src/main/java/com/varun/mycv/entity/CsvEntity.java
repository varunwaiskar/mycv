package com.varun.mycv.entity;

public class CsvEntity {

	private String referralType = "Job";

	// title
	private String jobTitle;
	
	// unknown?
	private String referralTargetEmail = "varun@gmail.com";

	private String jobType;

	private String jobLocation;

	// description i.e. salary
	private String referralDetails;

	private String jobCompany;

	// apply link
	private String previewLink;

	public String getReferralType() {
		return referralType;
	}

	public void setReferralType(String referralType) {
		this.referralType = referralType;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getReferralTargetEmail() {
		return referralTargetEmail;
	}

	public void setReferralTargetEmail(String referralTargetEmail) {
		this.referralTargetEmail = referralTargetEmail;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getReferralDetails() {
		return referralDetails;
	}

	public void setReferralDetails(String referralDetails) {
		this.referralDetails = referralDetails;
	}

	public String getJobCompany() {
		return jobCompany;
	}

	public void setJobCompany(String jobCompany) {
		this.jobCompany = jobCompany;
	}

	public String getPreviewLink() {
		return previewLink;
	}

	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}

	@Override
	public String toString() {
		return "CsvEntity [referralType=" + referralType + ", jobTitle=" + jobTitle + ", referralTargetEmail="
				+ referralTargetEmail + ", jobType=" + jobType + ", jobLocation=" + jobLocation + ", referralDetails="
				+ referralDetails + ", jobCompany=" + jobCompany + ", previewLink=" + previewLink + "]";
	}
	
	

}
