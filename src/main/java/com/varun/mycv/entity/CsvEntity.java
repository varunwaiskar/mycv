package com.varun.mycv.entity;

public class CsvEntity {

   // private Long id = (long)1893;

	
	// description
    private String referralDetails;
	
	private ReferralType referralType = ReferralType.JOB_SPEC;

	//title
    private String referralTargetSubject;

	//email
	private String referralTargetEmail = "randeep@mycvtracker.com";

	private String jobType;

	private String jobLocation;

    private ReferralPreviewType previewType = ReferralPreviewType.NONE;

    private boolean refPublic = false;
    
    private boolean bountyEnable = false;
	
	private String jobCompany;
	
	
	//Getters & Setters

	public String getReferralDetails() {
		return referralDetails;
	}

	public void setReferralDetails(String referralDetails) {
		this.referralDetails = referralDetails;
	}

	public ReferralType getReferralType() {
		return referralType;
	}

	public void setReferralType(ReferralType referralType) {
		this.referralType = referralType;
	}

	public String getReferralTargetSubject() {
		return referralTargetSubject;
	}

	public void setReferralTargetSubject(String referralTargetSubject) {
		this.referralTargetSubject = referralTargetSubject;
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

	public ReferralPreviewType getPreviewType() {
		return previewType;
	}

	public void setPreviewType(ReferralPreviewType previewType) {
		this.previewType = previewType;
	}

	public boolean isRefPublic() {
		return refPublic;
	}

	public void setRefPublic(boolean refPublic) {
		this.refPublic = refPublic;
	}

	public boolean isBountyEnable() {
		return bountyEnable;
	}

	public void setBountyEnable(boolean bountyEnable) {
		this.bountyEnable = bountyEnable;
	}

	public String getJobCompany() {
		return jobCompany;
	}

	public void setJobCompany(String jobCompany) {
		this.jobCompany = jobCompany;
	}

	@Override
	public String toString() {
		return "CsvEntity [referralDetails=" + referralDetails + ", referralType=" + referralType
				+ ", referralTargetSubject=" + referralTargetSubject + ", referralTargetEmail=" + referralTargetEmail
				+ ", jobType=" + jobType + ", jobLocation=" + jobLocation + ", previewType=" + previewType
				+ ", refPublic=" + refPublic + ", bountyEnable=" + bountyEnable + ", jobCompany=" + jobCompany + "]";
	}

	


}
