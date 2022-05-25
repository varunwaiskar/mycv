package com.varun.mycv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserReferral implements Serializable {

    private static final long serialVersionUID = 1L;

	private Long id;

    private Long userId;

    private String referralDetails;

    private String referralLink;

    private ReferralType referralType;

    private String referralTargetEmail;

    private String referralTargetSubject;

    private Long parentReferralId;

    private UserReferral parentReferral;

    private List<UserReferral> childReferrals;

    private LocalDateTime publishedDate;

    private String jobLocation;

    private String jobType;

    private String jobCompany;

    private ReferralPreviewType previewType;

    private String previewLink;

    private byte[] previewFile;

    private String previewFileType;

    private String previewFileName;

    private boolean refPublic;

    private boolean bountyEnable;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getReferralDetails() {
		return referralDetails;
	}

	public void setReferralDetails(String referralDetails) {
		this.referralDetails = referralDetails;
	}

	public String getReferralLink() {
		return referralLink;
	}

	public void setReferralLink(String referralLink) {
		this.referralLink = referralLink;
	}

	public ReferralType getReferralType() {
		return referralType;
	}

	public void setReferralType(ReferralType referralType) {
		this.referralType = referralType;
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

	public Long getParentReferralId() {
		return parentReferralId;
	}

	public void setParentReferralId(Long parentReferralId) {
		this.parentReferralId = parentReferralId;
	}

	public UserReferral getParentReferral() {
		return parentReferral;
	}

	public void setParentReferral(UserReferral parentReferral) {
		this.parentReferral = parentReferral;
	}

	public List<UserReferral> getChildReferrals() {
		return childReferrals;
	}

	public void setChildReferrals(List<UserReferral> childReferrals) {
		this.childReferrals = childReferrals;
	}

	public LocalDateTime getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDateTime publishedDate) {
		this.publishedDate = publishedDate;
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

	public ReferralPreviewType getPreviewType() {
		return previewType;
	}

	public void setPreviewType(ReferralPreviewType previewType) {
		this.previewType = previewType;
	}

	public String getPreviewLink() {
		return previewLink;
	}

	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}

	public byte[] getPreviewFile() {
		return previewFile;
	}

	public void setPreviewFile(byte[] previewFile) {
		this.previewFile = previewFile;
	}

	public String getPreviewFileType() {
		return previewFileType;
	}

	public void setPreviewFileType(String previewFileType) {
		this.previewFileType = previewFileType;
	}

	public String getPreviewFileName() {
		return previewFileName;
	}

	public void setPreviewFileName(String previewFileName) {
		this.previewFileName = previewFileName;
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

	@Override
	public String toString() {
		return "UserReferral [id=" + id + ", userId=" + userId + ", referralDetails=" + referralDetails
				+ ", referralLink=" + referralLink + ", referralType=" + referralType + ", referralTargetEmail="
				+ referralTargetEmail + ", referralTargetSubject=" + referralTargetSubject + ", parentReferralId="
				+ parentReferralId + ", parentReferral=" + parentReferral + ", childReferrals=" + childReferrals
				+ ", publishedDate=" + publishedDate + ", jobLocation=" + jobLocation + ", jobType=" + jobType
				+ ", jobCompany=" + jobCompany + ", previewType=" + previewType + ", previewLink=" + previewLink
				+ ", previewFile=" + Arrays.toString(previewFile) + ", previewFileType=" + previewFileType
				+ ", previewFileName=" + previewFileName + ", refPublic=" + refPublic + ", bountyEnable=" + bountyEnable
				+ "]";
	}

    


    

   
}
