package com.fzy.domain;

public class ProLabor {

	private String refId;
	
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	private Integer laborId;
	private String servicerName;
	private Integer everyday5;
	private Integer weekendsday5;
	private Integer nationalday5;
	private String dutyNote;
	private Integer everyday7;
	private Integer weekendsday7;
	private Integer nationalday7;
	private Integer everyday24;
	private Integer weekendsday24;
	private Integer nationalday24;
	
	private Integer averageCost;
	private String servicerPosition;

	public Integer getLaborId() {
		return laborId;
	}

	public void setLaborId(Integer laborId) {
		this.laborId = laborId;
	}

	public String getServicerName() {
		return servicerName;
	}

	public void setServicerName(String servicerName) {
		this.servicerName = servicerName;
	}

	public Integer getEveryday5() {
		return everyday5;
	}

	public void setEveryday5(Integer everyday5) {
		this.everyday5 = everyday5;
	}

	public Integer getWeekendsday5() {
		return weekendsday5;
	}

	public void setWeekendsday5(Integer weekendsday5) {
		this.weekendsday5 = weekendsday5;
	}

	public Integer getNationalday5() {
		return nationalday5;
	}

	public void setNationalday5(Integer nationalday5) {
		this.nationalday5 = nationalday5;
	}

	public String getDutyNote() {
		return dutyNote;
	}

	public void setDutyNote(String dutyNote) {
		this.dutyNote = dutyNote;
	}

	public Integer getEveryday7() {
		return everyday7;
	}

	public void setEveryday7(Integer everyday7) {
		this.everyday7 = everyday7;
	}

	public Integer getWeekendsday7() {
		return weekendsday7;
	}

	public void setWeekendsday7(Integer weekendsday7) {
		this.weekendsday7 = weekendsday7;
	}

	public Integer getNationalday7() {
		return nationalday7;
	}

	public void setNationalday7(Integer nationalday7) {
		this.nationalday7 = nationalday7;
	}

	public Integer getEveryday24() {
		return everyday24;
	}

	public void setEveryday24(Integer everyday24) {
		this.everyday24 = everyday24;
	}

	public Integer getWeekendsday24() {
		return weekendsday24;
	}

	public void setWeekendsday24(Integer weekendsday24) {
		this.weekendsday24 = weekendsday24;
	}

	public Integer getNationalday24() {
		return nationalday24;
	}

	public void setNationalday24(Integer nationalday24) {
		this.nationalday24 = nationalday24;
	}

	public Integer getAverageCost() {
		return averageCost;
	}

	public void setAverageCost(Integer averageCost) {
		this.averageCost = averageCost;
	}

	public String getServicerPosition() {
		return servicerPosition;
	}

	public void setServicerPosition(String servicerPosition) {
		this.servicerPosition = servicerPosition;
	}

	@Override
	public String toString() {
		return "ProLabor [refId=" + refId + ", laborId=" + laborId + ", servicerName=" + servicerName + ", everyday5="
				+ everyday5 + ", weekendsday5=" + weekendsday5 + ", nationalday5=" + nationalday5 + ", dutyNote="
				+ dutyNote + ", everyday7=" + everyday7 + ", weekendsday7=" + weekendsday7 + ", nationalday7="
				+ nationalday7 + ", everyday24=" + everyday24 + ", weekendsday24=" + weekendsday24 + ", nationalday24="
				+ nationalday24 + ", averageCost=" + averageCost + ", servicerPosition=" + servicerPosition + "]";
	}
	
	
	
}
