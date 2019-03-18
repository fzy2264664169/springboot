package com.fzy.domain;

import java.util.Date;

public class ProCost {
	
	private String refId;

	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	private Integer costId;
	private String subcontractContent;
	private String subcontractMessage;
	private Integer subcontractMoney;
	private String purchaseList;
	private Integer purchaseMoney;
	private String mainList;
	private Integer fragmentaryMoney;
	private String costBreakdown;
	private Integer costMoney;
	
	private String suggestion1;
	private String suggestion2;
	private String suggestion3;
	private String principalName;
	private Date principalDate;
	private String sectionName;
	private Date sectionDate;
	private String centerName;
	private Date centerDate;

	public Integer getCostId() {
		return costId;
	}
	public void setCostId(Integer costId) {
		this.costId = costId;
	}
	public String getSubcontractContent() {
		return subcontractContent;
	}
	public void setSubcontractContent(String subcontractContent) {
		this.subcontractContent = subcontractContent;
	}
	public String getSubcontractMessage() {
		return subcontractMessage;
	}
	public void setSubcontractMessage(String subcontractMessage) {
		this.subcontractMessage = subcontractMessage;
	}
	public Integer getSubcontractMoney() {
		return subcontractMoney;
	}
	public void setSubcontractMoney(Integer subcontractMoney) {
		this.subcontractMoney = subcontractMoney;
	}
	public String getPurchaseList() {
		return purchaseList;
	}
	public void setPurchaseList(String purchaseList) {
		this.purchaseList = purchaseList;
	}
	public Integer getPurchaseMoney() {
		return purchaseMoney;
	}
	public void setPurchaseMoney(Integer purchaseMoney) {
		this.purchaseMoney = purchaseMoney;
	}
	public String getMainList() {
		return mainList;
	}
	public void setMainList(String mainList) {
		this.mainList = mainList;
	}
	public Integer getFragmentaryMoney() {
		return fragmentaryMoney;
	}
	public void setFragmentaryMoney(Integer fragmentaryMoney) {
		this.fragmentaryMoney = fragmentaryMoney;
	}
	public String getCostBreakdown() {
		return costBreakdown;
	}
	public void setCostBreakdown(String costBreakdown) {
		this.costBreakdown = costBreakdown;
	}
	public Integer getCostMoney() {
		return costMoney;
	}
	public void setCostMoney(Integer costMoney) {
		this.costMoney = costMoney;
	}
	public String getSuggestion1() {
		return suggestion1;
	}
	public void setSuggestion1(String suggestion1) {
		this.suggestion1 = suggestion1;
	}
	public String getSuggestion2() {
		return suggestion2;
	}
	public void setSuggestion2(String suggestion2) {
		this.suggestion2 = suggestion2;
	}
	public String getSuggestion3() {
		return suggestion3;
	}
	public void setSuggestion3(String suggestion3) {
		this.suggestion3 = suggestion3;
	}
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}
	public Date getPrincipalDate() {
		return principalDate;
	}
	public void setPrincipalDate(Date principalDate) {
		this.principalDate = principalDate;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public Date getSectionDate() {
		return sectionDate;
	}
	public void setSectionDate(Date sectionDate) {
		this.sectionDate = sectionDate;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public Date getCenterDate() {
		return centerDate;
	}
	public void setCenterDate(Date centerDate) {
		this.centerDate = centerDate;
	}
	@Override
	public String toString() {
		return "ProCost [refId=" + refId + ", costId=" + costId + ", subcontractContent=" + subcontractContent
				+ ", subcontractMessage=" + subcontractMessage + ", subcontractMoney=" + subcontractMoney
				+ ", purchaseList=" + purchaseList + ", purchaseMoney=" + purchaseMoney + ", mainList=" + mainList
				+ ", fragmentaryMoney=" + fragmentaryMoney + ", costBreakdown=" + costBreakdown + ", costMoney="
				+ costMoney + ", suggestion1=" + suggestion1 + ", suggestion2=" + suggestion2 + ", suggestion3="
				+ suggestion3 + ", principalName=" + principalName + ", principalDate=" + principalDate
				+ ", sectionName=" + sectionName + ", sectionDate=" + sectionDate + ", centerName=" + centerName
				+ ", centerDate=" + centerDate + "]";
	}
	
	
	
	
}
