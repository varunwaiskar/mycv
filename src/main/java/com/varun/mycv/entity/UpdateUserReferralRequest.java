package com.varun.mycv.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUserReferralRequest {

    private Long id;
    private String referralLink;
    private String referralDetails;
    private String referralTargetEmail;
    private String referralTargetSubject;
    private String jobLocation;
    private String jobType;
    private String jobCompany;
    private String previewLink;
    private MultipartFile previewFile;
    private boolean refPublic;
    private boolean bountyEnable;


    public UpdateUserReferralRequest() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferralLink() {
        return referralLink;
    }

    public void setReferralLink(String referralLink) {
        this.referralLink = referralLink;
    }

    public String getReferralDetails() {
        return referralDetails;
    }

    public void setReferralDetails(String referralDetails) {
        this.referralDetails = referralDetails;
    }

    public String getReferralTargetEmail() {
        return referralTargetEmail;
    }

    public void setReferralTargetEmail(String referralTargetEmail) {
        this.referralTargetEmail = referralTargetEmail;
    }

    public String getReferralTargetSubject() {
        return referralTargetSubject;
    }

    public void setReferralTargetSubject(String referralTargetSubject) {
        this.referralTargetSubject = referralTargetSubject;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
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

    public MultipartFile getPreviewFile() {
        return previewFile;
    }

    public void setPreviewFile(MultipartFile previewFile) {
        this.previewFile = previewFile;
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
}
