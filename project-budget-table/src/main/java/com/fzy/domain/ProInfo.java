package com.fzy.domain;

import java.util.Date;


public class ProInfo {

	private String refId;
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	
	
	private Integer infoId;
	private String customerName;
	private String projectName;
	private String contractNumber;
	private String responseDepartment;
	private String projectManager;
	private Integer projectMoney;

	private Date applyDate;
	private Date startTime;
	private Date endTime;
	private InfoPtype infoPtype;
	private InfoPform infoPform;
	private InfoSform infoSform;
	
	
	private Integer ptypeId;
	private Integer pformId;
	private Integer sformId;
	
	public Integer getPtypeId() {
		return ptypeId;
	}
	public void setPtypeId(Integer ptypeId) {
		this.ptypeId = ptypeId;
	}
	public Integer getPformId() {
		return pformId;
	}
	public void setPformId(Integer pformId) {
		this.pformId = pformId;
	}
	public Integer getSformId() {
		return sformId;
	}
	public void setSformId(Integer sformId) {
		this.sformId = sformId;
	}
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	public String getResponseDepartment() {
		return responseDepartment;
	}
	public void setResponseDepartment(String responseDepartment) {
		this.responseDepartment = responseDepartment;
	}
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	public Integer getProjectMoney() {
		return projectMoney;
	}
	public void setProjectMoney(Integer projectMoney) {
		this.projectMoney = projectMoney;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public InfoPtype getInfoPtype() {
		return infoPtype;
	}
	public void setInfoPtype(InfoPtype infoPtype) {
		this.infoPtype = infoPtype;
	}
	public InfoPform getInfoPform() {
		return infoPform;
	}
	public void setInfoPform(InfoPform infoPform) {
		this.infoPform = infoPform;
	}
	public InfoSform getInfoSform() {
		return infoSform;
	}
	public void setInfoSform(InfoSform infoSform) {
		this.infoSform = infoSform;
	}
	@Override
	public String toString() {
		return "ProInfo [infoId=" + infoId + ", customerName=" + customerName + ", projectName=" + projectName
				+ ", contractNumber=" + contractNumber + ", responseDepartment=" + responseDepartment
				+ ", projectManager=" + projectManager + ", projectMoney=" + projectMoney + ", applyDate=" + applyDate
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", infoPtype=" + infoPtype + ", infoPform="
				+ infoPform + ", infoSform=" + infoSform + "]";
	}
	
}
