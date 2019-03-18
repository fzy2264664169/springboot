package com.fzy.domain;

public class InfoSform {

	private Integer sformId;
	private String serviceForm;
	public Integer getSformId() {
		return sformId;
	}
	public void setSformId(Integer sformId) {
		this.sformId = sformId;
	}
	public String getServiceForm() {
		return serviceForm;
	}
	public void setServiceForm(String serviceForm) {
		this.serviceForm = serviceForm;
	}
	@Override
	public String toString() {
		return "InfoSform [sformId=" + sformId + ", serviceForm=" + serviceForm + "]";
	}
	
}
