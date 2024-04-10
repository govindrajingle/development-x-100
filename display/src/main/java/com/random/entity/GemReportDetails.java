package com.random.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gem_report_dtl")
public class GemReportDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sno;

	private String branch;
	private String regNo;
	private String validity;
	private String currentStatus;
	private String firm;
	private String standard;
	private String productName;
	private String variety;
	private String brand;
	private Integer isValid;
	private LocalDateTime logDt;
	private String requestType;
	private String applicationId;
	private String includedModels;
	private Integer bisId;
	private Double bisSortOrder;
	private String licenseNo;
	private String districtName;
	private String stateName;
	private String validityDate;
	private String scale;
	private String licenseGrantDate;
	private LocalDateTime regDate;
	private String strStatusCode;
	private String fullNameAndAddress;
	private String address;
	private String city;
	private String country;
	
	@Override
	public String toString() {
		return "BOOTCRSGemReportDetails [branch=" + branch + ", registrationNo=" + regNo + ", validity=" + validity + ", currentStatus=" + currentStatus + ", firmName=" + firm + ", standard=" + standard + ", productName=" + productName + ", brand=" + brand + ", bisId=" + bisId + ", variety=" + variety + "]";
	}
	
	public Long getSno() {
		return sno;
	}
	public void setSno(Long sno) {
		this.sno = sno;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getFirm() {
		return firm;
	}
	public void setFirm(String firm) {
		this.firm = firm;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	public LocalDateTime getLogDt() {
		return logDt;
	}
	public void setLogDt(LocalDateTime logDt) {
		this.logDt = logDt;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getIncludedModels() {
		return includedModels;
	}
	public void setIncludedModels(String includedModels) {
		this.includedModels = includedModels;
	}
	public Integer getBisId() {
		return bisId;
	}
	public void setBisId(Integer bisId) {
		this.bisId = bisId;
	}
	public Double getBisSortOrder() {
		return bisSortOrder;
	}
	public void setBisSortOrder(Double bisSortOrder) {
		this.bisSortOrder = bisSortOrder;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getValidityDate() {
		return validityDate;
	}
	public void setValidityDate(String validityDate) {
		this.validityDate = validityDate;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getLicenseGrantDate() {
		return licenseGrantDate;
	}
	public void setLicenseGrantDate(String licenseGrantDate) {
		this.licenseGrantDate = licenseGrantDate;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	public String getStrStatusCode() {
		return strStatusCode;
	}
	public void setStrStatusCode(String strStatusCode) {
		this.strStatusCode = strStatusCode;
	}
	public String getFullNameAndAddress() {
		return fullNameAndAddress;
	}
	public void setFullNameAndAddress(String fullNameAndAddress) {
		this.fullNameAndAddress = fullNameAndAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	
}
